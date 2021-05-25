package group21;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import org.jfree.chart.JFreeChart;

/**
 * Analysis5 implements "Average of Government expenditure on education, total (% of GDP) for the selected years"
 * @author group21 
 * 
 */
public class Analysis5 implements Analysis {
	String iso; 
	int start, end; 
	Data rawData; 
	Data computedData; // 
	String analcode; 
	private Viewers_Line line;
	private Viewer_Scatter scatter;
	private Viewers_Area Area;
	private Viewers_Bubble Bubble;
	private Viewers_Pie pie;
	private Viewers_Bar bar;
	private JFreeChart jfree; 
	private String title = "Average of Government expenditure on education, total (% of GDP) for the selected years";
	private String series1 = "Expenditure %"; 
	
	/**
	 * Constructor which initiates the data reads and sets member variables 
	 * @param user
	 */
	public Analysis5(Selection user) {
		iso = user.getCountry(); 
		start = user.getStart();
		end = user.getEnd(); 
		analcode = user.getAnalsis();
		
		Reader reader = new Reader(iso, analcode, start, end);
		
		rawData = reader.getRaw(); 
		calculate();
		bar = new Viewers_Bar(rawData, "Years", "Values", title, series1);
		
		pie = new Viewers_Pie(rawData, "Years", "Values", title);
		
		Area = new Viewers_Area(rawData, "years", "values", title, series1);
		Bubble = new Viewers_Bubble(rawData, "years", "values", title, series1);
		
		
	}
	
	public Viewers_Line getLine() {
		return line;
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
	 * No calculation is done for this anaylsis typ, just set computed data to rawdata 
	 */
	public void calculate() {
		// TODO Auto-generated method stub
		computedData = rawData; 
	}

	@Override 
	/**
	 * Make a line chart 
	 */
	public JFreeChart makeLineChart() {
		return null;
	}

	@Override
	/**
	 * Make a scatter chart 
	 */
	public JFreeChart makeScatterChart() {
		return null;

	}

	@Override
	/**
	 * Make a pie chart 
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
	 * Not used in this analysis type 
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
	 * Make a bar chart 
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
//		Selection test = new Selection();
//		test.setAnal("SE.XPD.TOTL.GD.ZS");
//		test.setCountry("can");
//		test.setTime(1960, 2005); 
//		Analysis5 a4 = new Analysis5(test); 
//		a4.calculate(); 
//		a4.makePieChart();
//		a4.makeLineChart();
//		a4.makeBarChart();
//		a4.makeScatterChart();
	}

}
