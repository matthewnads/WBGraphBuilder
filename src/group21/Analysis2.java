package group21;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import org.jfree.chart.JFreeChart;

/**
 * Analysis2 implements the "PM2.5 air pollution, mean annual exposure (�g/cubic meter) vs Forest area (% of land area)" anaylsis
 * Implements anaylsis interface 
 * @author group21 
 *
 */
public class Analysis2 implements Analysis {
	
	private Data data1, data2;
	private String iso, ID1, ID2;
	private int start, end;
	private Viewers_Line line;
	private Viewer_Scatter scatter;
	private Viewers_Area Area;
	private Viewers_Bubble Bubble;
	private Viewers_Pie pie;
	private Viewers_Bar bar;
	private String title = "PM2.5 air pollution, mean annual exposure (�g/cubic meter) vs Forest area (% of land area)"; 
	private String series1 = "Mean Annual Exposure"; 
	private String series2 = "Forest Area % ";

	/**
	 * Anaylsis1 constructor using the Selection object as an input, and creates Readers to conduct data acquisition
	 * @param userSel
	 */
	public Analysis2 (Selection userSel) {
		// TODO Auto-generated method stub
		ID1 = userSel.getAnalsis();
		ID2 = userSel.getAnalsis2();
		iso = userSel.getCountry();
		start= userSel.getStart();
		end = userSel.getEnd();		
		Reader reader1 = new Reader(iso, ID1, start, end);
		data1 = reader1.getRaw();	
		Reader reader2 = new Reader(iso, ID2, start, end);
		data2 = reader2.getRaw();		
		scatter = new Viewer_Scatter(data1, data2,  "years", "values", title, series1, series2); 
		bar = new Viewers_Bar( data1, data2, "years", "values", title, series1, series2);
		line = new Viewers_Line(data1, data2,  "years", "values", title, series1, series2);
		Area = new Viewers_Area(data1, data2,  "years", "values", title, series1, series2);
	}
	@Override
	/**
	 * no calculation done in this analysis type 
	 */
	public void calculate() {
		// TODO Auto-generated method stub
	}
 
	/**
	 * @return viewers_line for line chart 
	 */
	public Viewers_Line getLine() {
		return line;
	}
	
	/**
	 * @return viewers_scatter for scatter chart
	 */
	public Viewer_Scatter getScat() {
		return scatter;
		
	}
	
	/**
	 * @return {@link Viewers_Area} for area chart 
	 */
	public Viewers_Area  getArea() {
		return Area;
	}
	
	/**
	 * @returns {@link Viewers_Bubble} for bubble charts 
	 */
	public Viewers_Bubble getBubble() {
		return Bubble;
	}
	
	/**
	 * @returns {@link Viewers_Pie} for pie charts 
	 */
	public Viewers_Pie getPie() {
		return pie;
	}
	
	/**
	 * @return {@link Viewers_Bar} for bar charts 
	 */
	public Viewers_Bar getBar() {
		return bar;
	}
	
	@Override
	/**
	 * Makes a line chart
	 * @return jfreechart  
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
	@Override
	/**
	 * Makes a scatter plot 
	 * @return jfreechart 
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
	@Override
	/**
	 * Makes a pie chart (not used in this analysis type) 
	 */
	public JFreeChart makePieChart() {
		return null;
		
	}
	@Override
	/**
	 * Makes a bubble chart 
	 */
	public JFreeChart makeBubbleChart() {
		return null;
		
	
	}
	@Override
	/**
	 * Makes an area chart 
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
	@Override
	/**
	 * Makes a bar chart  
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
	
//	public static void main(String[] args) {
//		Selection test = new Selection("EN.ATM.CO2E.PC", "EG.USE.PCAP.KG.OE");
//		test.setCountry("can");
//		test.setTime(1960, 2005);
//		Analysis2 a2 = new Analysis2(test);
//		System.out.println(a2.makeLineChart());
//	}
	
	
}
