package group21;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
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
 * Viewers_Area class creates the Area chart using user selections 
 * @author matth
 *
 */
public class Viewers_Area extends JFrame{
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
	 * Constructor for one data object 
	 * @param data1
	 * @param x_label
	 * @param y_label
	 * @param title
	 */
	public Viewers_Area(Data data1, String x_label, String y_label, String title, String series1) {
		data = data1;
		status = false;
		this.x_label = x_label; 
		this.y_label = y_label; 
		this.title= title; 
		this.series1 = series1; 
	}
	
	/**
	 * constructor for two data objects 
	 * @param data1
	 * @param data2
	 * @param x_label
	 * @param y_label
	 * @param title
	 */
	public Viewers_Area(Data data1, Data data2, String x_label, String y_label, String title, String series1, String series2) {
		data = data1;
		this.data2 = data2; 
		status = false;
		this.x_label = x_label; 
		this.y_label = y_label; 
		this.title= title; 
		this.series1 = series1; 
		this.series2 = series2; 
		
	}
	
	/**
	 * Constructor for three data objects 
	 * @param data1
	 * @param data2
	 * @param data3
	 * @param x_label
	 * @param y_label
	 * @param title
	 */
	public Viewers_Area(Data data1, Data data2, Data data3, String x_label, String y_label, String title, String series1, String series2, String series3) {
		data = data1;
		this.data2 = data2; 
		this.data3 = data3; 
		status = false;
		this.x_label = x_label; 
		this.y_label = y_label; 
		this.title= title; 
		this.series1 = series1;
		this.series2 = series2; 
		this.series3 = series3; 
		
	}
	
	
	
	/****************************************************AREA CHART******************************************/
	
	/**
	 * Populate area chart as jfreechart object 
	 * @param series
	 */
	public void populateArea(int series) {
		chart = createArea(series); 
		ChartPanel chartPanel = new ChartPanel(chart); 
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel); 
        pack(); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	
	
	/**
	 * Populates the area chart into a jframe 
	 * @param kind
	 * @return
	 */
	public JFreeChart createArea(int kind) {
		//CategoryDataset dataset = createAreaDataset() ; 
		DefaultCategoryDataset dataset = createMSDatasetArea(kind);
		//MultiValueCategoryDataset dataset = createMVAreaDataset(1); 
		JFreeChart jfreechart = ChartFactory.createAreaChart(title, x_label, y_label, dataset, PlotOrientation.VERTICAL, false, true, true); 
		CategoryPlot plot = (CategoryPlot) jfreechart.getPlot(); 
		
		

        return jfreechart; 
	}
	
	
	/******************************************************************/
	
	/**
	 * Making dataset to be used to populate jfreechart object  
	 *
	 */
	private DefaultCategoryDataset createMSDatasetArea(int kind) {
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
		
		//add value (VALUE, SERIES, X AXIS)
		
		for (int i=0; i< data.getValues().size(); i++)
			dataset.addValue(data.getValues().get(i), series1, data.getYears().get(i));
		
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
	 * this method runs if user selects it 
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
	 

	/**
	 * checks if user has selected 
	 * @return
	 */
	public void setStatus(Boolean theStatus) {
		status = theStatus;
	}
	
	public Boolean getStatus() {
		return status;
	}
	  
	
	
	
	

}
