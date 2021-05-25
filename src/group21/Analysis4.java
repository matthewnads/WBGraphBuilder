package group21;

import java.awt.EventQueue;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jfree.chart.JFreeChart;

/**
 * Analysis for average forest area % for selected years 
 * 
 *
 */
public class Analysis4 implements Analysis {
	String iso; 
	int start, end; 
	Data rawData; 
	Data computedData; 
	String analcode; 
	String title = "Average Forest Area % for Selected Years"; 
	private Viewer_Scatter scatter;
	private Viewers_Area Area;
	private Viewers_Bubble Bubble;
	private Viewers_Pie pie;
	private Viewers_Bar bar;
	private JPanel p;
	private String series1 = "Area %";
	
	public Analysis4(Selection user) {
		iso = user.getCountry();  
		start = user.getStart();
		end = user.getEnd(); 
		analcode = user.getAnalsis();
		
		Reader reader = new Reader(iso, analcode, start, end);
		rawData = reader.getRaw(); 
		
		bar = new Viewers_Bar( rawData, "years", "values", title, series1);
		Area = new Viewers_Area(rawData, "years", "values", title, series1 );
		Bubble = new Viewers_Bubble(rawData, "years", "values", title, series1 );
		pie = new Viewers_Pie(rawData, "years", "values", title );
	}
	
	@Override
	
	/**
	 * Calulation not done in this analysis type so we just set computedData to rawData 
	 */
	public void calculate() {
		// TODO Auto-generated method stub
		computedData = rawData; 
	
	}

	public Viewers_Line getLine() {
		return null;
	}
	
	
	public Viewer_Scatter getScat() {
		return scatter;
		
	}
	public Viewers_Area  getArea() {
		return Area;
	}
	public Viewers_Bubble getBubble() {
		return Bubble;
	}
	public Viewers_Pie getPie() {
		return pie;
	}
	public Viewers_Bar getBar() {
		return bar;
	}
	
	@Override
	/**
	 * line chart not used in this type 
	 */
	public JFreeChart makeLineChart() {
		return null;

	}

	@Override
	/**
	 * Scatter chart not used in this type
	 */
	public JFreeChart makeScatterChart() {
		return null;
		
	}

	@Override
	
	/**
	 * Makes Pie chart 
	 */
	public JFreeChart makePieChart() {
		if (pie.getStatus() == false) {
			JFreeChart h =	pie.createChart();
			pie.setStatus(true);
			return h;
		}
		else {
			JOptionPane.showMessageDialog(null,"Pie chart is already added", "Error!", JOptionPane.INFORMATION_MESSAGE);
		}
		return null;
		
	}

	@Override
	/**
	 * Makes bubble chart 
	 */
	public JFreeChart makeBubbleChart() {
		if (Bubble.getStatus() == false) {
			JFreeChart h =	Bubble.createBubble(1);
			Bubble.setStatus(true);
			return h;
		}
		else {
			JOptionPane.showMessageDialog(null,"Bubble chart is already added", "Error!", JOptionPane.INFORMATION_MESSAGE);
		}
		return null;
	}

	@Override
	
	/**
	 * Makes area chart 
	 */
	public JFreeChart makeAreaChart() {
		if (Area.getStatus() == false) {
			JFreeChart h =	Area.createArea(1);
			Area.setStatus(true);
			return h;
		}
		else {
			JOptionPane.showMessageDialog(null,"Area chart is already added", "Error!", JOptionPane.INFORMATION_MESSAGE);
		}
		return null;
	}

	@Override
	
	/**
	 * Makes bar chart 
	 */
	public JFreeChart makeBarChart() {
		if (bar.getStatus() == false) { 
			JFreeChart h = bar.createChart(1);
			bar.setStatus(true);
			return h;
			}
		else {
			JOptionPane.showMessageDialog(null,"Bar chart is already added", "Error!", JOptionPane.INFORMATION_MESSAGE);
		}
		return null;
	}
	public static void main(String[] args) {
		Selection test = Selection.getInstance(); 
		test.setAnal("AG.LND.FRST.ZS");
		test.setCountry("can");
		test.setTime(1960, 2005);  
		Analysis4 a4 = new Analysis4(test); 
		a4.calculate(); 
		//a4.makePieChart(); 
		//a4.makeAreaChart();
		//a4.makeBarChart();
		//a4.makeBubbleChart();
		a4.makeScatterChart();
	}
}
