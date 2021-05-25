package group21;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.jfree.chart.JFreeChart;

/**
 * Analysis3 implements the "Ratio of CO2 emissions (MT/capita) and GDP per capita (current US$)" analysis. 
 * @author group21 
 *
 */
public class Analysis3 implements Analysis {
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
	private String series1 = "Ratio of Emissions to GDP per Capita";
	private String title = "Ratio of CO2 emissions (MT/capita) and GDP per capita (current US$)";
	/**
	 * Constructor which creates Readers to start data acquisition   
	 * @param userSel
	 */
	public Analysis3(Selection userSel) {
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
		scatter = new Viewer_Scatter(calData,  "years", "values", title, series1); 
		bar = new Viewers_Bar(calData, "years", "values", title, series1);
		line = new Viewers_Line(calData, "years", "values", title, series1);
		Area = new Viewers_Area(calData, "years", "values", title, series1);
		Bubble = new Viewers_Bubble(calData, "years", "values", title, series1);
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
	}


	@Override
	/**
	 * Makes line chart with computed data 
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
	
	/**
	 * Makes scatter plot from computed data 
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
	
	
	/**
	 * Pie chart not used in this analysis type 
	 * @return 
	 */
	public JFreeChart makePieChart() {
		return null;
     

	}
	@Override
	/**
	 * Bubble chart made using calculated data 
	 */
	public JFreeChart makeBubbleChart() {
		return null;
		
	
		
	} 
	/**
	 * Makes Area chart using calculated data 
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
	 * Makes Bar chart using calculated data  
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
	
//	public static void main(String[] args) {
//		Selection test = new Selection("SE.XPD.TOTL.GD.ZS", "SH.XPD.CHEX.GD.ZS");
//		test.setCountry("aus");
//		test.setTime(2000, 2010); 
//		Analysis6 ex = new Analysis6(test);
//		ex.calculate();
//		ex.makeScatterChart();
//	 }
	
	
}
