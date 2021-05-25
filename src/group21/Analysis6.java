package group21;


import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.jfree.chart.JFreeChart;

/**
 * Anaylsis6: Ratio of Hospital beds (per 1,000 people) and Current health expenditure (per 1,000 people).
 * @author group21  
 *
 */
	public class Analysis6 implements Analysis {
		private Data data1, data2, calData;
		private String iso, Ind, Ind2;
		private int start, end;
		private Viewers_Line line;
		private Viewer_Scatter scatter;
		private Viewers_Area Area;
		private Viewers_Bubble Bubble;
		private Viewers_Pie pie;
		private Viewers_Bar bar;
		private JFreeChart jfree; 
		private String title = "Anaylsis6: Ratio of Hospital beds (per 1,000 people) and Current health expenditure (per 1,000 people)"; 
		private int s;
		private String series1 = "Ratio Hospital Beds to Health Expenditure";
	/**
	* Anaylsis6 constructor using the Selection object as an input, and creates Readers to conduct data acquisition
	* @param userSel
	*/	
	public Analysis6(Selection userSel) {
		Ind = userSel.getAnalsis();
		Ind2 = userSel.getAnalsis2();
		iso = userSel.getCountry();
		start = userSel.getStart();
		end = userSel.getEnd();
		Reader reader1 = new Reader(iso, Ind, start, end);
		data1 = reader1.getRaw();
		Reader reader2 = new Reader(iso, Ind2, start, end);
		data2 = reader2.getRaw();
		calculate();
		line = new Viewers_Line(calData, "years", "values", title, series1);
		bar = new Viewers_Bar( calData, "years", "values",title, series1);
		scatter = new Viewer_Scatter(calData, "years", "values", title, series1);
		Area = new Viewers_Area(calData, "years", "values", title,series1 );

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
			s = s1Years.size();
			sy = s1Years;
			by = s2Years;
		}
		else {
			s = s2Years.size();
			sy = s2Years;
			by = s1Years;
		}

		
		for (int i =0; i < s; i++) {
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
		
	

		public static void main(String[] args) {
			Selection test = new Selection("SE.XPD.TOTL.GD.ZS", "SH.XPD.CHEX.GD.ZS");
			test.setCountry("aus");
			test.setTime(2000, 2010); 
			Analysis6 ex = new Analysis6(test);
			ex.calculate();
			ex.makeScatterChart();
		 }

		@Override
		public JFreeChart makePieChart() {
			// TODO Auto-generated method stub
			return jfree;
		}

		@Override
		public JFreeChart makeBubbleChart() {
			// TODO Auto-generated method stub
			return jfree;
		}

		@Override
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

	}



