package group21;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.AreaRendererEndType;
import org.jfree.chart.renderer.category.AreaRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DatasetUtils;
import org.jfree.data.statistics.DefaultMultiValueCategoryDataset;
import org.jfree.data.statistics.MultiValueCategoryDataset;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;

/**
 * Bubble viewer class which creates the bubble chart   
 * @author group21 
 *
 */
public class Viewers_Bubble extends JFrame{
	private Boolean status; 
	private JFreeChart chart;
	private Data data,data2,data3;
	private String x_label, y_label, title; 
	private Data[] moredata; 
	private String[] x_labels, ylabels, titles; 
	private String series1;
	private String series2;
	private String series3;
	
	/**
	 * Constructor with one data object 
	 * @param data1
	 * @param x_label
	 * @param y_label
	 * @param title
	 */
	public Viewers_Bubble(Data data1, String x_label, String y_label, String title, String series1) {
		data = data1;
		status = false;
		this.x_label = x_label; 
		this.y_label = y_label; 
		this.title= title; 
		this.series1 = series1; 
		
	}
	 
	/**
	 * Constructor with 2 data objects 
	 * @param data1
	 * @param data2
	 * @param x_label
	 * @param y_label
	 * @param title
	 */
	public Viewers_Bubble(Data data1, Data data2, String x_label, String y_label, String title , String series1, String series2) {
		data = data1;
		this.data2 = data2; 
		status = false;
		this.x_label = x_label; 
		this.y_label = y_label; 
		this.title= title; 
		this.series1 = series1 ; this.series2 = series2; 
	}
	
	/**
	 * Constructor with three data objects 
	 * @param data1
	 * @param data2
	 * @param data3
	 * @param x_label
	 * @param y_label
	 * @param title
	 */
	public Viewers_Bubble(Data data1, Data data2, Data data3, String x_label, String y_label, String title, String series1, String series2, String series3) {
		data = data1;
		this.data2 = data2; 
		this.data3 = data3; 
		status = false;
		this.x_label = x_label; 
		this.y_label = y_label; 
		this.title= title; 
		this.series1 = series1; this.series2 =series2; this.series3 = series3; 
	}
	
	/**
	 * Add functions means that the user has selected it 
	 */
	public void add() {
		status = true;
	}
	
	/**
	 * setData sets the data object into the viewer 
	 * @param item
	 */
	public void setData(Data item) {
		data = item;
	}

	/**
	 * gets the status as true or false to see if it's chosen 
	 * @return
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
	 
	/****************************************************BUBBLE CHART CREATION******************************************/
	
	/**
	 * Creates a dataset of int kind series to be used for the jfreechart 
	 * @param kind
	 * @return
	 */
	private XYZDataset createBubbleDataset(int kind) {
		DefaultXYZDataset dataset = new DefaultXYZDataset(); 
		
		double[] x = new double[data.getValues().size()];
		double[] y = new double[data.getValues().size()];
		double[] z = new double[data.getValues().size()];

		for (int i=0; i< data.getValues().size(); i++) {
			y[i] = data.getYears().get(i).doubleValue(); 
			x[i] = data.getValues().get(i).doubleValue();
			z[i] = data.getValues().get(i).doubleValue();
		}
		
		double xyz[][] = {x,y,z};
		dataset.addSeries(series1, xyz);
		
		if(kind>1) {
			double[] x2 = new double[data2.getValues().size()];
    	    double[] y2 = new double[data2.getValues().size()]; 
    		double[] z2 = new double[data2.getValues().size()];
    		for (int i=0; i< data2.getValues().size(); i++) {
    			y2[i] = data.getYears().get(i).doubleValue(); 
    			x2[i] = data.getValues().get(i).doubleValue();
    			z2[i] = data.getValues().get(i).doubleValue();
    		}
    		double xyz2[][] = {x,y,z};
    		dataset.addSeries(series2, xyz2);
    		if(kind ==3) {
    			double[] x3 = new double[data3.getValues().size()];
        	    double[] y3 = new double[data3.getValues().size()]; 
        		double[] z3 = new double[data3.getValues().size()];
        		
        		for (int i=0; i< data3.getValues().size(); i++) {
        			y3[i] = data3.getYears().get(i).doubleValue(); 
        			x3[i] = data3.getValues().get(i).doubleValue();
        			z3[i] = data3.getValues().get(i).doubleValue();
        		}
    		}
		}				
		return dataset;
	}
	
	/**
	 * Creates a jfreechart object representing the bubble chart 
	 * @param kind
	 * @return
	 */
	public JFreeChart createBubble(int kind) {
		XYZDataset dataset = createBubbleDataset(kind); 
		JFreeChart jfreechart = ChartFactory.createBubbleChart( title, y_label, x_label, dataset, PlotOrientation.HORIZONTAL, true, true, false);

	    	         
	    	      XYPlot xyplot = ( XYPlot )jfreechart.getPlot( );                 
	    	      xyplot.setForegroundAlpha( 0.65F );                 
	    	      XYItemRenderer xyitemrenderer = xyplot.getRenderer( );
	    	     // xyitemrenderer.setSeriesPaint( 0 , Color.blue );                 
	    	      xyitemrenderer.setSeriesFillPaint(data.getValues().size(), null);
	    	      NumberAxis domain = ( NumberAxis )xyplot.getDomainAxis(); 
	    	      //domain.setRange();
	    	      domain.setLowerMargin( 0.2 );                 
	    	      domain.setUpperMargin( 0.5 );                 
	    	      NumberAxis range = ( NumberAxis )xyplot.getRangeAxis();                 
	    	      range.setLowerMargin( 0.8 );                 
	    	      range.setUpperMargin( 0.9 );
	    	      domain.setRange(0, Collections.max(data.getValues())*2);               
	    	      return jfreechart; 
	}
	
	/**
	 * Populates the bubble chart into a jframe  
	 * @param kind
	 */
	public void populateBubble(int kind) {
		chart = createBubble(kind); 
		ChartPanel chartPanel = new ChartPanel(chart); 
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel); 
        
        pack(); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		 
//		String country = "afg"; 
//		String analy = "AG.LND.FRST.ZS";
//		int start = 1990; int end = 2001;
//		Reader test = new Reader(country, analy, start, end) ; 
//		Data raw = test.getRaw();
//		String analy1 = "EN.ATM.CO2E.PC";
//		
//		Reader test1 = new Reader(country, analy1, 1960, 2001) ; 
//		Data raw1 = test1.getRaw();
//		
//		String analy2 = "EN.ATM.PM25.MC.M3";
//		Reader test2 = new Reader(country, analy2, 1960, 2001) ; 
//		Data raw3 = test2.getRaw();
// 
//		EventQueue.invokeLater(() -> {
//			Viewers3 ex = new Viewers3(raw, raw1, raw3, "years", "values", "Line");
//			ex.populateBubble(1);
//			ex.setVisible(true);
//		});
	}

}
