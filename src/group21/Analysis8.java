package group21;


import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.jfree.chart.JFreeChart;

/**
 * Anaylsis8: The analysis for Ratio of Government expenditure on education, total (% of GDP) vs Current health expenditure (% of GDP). 
 * @author group21  
 *
 */
public class Analysis8 implements Analysis{
	private Data data1, data2, calData;
	private String iso, ID1, ID2;
	private int start, end;
	private Viewers_Line line;
	private Viewer_Scatter scatter;
	private Viewers_Area Area;
	private Viewers_Bubble Bubble;
	private Viewers_Pie pie;
	private Viewers_Bar bar;
	private int small;
	private String title = "Ratio of Government expenditure on education, total (% of GDP) vs Current health expenditure (% of GDP)";
	private JFreeChart jfree; 
	private String series1 = "Expenditure on Education"; 
	private String series2 = "Expenditure on Health"; 
	/**
	 * Anaylsis8 constructor using the Selection object as an input, and creates Readers to conduct data acquisition 
	 * @param userSel
	 */
	public Analysis8(Selection userSel) {
		ID1 = userSel.getAnalsis();
		ID2 = userSel.getAnalsis2();
		iso = userSel.getCountry();
		start = userSel.getStart();
		end = userSel.getEnd();
		Reader reader1  = new Reader(iso, ID1, start, end) ; 
		data1 = reader1.getRaw();
		Reader reader2 = new Reader(iso, ID2, start, end) ; 
		data2 = reader2.getRaw();
		calculate();
		scatter = new Viewer_Scatter(calData, "Years", "values", title, series1);
		line = new Viewers_Line(calData, "Years", "Values", title, series1);
		Area = new Viewers_Area(calData, "years", "values", title, series1);
		bar = new Viewers_Bar( calData, "Years", "Values", title, series1);


	}
	
	@Override
	/**
	 * Calculation for the ratio between the two selected data entries. 
	 */
	public void calculate() {
		calData = new Data();
		ArrayList<Integer> s1Years = data1.getYears();
		ArrayList<Float> s1Val = data1.getValues();
		ArrayList<Integer> s2Years = data2.getYears();
		ArrayList<Float> s2Val = data2.getValues();
		ArrayList<Integer> sy;
		ArrayList<Integer> by;

		if (s1Years.size() < s2Years.size()) { 
			small = s1Years.size(); 
			sy = s1Years;
			by = s2Years;
		}
		else {
			small = s2Years.size(); 
			sy = s2Years;
			by = s1Years;
		}

		
		for (int i =0; i < small; i++) { 
			Integer year = sy.get(i);
			
			if (by.contains(year)) { 
				if (sy == s1Years) { 
					int j = s2Years.indexOf(year);
					float ratio = s1Val.get(i) / s2Val.get(j);
					calData.addValue(ratio);
					calData.addYear(year);	
				}
				else { 
					int j = s1Years.indexOf(year);
					float ratio = s1Val.get(j) / s2Val.get(i);
					calData.addValue(ratio);
					calData.addYear(year);						
				}
			}
		}
		
		// TODO Auto-generated method stub

	}

	@Override
	/**
	 * Makes line chart 
	 */
	public JFreeChart makeLineChart() {
		if (line.getStatus() == false) {
			JFreeChart h = line.createLineChart(1);
			line.setStatus(true);
				return h;
			}
		else {
			JOptionPane.showMessageDialog(null,"Line chart is already added", "Error!", JOptionPane.INFORMATION_MESSAGE); 
		}
		return null;
	}

	@Override
	/**
	 * Makes scatter plot 
	 */
	public JFreeChart makeScatterChart() {
		if (scatter.getStatus() == false) {
			JFreeChart h = scatter.createScatterChart(1);
			scatter.setStatus(true);
			return h;
		}
		else {
			JOptionPane.showMessageDialog(null,"Scatter chart is already added", "Error!", JOptionPane.INFORMATION_MESSAGE);
		}
		return null;
	}

	@Override
	/**
	 * this chart is not made in this analysis type 
	 */
	public JFreeChart makePieChart() {
		// TODO Auto-generated method stub
		return jfree; 
	}

	@Override
	/**
	 * this chart is not made in this anaylsis type  
	 */
	public JFreeChart makeBubbleChart() {
		// TODO Auto-generated method stub
		return jfree; 
	}

	@Override
	/**
	 * Makes area chart 
	 */
	public JFreeChart makeAreaChart() {
		if (Area.getStatus() == false) {
			JFreeChart h = Area.createArea(1);
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
	 * makes bar chart 
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
	public static void main(String[] args) {
		Selection test = new Selection("SE.XPD.TOTL.GD.ZS", "SH.XPD.CHEX.GD.ZS");
		test.setCountry("can");
		test.setTime(1990, 2005);
		Analysis8 yo = new Analysis8(test);
		yo.calculate();
		yo.makeBarChart();
	 }

}
