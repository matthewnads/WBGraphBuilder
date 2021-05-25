package group21;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DatasetUtils;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;

/**
 * Pie viewer class which creates the pie chart   
 * @author group21 
 * 
 */
public class Viewers_Pie extends JFrame{
	private Boolean status; 
	private JFreeChart test;
	private Data data;

	private int series; 
	private String title; 
	
	/**
	 * Constructor with one data object 
	 * @param data1
	 * @param x_label
	 * @param y_label
	 * @param title
	 */
	public Viewers_Pie(Data data1, String title, String string, String string2) {
		data = data1;

		status = false;
		this.title= title; 
       
    }
	
	/**
	 * Initializes the dataset and develops UI for pi chart
	 * @param kind
	 * @return
	 */
	private void initUI() {
		 PieDataset dataset = createDataset();

	        JFreeChart chart = createChart();
	        ChartPanel chartPanel = new ChartPanel(chart);
	        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
	        chartPanel.setBackground(Color.white);
	        add(chartPanel);

	        pack();
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

		/**
		 * Creates a dataset of int kind series to be used for the jfreechart 
		 * @param kind
		 * @return
		 */
		 private DefaultPieDataset createDataset() {
	    	DefaultPieDataset dataset = new DefaultPieDataset();
	        for(int i=0;i<data.getValues().size();i++) {
	        	dataset.setValue(data.getValues().get(i), data.getYears().get(i));
	        }
	        return dataset; 
	    }

	     /**
		 * Creates a jfreechart object representing the pie chart  
		 * @param kind
		 * @return
		 */
	    public JFreeChart createChart() {

	    	PieDataset dataset1 = (PieDataset) createDataset() ;
	        JFreeChart jfreechart = ChartFactory.createPieChart(title, dataset1, true, true, false); 
	        PiePlot plot = (PiePlot) jfreechart.getPlot(); 
	        plot.setForegroundAlpha(0.3f);
	        return jfreechart;
	    }
	    
 
	    public static void main(String[] args) {
	    	String country = "can"; 
			String analy = "AG.LND.FRST.ZS";
			int start = 2010; int end = 2017;
			Reader test = new Reader(country, analy, start, end) ; 
			Data raw = test.getRaw();
	    
	        EventQueue.invokeLater(() -> {

	            Viewers_Pie ex = new Viewers_Pie( raw, "Years", "Values", "Area");
	            ex.initUI();
	            ex.setVisible(true);
	        });
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
}