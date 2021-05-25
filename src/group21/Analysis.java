package group21;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/**
 * Analysis interface for making different calculations and populating different charts, for use of factory design pattern
 * 
 *
 */
public interface Analysis {
	
	/**
	 * Does optional calculations on raw data - different for each anaylsis class. This represents a strategy design pattern  
	 */
	public void calculate();
	
	/**
	 * makes a line chart 
	 */
	public JFreeChart makeLineChart();
	
	/**
	 * makes a scatter chart 
	 */
	public JFreeChart makeScatterChart();
	
	/**
	 * makes pie chart 
	 */
	public JFreeChart makePieChart();
	
	/**
	 * makes bubble chart 
	 */
	public JFreeChart makeBubbleChart();
	
	/**
	 * makes area chart 
	 */
	public JFreeChart makeAreaChart();
	
	/**
	 * makes bar chart 
	 */
	public JFreeChart makeBarChart();
	
	/**
	 * returns viewer object for line graph 
	 * @return
	 */
	public Viewers_Line getLine();
	/**
	 * returns viewer object for scatter graph 
	 * @return
	 */
	public Viewer_Scatter getScat();
	/**
	 * returns viewer object for area graph 
	 * @return
	 */
	public Viewers_Area  getArea();
	/**
	 * returns viewer object for bubble graph 
	 * @return
	 */
	public Viewers_Bubble getBubble();
	/**
	 * returns viewer object for pie graph 
	 * @return
	 */
	public Viewers_Pie getPie();
	/**
	 * returns viewer object for bar graph 
	 * @return
	 */
	public Viewers_Bar getBar();
	
}
