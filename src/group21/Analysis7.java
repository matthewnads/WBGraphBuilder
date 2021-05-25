package group21;

 
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.jfree.chart.JFreeChart;

/**
 * Anaylsis7: Current health expenditure per capita (current US$) vs Mortality rate, infant (per 1,000 live births) (2-series graphs). 
 * @author group21  
 *
 */
	public class Analysis7 implements Analysis {

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
		private String title = "Current health expenditure per capita (current US$) vs Mortality rate, infant (per 1,000 live births)";
		private String series1 = "Health Expenditure"; 
		private String series2 = "Mortality rate" ;
	/**
	* Anaylsis7 constructor using the Selection object as an input, and creates Readers to conduct data acquisition
	* @param userSel
	*/
	public Analysis7(Selection userSel) {
		Ind = userSel.getAnalsis();
		Ind2 = userSel.getAnalsis2();
		iso = userSel.getCountry();
		start = userSel.getStart();
		end = userSel.getEnd();
		Reader reader1 = new Reader(iso, Ind, start, end);
		data1 = reader1.getRaw();
		Reader reader2 = new Reader(iso, Ind2, start, end);
		data2 = reader2.getRaw();
		line = new Viewers_Line(data1, data2, "years", "values", title, series1, series2);
		bar = new Viewers_Bar(data1, data2, "years", "values", title, series1 , series2);
		scatter = new Viewer_Scatter(data1, data2, "years", "values", title, series1, series2);
		Area = new Viewers_Area(data1, data2, "years", "values", title, series1, series2);

		}
		
		/** 
		 * No calculation necessary.  
		 */		
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
		
		
		public void calculate() {
		
		}
		
		@Override
		/**
		 * Makes line chart  
		 */
		public JFreeChart makeLineChart() {
			if (line.getStatus() == false) {
				JFreeChart h =line.createLineChart(2);
				line.setStatus(true);
			return h;
			}
			else {
				JOptionPane.showMessageDialog(null,"Line chart is already added", "Error!", JOptionPane.INFORMATION_MESSAGE);
			}
			return null;
		} 
		
		/**
		 * gets the status of the viewer (if the user wants to see it or not) 
		 * @return boolean 
		 */
		public JFreeChart makeBarChart() {
			if (bar.getStatus() == false) { 
				JFreeChart h = bar.createChart(2);
				bar.setStatus(true);
				return h;
				}
			else {
				JOptionPane.showMessageDialog(null,"Bar chart is already added", "Error!", JOptionPane.INFORMATION_MESSAGE);
			}
			return null;
		}
		
		/**
		 * gets the status of the viewer (if the user wants to see it or not) 
		 * @return boolean
		 */ 	
		public JFreeChart makeAreaChart() {
			if (Area.getStatus() == false) {
				JFreeChart h =	Area.createArea(2);
				Area.setStatus(true);
				return h;
			}
			else {
				JOptionPane.showMessageDialog(null,"Area chart is already added", "Error!", JOptionPane.INFORMATION_MESSAGE);
			}
			return null;
		}
		
		/** 
		 * gets the status of the viewer (if the user wants to see it or not) 
		 * @return boolean
		 */
		public JFreeChart makeScatterChart() {
			if (scatter.getStatus() == false) {
				JFreeChart h =	scatter.createScatterChart(2);
				scatter.setStatus(true);
				return h;
			}
			else {
				JOptionPane.showMessageDialog(null,"Scatter chart is already added", "Error!", JOptionPane.INFORMATION_MESSAGE);
			}
			return null;
			
		}
		
		/**
		 * gets the status of the viewer (if the user wants to see it or not) 
		 * @return boolean
		 */ 
		public boolean areaStatus() {
			return Area.getStatus();
		}
		
		/**
		 * gets the status of the viewer (if the user wants to see it or not) 
		 * @return boolean 
		 */
		public boolean barStatus() {
			return bar.getStatus();
		}

		/**
		 * gets the status of the Viewer (if the user wants to see it or not) 
		 * @return boolean 
		 */
		public boolean lineStatus() {
			return line.getStatus();
		}
		
		/** 
		 * gets the status of the viewer (if the user wants to see it or not) 
		 * @return boolean
		 */
		public boolean ScatterStatus() {
			return scatter.getStatus();
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
		
		public static void main(String[] args) {
			Selection test = new Selection("SE.XPD.TOTL.GD.ZS", "SH.XPD.CHEX.GD.ZS");
			test.setCountry("aus");
			test.setTime(2000, 2010);
			Analysis7 ex = new Analysis7(test);
			ex.calculate();
			ex.makeScatterChart();
		 }

	}



