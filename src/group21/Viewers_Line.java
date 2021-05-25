package group21;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.DecimalFormat;

/**
 * Line viewer class which creates the line chart   
 * @author group21 
 *
 */
public class Viewers_Line extends JFrame {

	private Boolean status; 
	private JFreeChart chart;
	private Data data, data2, data3;
	private String x_label, y_label, title; 
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
	public Viewers_Line(Data data1, String x_label, String y_label, String title, String series1) {
		data = data1;
		status = false;
		this.x_label = x_label; 
		this.y_label = y_label; 
		this.title= title; 
		this.series1 = series1 ; 
		
	}
	
	/**
	 * Constructor with 2 data objects 
	 * @param data1
	 * @param data2
	 * @param x_label
	 * @param y_label
	 * @param title
	 */
	public Viewers_Line(Data data1, Data data2, String x_label, String y_label, String title, String series1, String series2) {
		data = data1;
		status = false;
		this.data2 = data2;
		this.x_label = x_label; 
		this.y_label = y_label; 
		this.title= title; 
		this.series1 = series1 ; 
		this.series2 = series2; 
		
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
	public Viewers_Line(Data data1, Data data2, Data data3, String x_label, String y_label, String title, String series1, String series2, String series3) {
		data = data1;
		status = false;
		this.data2 = data2;
		this.data3 = data3;
		this.x_label = x_label; 
		this.y_label = y_label; 
		this.title= title; 
		this.series1 = series1; this.series2 = series2; this.series3 = series3; 
		
	}
	
	/**
	 * Populates the line chart into a jframe 
	 * @param kind
	 */ 
    public void populateLine(int kind) {
        chart = createLineChart(kind);
        ChartPanel chartPanel = new ChartPanel(chart); 
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle(title);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //dataset creator
    private XYDataset createLineDataset(int kind) {
    	DefaultXYDataset dataset = new DefaultXYDataset();
	    double[] x = new double[data.getValues().size()];
	    double[] y = new double[data.getValues().size()];	       
	    for (int i = 0; i < data.getValues().size(); i++) {   	   
	    	x[i] = data.getYears().get(i).doubleValue(); 
	    	y[i] = data.getValues().get(i).doubleValue();
	    }	       
	    double xy[][] = {x,y};
	    dataset.addSeries(series1, xy);    	
	    
	    if (kind == 1) {
    		return dataset;
    	}
	    
    	else if (kind >= 2) {
    	    double[] x2 = new double[data2.getValues().size()];
    	    double[] y2 = new double[data2.getValues().size()];    	       
    	    for (int i = 0; i < data2.getValues().size(); i++) {   	   
    	    	x2[i] = data2.getYears().get(i).doubleValue(); 
    	    	y2[i] = data2.getValues().get(i).doubleValue();
    	    }    
    	    double xy2[][] = {x2,y2};
    	    dataset.addSeries(series2, xy2);
    	    if (kind == 3) { 
        	    double[] x3 = new double[data3.getValues().size()];
        	    double[] y3 = new double[data3.getValues().size()];
        	       
        	    for (int i = 0; i < data3.getValues().size(); i++) {   	   
        	    	x3[i] = data3.getYears().get(i).doubleValue(); 
        	    	y3[i] = data3.getValues().get(i).doubleValue();
        	    }        	       
        	    double xy3[][] = {x3,y3};
        	    dataset.addSeries(series3, xy3);
        		
        	}
    	}
	    	
	    return dataset;

    }
    
    /**
	 * Creates a jfreechart object representing the line chart 
	 * @param kind
	 * @return
	 */ 
    public JFreeChart createLineChart(int kind) {
    	XYDataset dataset = createLineDataset(kind);
        JFreeChart chart = ChartFactory.createXYLineChart( title, x_label, y_label,dataset,PlotOrientation.VERTICAL, true, true, false);
    	XYPlot plot = chart.getXYPlot();
    	
    	ValueAxis domainAxis = plot.getDomainAxis();
    	domainAxis.setLowerMargin(1);
    	domainAxis.setUpperMargin(1);
    	domainAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
    	final NumberAxis domainAxis1 = (NumberAxis)chart.getXYPlot().getDomainAxis();
    	final DecimalFormat format = new DecimalFormat("####");
    	domainAxis1.setNumberFormatOverride(format);
    	
    	XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        if (kind >= 2) {
        	renderer.setSeriesPaint(1, Color.BLUE);
            renderer.setSeriesStroke(1, new BasicStroke(2.0f));
            if (kind ==3) {
            	renderer.setSeriesPaint(2, Color.GREEN);
                renderer.setSeriesStroke(2, new BasicStroke(2.0f));
            }
        }
        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);
        return chart;
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
	 
    public static void main(String[] args) {

    	String country = "can"; 
		String analy = "EG.USE.PCAP.KG.OE";
		int start = 1960; int end = 2001;
		Reader test = new Reader(country, analy, start, end) ; 
		Data raw = test.getRaw();
		String analy1 = "EN.ATM.CO2E.PC";
		
		Reader test1 = new Reader(country, analy1, 1960, 2001) ; 
		Data raw1 = test1.getRaw();
		
		String analy2 = "EN.ATM.PM25.MC.M3";
		Reader test2 = new Reader(country, analy2, 1960, 2001) ; 
		Data raw3 = test2.getRaw();
//		EventQueue.invokeLater(() -> {
//			Viewers_Line ex = new Viewers_Line( raw, raw1,raw3, "years", "values", "Line");
//			ex.populateLine(3);
//			ex.setVisible(true);
//			}); 
        
    }
}