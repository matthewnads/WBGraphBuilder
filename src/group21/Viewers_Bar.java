package group21;

import java.awt.Color;
import java.awt.EventQueue;


import javax.swing.BorderFactory;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle; 

import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Viewers_Bar is the viewer class for bar charts 
 * @author group21
 *
 */
public class Viewers_Bar extends JFrame{
	private Boolean status; 
	private JFreeChart chart;
	private Data data, data2, data3;
	private String x_label, y_label, title; 
	private String series1;
	private String series2;
	private String series3;
	
	/**
	 * Constructor for one data object 
	 * @param data1
	 * @param x_label
	 * @param y_label
	 * @param title
	 */
	public Viewers_Bar( Data data1, String x_label, String y_label, String title, String series1) {
		data = data1;
		status = false;
		this.x_label = x_label; 
		this.y_label = y_label; 
		this.title= title; 
		this.series1 = series1; 
		
		//it should be called on button click to create pie graph
		// but  for now just create the graph when the frame appears
	}
	
	/**
	 * Constructor for 2 data objects 
	 * @param data1
	 * @param data2
	 * @param x_label
	 * @param y_label
	 * @param title
	 */
	public Viewers_Bar( Data data1, Data data2, String x_label, String y_label, String title, String series1, String series2) {
		data = data1;
		status = false;
		this.data2 = data2;
		this.x_label = x_label; 
		this.y_label = y_label; 
		this.title= title; 
		this.series1 = series1; 
		this.series2 = series2; 
	}
	
	/**
	 * Constructor for 3 data objects 
	 * @param data1
	 * @param data2
	 * @param data3
	 * @param x_label
	 * @param y_label
	 * @param title
	 */
	public Viewers_Bar( Data data1, Data data2, Data data3, String x_label, String y_label, String title, String series1, String series2, String series3) {
		data = data1;
		status = false;
		this.data2 = data2;
		this.data3 = data3;
		this.x_label = x_label; 
		this.y_label = y_label; 
		this.title= title; 
		this.series1 = series1; 
		this.series2 = series2; 
		this.series3 = series3; 
		
	}
	
		
	/**
	 * Creates the bar chart and adds it to a jframe 
	 * @param kind
	 */
	    public void populateBar(int kind) {   

	    	chart = createChart(kind);
	        ChartPanel chartPanel = new ChartPanel(chart);
	        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
	        chartPanel.setBackground(Color.white);
	        add(chartPanel);
	        setContentPane(chartPanel);
	        pack();
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
	    
	    /**
	     * Creates a dataset to be used by jfreechart object 
	     * @param kind
	     * @return
	     */
	    private DefaultCategoryDataset createDataset(int kind) {
	    	DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
			
			//add value (VALUE, SERIES, X AXIS)
			
			for (int i=0; i< data.getValues().size(); i++)
				dataset.addValue(data.getValues().get(i),series1, data.getYears().get(i));
			
			if(kind>1) {
				for (int i=0; i< data2.getValues().size(); i++)
					dataset.addValue(data2.getValues().get(i), series2, data2.getYears().get(i));
				
				if(kind ==3) {
					for (int i=0; i< data3.getValues().size(); i++)
						dataset.addValue(data3.getValues().get(i), series3, data3.getYears().get(i));
				}
			}
			
			return dataset; 
	    }

	    /**
	     * creates and returns the jfreechart bar chart object 
	     * @param kind
	     * @return
	     */
	    public JFreeChart createChart(int kind) {
	    	
	    	DefaultCategoryDataset dataset1 = createDataset(kind) ;
	    	JFreeChart chart = ChartFactory.createBarChart(title, x_label, y_label, dataset1, PlotOrientation.HORIZONTAL, true, true, false);
	        CategoryPlot plot = (CategoryPlot) chart.getPlot(); 
	 
	        BarRenderer br = new BarRenderer();
	        
	        br.setMaximumBarWidth(.35);
	        plot.setRenderer(br);
	        plot.setForegroundAlpha(0.3f);
	        return chart;
	        		    }
	    /**
	     * Add is run when user selects this viewer to be populated 
	     */
	public void add() {
		status = true;
	}
	
	/**
	 * sets the data 
	 * @param item
	 */
	public void setData(Data item) {
		data = item;
	}
	
	/*
	 * public String getType() { return type; } 
	 */
	public Boolean getStatus() {
		return status;
	}
	 
	/**
	 * sets the status  
	 * @return
	 */
	public void setStatus(Boolean theStatus) {
		status = theStatus;
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

    	String country = "can"; 
		String analy = "EG.USE.PCAP.KG.OE";
		int start = 1960; int end = 1970;
		Reader test = new Reader(country, analy, start, end) ; 
		Data raw = test.getRaw();
		String analy1 = "EN.ATM.CO2E.PC";
		
		Reader test1 = new Reader(country, analy1, 1960, 1970) ; 
		Data raw1 = test1.getRaw();
		
		String analy2 = "EN.ATM.PM25.MC.M3";
		Reader test2 = new Reader(country, analy2, 1960, 1970) ; 
		Data raw3 = test2.getRaw();
		
//		EventQueue.invokeLater(() -> {
//			Viewers_Bar ex = new Viewers_Bar( raw, raw1,raw3, "years", "values", "Line");
//			ex.populateBar(3);
//			ex.setVisible(true);
//			});
		
 
	}

}