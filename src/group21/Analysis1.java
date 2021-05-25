package group21;

import java.awt.EventQueue;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
/**
 * Analysis1 implements the "CO2 emissions (MT/capita) vs Energy use (kg of oil equivalent/capita) vs PM2.5 air pollution, mean annual exposure" analysis 
 * @author group21
 *
 */
public class Analysis1 implements Analysis{
	
	private Data data1, data2, data3;
	private String iso, ID1, ID2, ID3;
	private int start, end;
	private Viewers_Line line;
	private Viewer_Scatter scatter;
	private Viewers_Area Area;
	private Viewers_Bubble Bubble;
	private Viewers_Pie pie;
	private Viewers_Bar bar;
	private JPanel p;
	private String series1 = "CO2 Emissions";
	private String series2 = "Energy Use"; 
	private String series3 = "Mean Annual Exposure"; 
	private String title = "CO2 emissions (MT/capita) vs Energy use (kg of oil equivalent/capita) vs PM2.5 air pollution, mean annual exposure";
	/**
	 * Constructor passing through user selection instance 
	 * @param userSel
	 */
	public Analysis1(Selection userSel) {
		ID1 = userSel.getAnalsis();
		ID2 = userSel.getAnalsis2();
		ID3 = userSel.getAnalsis3();
		iso = userSel.getCountry();
		start = userSel.getStart();
		end = userSel.getEnd();
		Reader reader1  = new Reader(iso, ID1, start, end) ; 
		data1 = reader1.getRaw();
		Reader reader2 = new Reader(iso, ID2, start, end) ; 
		data2 = reader2.getRaw();
		Reader reader3 = new Reader(iso, ID3, start, end) ; 
		data3 = reader3.getRaw();
		scatter = new Viewer_Scatter(data1, data2, data3, "Years", "Values", title, series1, series2, series3); 
		bar = new Viewers_Bar( data1, data2, data3, "Years", "Values", title,series1, series2, series3);
		line = new Viewers_Line(data1, data2, data3, "Yars", "Values", title,series1, series2, series3);
		Area = new Viewers_Area(data1, data2, data3, "Years", "Values", title,series1, series2, series3);

	}
	@Override
	/**
	 * No calculation is done on the data in this analysis type 
	 */
	public void calculate() {
		 
		 
 
	} 

	/**
	 * returns viewer object for line graph 
	 */
	public Viewers_Line getLine() {
		return line;
	}
	
	/**
	 * returns scatter plot viewer object 
	 */
	public Viewer_Scatter getScat() {
		return scatter;
		
	}
	
	/**
	 * returns area chart viewer object 
	 * 
	 */
	public Viewers_Area  getArea() {
		return Area;
	}
	
	/** 
	 * returns bubble chart for viewer object 
	 */
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
	 * makes JFreeChart object for line chart 
	 * @return JFreeChart 
	 */
	public  JFreeChart makeLineChart() {		
		if (line.getStatus() == false) {
			JFreeChart h =line.createLineChart(3);
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
	 * makes JfreeChart object for scatter plot 
	 * @return JFreeChart 
	 */
	public JFreeChart makeScatterChart() {
		if (scatter.getStatus() == false) {
			JFreeChart h =	scatter.createScatterChart(3);
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
	 * this chart isn't used for this analysis type 
	 */
	public JFreeChart makePieChart() {
		return null;
		// TODO Auto-generated method stub
		
	}
	@Override
	/**
	 * @return null since thischart is not made in this anaylsis 
	 */
	public JFreeChart makeBubbleChart() {
		return null;
	 	
	}
	@Override
	/**
	 * @return jfreechart area chart 
	 */
	public JFreeChart makeAreaChart() {
		if (Area.getStatus() == false) {
			JFreeChart h =	Area.createArea(3);
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
	 * @return jfreechart bar chart 
	 */
	public JFreeChart makeBarChart() {
		if (bar.getStatus() == false) { 
			JFreeChart h = bar.createChart(3);
			bar.setStatus(true);
			return h;
			}
		else {
			JOptionPane.showMessageDialog(null,"Bar chart is already added", "Error!", JOptionPane.INFORMATION_MESSAGE);
		}
		return null;
	}
	
	
	
//	public static void main(String[] args) {
//		Selection test = new Selection("EN.ATM.CO2E.PC", "EG.USE.PCAP.KG.OE", "EN.ATM.PM25.MC.M3");
//		test.setCountry("can");
//		test.setTime(2004, 2005);
//		Analysis1 yo = new Analysis1(test);
//		System.out.println(yo.status());
//		yo.makeScatterChart();
//		yo.makeLineChart();
//		yo.makeScatterChart();
//
//	 }

}
