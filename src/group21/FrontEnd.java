package group21;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import java.util.*;

/**
 * FrontEnd class contains client facing code, including some user interface components and action listeners.
 * @author group21
 *
 */
public class FrontEnd implements ActionListener{
//Frame and Panel
private JFrame frame;
private JPanel panel;
private JPanel botPan;

//Labels for dropdown menus 
private JLabel Country;
private JLabel start;
private JLabel end; 
private JLabel av;
private JLabel analysis;

//Buttons 
private JButton plus;
private JButton remove;
private JButton recal;

//Combobox / Dropdown menus
private JComboBox<String> ch_country;
private JComboBox<String> ch_start;
private JComboBox<String> ch_end;
private JComboBox<String> ch_view;
private JComboBox<String> ch_analysis;

//Arrays 
private String[] countries = {"      ", "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo", "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire", "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)", "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe", "Palestine"};
private String[] start_year = new String[62];
private String[] end_year = new String[62];
private String[] view_default = {"pie", "line", "bar", "scatter" };
private String[] a_Types = {"CO2 emissions (MT/capita) vs Energy use (kg of oil equivalent/capita) vs PM2.5 air pollution, mean annual exposure (�g/cubic meter)",
"PM2.5 air pollution, mean annual exposure (�g/cubic meter) vs Forest area (% of land area)"
, "Ratio of CO2 emissions (MT/capita) and GDP per capita (current US$)", 
"Average Forest area (% of land area) for the selected years", 
"Average of Government expenditure on education, total (% of GDP) for the selected years", 
"Ratio of Hospital beds (per 1,000 people) and Birth rate, crude (per 1,000 people)", 
"Current health expenditure per capita (current US$) vs Mortality rate, infant (per 1,000 live births)", 
"Ratio of Government expenditure on education, total (% of GDP) vs Current health expenditure (% of GDP)"};
private String[] SelectionChoice = new String[4]; //As user clicks choices from drobdown list  [ "Country Choice", "Year Start", "Year End", "Analysis Type"												//										     	SelectionChoice[0],   SelectionChoice[1]  SelectionChoice[2]   SelectionChoice[3]
private Selection userSel;
private Reader reader;
private HashMap<String, String> analysis_ind = new HashMap<String, String>();
private CountryISO c_iso = new CountryISO();

private Analysis1 a1;
private Analysis2 a2;
private Analysis3 a3;
private Analysis4 a4;
private Analysis5 a5;
private Analysis6 a6;
private Analysis7 a7;
private Analysis8 a8;
private JPanel chartpanel;
private JPanel[][] panelarry = new JPanel[2][2];
		



/**
 * populates hash map for indicators depending on analysis items
 */
private void pop_an() {
analysis_ind.put("CO2 emissions (MT/capita)", "EN.ATM.CO2E.PC");
analysis_ind.put("Energy use (kg of oil equivalent/capita)", "EG.USE.PCAP.KG.OE");
analysis_ind.put("PM2.5 air pollution, mean annual exposure (�g/cubic meter)", "EN.ATM.PM25.MC.M3");
analysis_ind.put("Average Forest area (% of land area)", "AG.LND.FRST.ZS");
analysis_ind.put("GDP per capita (current US$)", "NY.GDP.PCAP.CD");
analysis_ind.put("Government expenditure on education, total (% of GDP)", "SE.XPD.TOTL.GD.ZS");
analysis_ind.put("Hospital beds (per 1,000 people)", "SH.MED.BEDS.ZS");
analysis_ind.put("Birth rate, crude (per 1,000 people)", "SP.DYN.CBRT.IN");
analysis_ind.put("Current health expenditure per capita (current US$)", "SH.XPD.CHEX.PC.CD");
analysis_ind.put("Mortality rate, infant (per 1,000 live births)", "SP.DYN.IMRT.IN");
analysis_ind.put("Current health expenditure (% of GDP)", "SH.XPD.CHEX.GD.ZS");
}
	
	/**
	 * Main function that starts the program 
	 * @param args
	 */
	public static void main(String[] args) {
		FrontEnd a = new FrontEnd();
			
	}
	/**
	 * validates years chosen with analysis type 
	 * @param start
	 * @param end
	 */
	public void yearValidation(int start, int end) {
		userSel.setStart(start);
		userSel.setEnd(end);
		int analysis_Index = ch_analysis.getSelectedIndex();
		switch (analysis_Index ) {
		case 0: 
			String code = analysis_ind.get("CO2 emissions (MT/capita)"); 
			userSel.setAnal(code); 
			reader = new Reader(userSel);
			if (reader.yearsValid() == -1) {
				JOptionPane.showMessageDialog(null, "No Data for CO2 emissions (MT/capita) from " + SelectionChoice[1] + " to " + SelectionChoice[2] + "\nPlease select different range of years.", "Error!", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			code = analysis_ind.get("Energy use (kg of oil equivalent/capita)");
			userSel.setAnal(code);
			reader = new Reader(userSel);
			if (reader.yearsValid() == -1) {
				JOptionPane.showMessageDialog(null, "No Data for Energy use (kg of oil equivalent/capita) from " + SelectionChoice[1] + " to " + SelectionChoice[2] + "\nPlease select different range of years.", "Error!", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			code = analysis_ind.get("PM2.5 air pollution, mean annual exposure (�g/cubic meter)");
			userSel.setAnal(code);
			reader = new Reader(userSel);
			if (reader.yearsValid() == -1) {
				JOptionPane.showMessageDialog(null, "No data for PM2.5 air pollution, mean annual exposure (�g/cubic meter) from " + SelectionChoice[1] + " to " + SelectionChoice[2] + "\nPlease select different range of years.", "Error!", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			userSel.setAnal("EN.ATM.CO2E.PC");

			break; 
			
		case 1:
			code = analysis_ind.get("PM2.5 air pollution, mean annual exposure (�g/cubic meter)"); 
			userSel.setAnal(code); 	
			reader = new Reader(userSel);
			if (reader.yearsValid() == -1) {
				JOptionPane.showMessageDialog(null, "No data for PM2.5 air pollution, mean annual exposure (�g/cubic meter) from "  + SelectionChoice[1] + " to " + SelectionChoice[2] + "\nPlease select different range of years.", "Error!", JOptionPane.INFORMATION_MESSAGE);
				break;
			} 
			code = analysis_ind.get("Average Forest area (% of land area)");
			userSel.setAnal(code);
			reader = new Reader(userSel);
			if (reader.yearsValid() == -1) {
				JOptionPane.showMessageDialog(null, "No Data for Average Forest area (% of land area) from " + SelectionChoice[1] + " to " + SelectionChoice[2] + "\nPlease select different range of years.", "Error!", JOptionPane.INFORMATION_MESSAGE);
				break;
			}

			userSel.setAnal("EN.ATM.PM25.MC.M3");

			break;
			
		case 2:
			code = analysis_ind.get("CO2 emissions (MT/capita)"); 
			userSel.setAnal(code); 
			reader = new Reader(userSel);
			if (reader.yearsValid() == -1) {
				JOptionPane.showMessageDialog(null, "No Data for CO2 emissions (MT/capita) from "  + SelectionChoice[1] + " to " + SelectionChoice[2] + "\nPlease select different range of years.", "Error!", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			code = analysis_ind.get("GDP per capita (current US$)");
			userSel.setAnal(code);
			reader = new Reader(userSel);
			if (reader.yearsValid() == -1) {
				JOptionPane.showMessageDialog(null, "No Data for GDP per capita (current US$) from "  + SelectionChoice[1] + " to " + SelectionChoice[2] + "\nPlease select different range of years.", "Error!", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			userSel.setAnal("EN.ATM.CO2E.PC");

			break;

		case 3:
			code = analysis_ind.get("Average Forest area (% of land area)"); 
			userSel.setAnal(code); 
			reader = new Reader(userSel);
			if (reader.yearsValid() == -1) {
				JOptionPane.showMessageDialog(null, "No Data for Average Forest area (% of land area) from "  + SelectionChoice[1] + " to " + SelectionChoice[2] + "\nPlease select different range of years.", "Error!", JOptionPane.INFORMATION_MESSAGE);
				break;
			} 

			break;
			
		case 4:
			code = analysis_ind.get("Government expenditure on education, total (% of GDP)"); 
			userSel.setAnal(code);  				
			reader = new Reader(userSel);
			if (reader.yearsValid() == -1) {
				JOptionPane.showMessageDialog(null, "No data for average of Government expenditure on education, total (% of GDP) from " + SelectionChoice[0]+ " to " + SelectionChoice[2] + "\nPlease select a diffferent range of years.", "Error!", JOptionPane.INFORMATION_MESSAGE);
				break;
			} 

			break; 
			
		case 5:
			code = analysis_ind.get("Hospital beds (per 1,000 people)");
			userSel.setAnal(code);
			reader = new Reader(userSel);
			if (reader.yearsValid() == -1) {
				JOptionPane.showMessageDialog(null, "No Data for Hospital beds (per 1,000 people) from " + SelectionChoice[1]+ " to " + SelectionChoice[2]+ "\nPlease select a diffferent range of years.", "Error!", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			code = analysis_ind.get("Birth rate, crude (per 1,000 people)");
			userSel.setAnal(code);
			reader = new Reader(userSel);
			if (reader.yearsValid() == -1) {
				JOptionPane.showMessageDialog(null, "No Data for Birth rate, crude (per 1,000 people) from " + SelectionChoice[1]+ " to " + SelectionChoice[2] + "\nPlease select a diffferent range of years.", "Error!", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			userSel.setAnal("SH.MED.BEDS.ZS");
			break;
			
		case 6: 
			code = analysis_ind.get("Current health expenditure per capita (current US$)");
			userSel.setAnal(code);
			reader = new Reader(userSel);
			if (reader.yearsValid() == -1 ) {
				JOptionPane.showMessageDialog(null, "No data for current health expenditure per capita (current US$) from " + SelectionChoice[1]+ " to " + SelectionChoice[2] + "\nPlease select different years.", "Error!", JOptionPane.INFORMATION_MESSAGE);
				break;
			} 
			code = analysis_ind.get("Mortality rate, infant (per 1,000 live births)");
			userSel.setAnal(code);
			reader = new Reader(userSel);
			if (reader.yearsValid() == -1) {
				JOptionPane.showMessageDialog(null, "No data for mortality rate, infant (per 1,000 live births) from " + SelectionChoice[1]+ " to " + SelectionChoice[2] + "\nPlease select different years.", "Error!", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			userSel.setAnal("SH.XPD.CHEX.PC.CD");

			
		case 7:
			code = analysis_ind.get("Government expenditure on education, total (% of GDP)");
			userSel.setAnal(code);
			reader = new Reader(userSel);
			if (reader.yearsValid() == -1) {
				JOptionPane.showMessageDialog(null, "No Data for Government expenditure on education, total (% of GDP) from " + SelectionChoice[1]+ " to " + SelectionChoice[2] + "\nPlease select different years.", "Error!", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			code = analysis_ind.get("Current health expenditure (% of GDP)");
			userSel.setAnal(code);
			reader = new Reader(userSel);
			if (reader.yearsValid() == -1) {
				JOptionPane.showMessageDialog(null, "No Data for Current health expenditure (% of GDP) from " + SelectionChoice[1]+ " to " + SelectionChoice[2] + "\nPlease select different years.", "Error!", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			userSel.setAnal("SE.XPD.TOTL.GD.ZS");

			break;
		}
	}
	
	/**
	 * actionPerfromed Method: stores analysis type chosen  -> get the indicators for this spoecific analysis -> url all -> obtain list of all available countries -> wait for user to select country -> compare selected contry with list of availble countries 
	 * @author group21  
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == ch_country) {
			if (ch_country.getSelectedIndex() > 0) {
				SelectionChoice[0] = (String) ch_country.getSelectedItem();
				String ICode = c_iso.iso(SelectionChoice[0]);
				userSel = Selection.getInstance();
				userSel.setCountry(ICode); 
				userSel.setStart(1960); 
				userSel.setEnd(2020); 
			
				int analysis_Index = ch_analysis.getSelectedIndex();
				
				switch (analysis_Index ) {
				case 0: 
					String code = analysis_ind.get("CO2 emissions (MT/capita)"); 
					userSel.setAnal(code); 
					reader = new Reader(userSel);
					if (reader.countryValid() != 1) {
						JOptionPane.showMessageDialog(null, "No Data for CO2 emissions (MT/capita) " + SelectionChoice[0] + "\nPlease select a different country.", "Error!", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
					code = analysis_ind.get("Energy use (kg of oil equivalent/capita)");
					userSel.setAnal(code);
					reader = new Reader(userSel);
					if (reader.countryValid() != 1) {
						JOptionPane.showMessageDialog(null, "No Data for Energy use (kg of oil equivalent/capita) " + SelectionChoice[0] + "\nPlease select a different country.", "Error!", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
					code = analysis_ind.get("PM2.5 air pollution, mean annual exposure (�g/cubic meter)");
					userSel.setAnal(code);
					reader = new Reader(userSel);
					if (reader.countryValid() != 1) {
						JOptionPane.showMessageDialog(null, "No data for PM2.5 air pollution, mean annual exposure (�g/cubic meter) " + SelectionChoice[0]+ "\nPlease select a different country.", "Error!", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
					userSel.setAnal("EN.ATM.CO2E.PC");

					break; 
				case 1:
					code = analysis_ind.get("PM2.5 air pollution, mean annual exposure (�g/cubic meter)"); 
					userSel.setAnal(code); 	
					reader = new Reader(userSel);
					if (reader.countryValid() != 1) {
						JOptionPane.showMessageDialog(null, "No data for PM2.5 air pollution, mean annual exposure (�g/cubic meter) " + SelectionChoice[0]+ "\nPlease select a different country.", "Error!", JOptionPane.INFORMATION_MESSAGE);
						break;
					} 
					code = analysis_ind.get("Average Forest area (% of land area)");
					userSel.setAnal(code);
					reader = new Reader(userSel);
					if (reader.countryValid() != 1) {
						JOptionPane.showMessageDialog(null, "No Data for Average Forest area (% of land area) " + SelectionChoice[0]+ "\nPlease select a different country.", "Error!", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
					userSel.setAnal("EN.ATM.PM25.MC.M3");
				
					break;
				case 2:
					code = analysis_ind.get("CO2 emissions (MT/capita)"); 
					userSel.setAnal(code); 
					reader = new Reader(userSel);
					if (reader.countryValid() == -1) {
						JOptionPane.showMessageDialog(null, "No Data for CO2 emissions (MT/capita) " + SelectionChoice[0]+ "\nPlease select a different country.", "Error!", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
					code = analysis_ind.get("GDP per capita (current US$)");
					userSel.setAnal(code);
					reader = new Reader(userSel);
					if (reader.countryValid() == -1) {
						JOptionPane.showMessageDialog(null, "No Data for GDP per capita (current US$) " + SelectionChoice[0]+ "\nPlease select a different country.", "Error!", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
					userSel.setAnal("EN.ATM.CO2E.PC");

					break;
				//Validation check with country and analysis 
				case 3:
					code = analysis_ind.get("Average Forest area (% of land area)"); 
					userSel.setAnal(code); 
					reader = new Reader(userSel);
					if (reader.countryValid() == -1) {
						JOptionPane.showMessageDialog(null, "No Data for Average Forest area (% of land area) " + SelectionChoice[0]+ "\nPlease select a different country.", "Error!", JOptionPane.INFORMATION_MESSAGE);
						break;
					} 

					break; 
					
				case 4:
					code = analysis_ind.get("Government expenditure on education, total (% of GDP)"); 
					userSel.setAnal(code);  				
					reader = new Reader(userSel);
					if (reader.countryValid() == -1) {
						JOptionPane.showMessageDialog(null, "No data for average of Government expenditure on education, total (% of GDP) " + SelectionChoice[0]+ "\nPlease select a different country.", "Error!", JOptionPane.INFORMATION_MESSAGE);
						break;
					} 

					break; 
					
				case 5:
					code = analysis_ind.get("Hospital beds (per 1,000 people)");
					userSel.setAnal(code);
					reader = new Reader(userSel);
					if (reader.countryValid() == -1) {
						JOptionPane.showMessageDialog(null, "No Data for Hospital beds (per 1,000 people) " + SelectionChoice[0]+ "\nPlease select a different country.", "Error!", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
					code = analysis_ind.get("Birth rate, crude (per 1,000 people)");
					userSel.setAnal(code);
					reader = new Reader(userSel);
					if (reader.countryValid() == -1) {
						JOptionPane.showMessageDialog(null, "No Data for Birth rate, crude (per 1,000 people) " + SelectionChoice[0]+ "\nPlease select a different country.", "Error!", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
					userSel.setAnal("SH.MED.BEDS.ZS");

					break;
				case 6: 
					code = analysis_ind.get("Current health expenditure per capita (current US$)");
					userSel.setAnal(code);
					reader = new Reader(userSel);
					if (reader.countryValid() == -1 ) {
						JOptionPane.showMessageDialog(null, "No data for current health expenditure per capita (current US$) " + SelectionChoice[0]+ "\nPlease select a different country.", "Error!", JOptionPane.INFORMATION_MESSAGE);
						break;
					} 
					code = analysis_ind.get("Mortality rate, infant (per 1,000 live births)");
					userSel.setAnal(code);
					reader = new Reader(userSel);
					if (reader.countryValid() == -1) {
						JOptionPane.showMessageDialog(null, "No data for mortality rate, infant (per 1,000 live births) " + SelectionChoice[0]+ "\nPlease select a different country.", "Error!", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
					userSel.setAnal("SH.XPD.CHEX.PC.CD");
					break;
					
				case 7:
					code = analysis_ind.get("Government expenditure on education, total (% of GDP)");
					userSel.setAnal(code);
					reader = new Reader(userSel);
					if (reader.countryValid() == -1) {
						JOptionPane.showMessageDialog(null, "No Data for Government expenditure on education, total (% of GDP) " + SelectionChoice[0]+ "\nPlease select a different country.", "Error!", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
					code = analysis_ind.get("Current health expenditure (% of GDP)");
					userSel.setAnal(code);
					reader = new Reader(userSel);
					if (reader.countryValid() == -1) {
						JOptionPane.showMessageDialog(null, "No Data for Current health expenditure (% of GDP) " + SelectionChoice[0]+ "\nPlease select a different country.", "Error!", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
					userSel.setAnal("SE.XPD.TOTL.GD.ZS");
					break;
				}
			}
			
			
			
			
		}
		
		else if (e.getSource() == ch_start) {
			if (ch_country.getSelectedIndex() == 0) {
				ch_start.setSelectedIndex(0);
				JOptionPane.showMessageDialog(null,"Choose Country FIRST before making Start Year SelectionChoice!!", "Error!", JOptionPane.INFORMATION_MESSAGE);

			}
			else {
				SelectionChoice[1] = (String) ch_start.getSelectedItem();
				int start = Integer.parseInt(SelectionChoice[1]);

				if (ch_start.getSelectedIndex() > 0 && ch_end.getSelectedIndex() > 0 ) {
					int end = Integer.parseInt(SelectionChoice[2]);
					//Check that STart is before End
					if (start - end > 0) {
						JOptionPane.showMessageDialog(null,"Start year is larger than End year "+"\nPlease select a different range of years.", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						yearValidation(start, end);
					}
			}
			
			
				
	}
			
		}
		
		else if (e.getSource() == ch_end) {
			if (ch_country.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(null,"Choose Country FIRST before making End Year SelectionChoice!", "Error!", JOptionPane.INFORMATION_MESSAGE);
				ch_end.setSelectedIndex(0);
			}
			else {
				SelectionChoice[2] = (String) ch_end.getSelectedItem();
				int end = Integer.parseInt(SelectionChoice[2]);
				if (ch_start.getSelectedIndex() > 0 && ch_end.getSelectedIndex() > 0 ) {
					int start = Integer.parseInt(SelectionChoice[1]);
					if (start - end > 0) {
						JOptionPane.showMessageDialog(null,"Start year is larger than End year "+"\nPlease select a different range of years.", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						yearValidation(start, end);
						}
					}
				}
			}
		
			//MAKE SURE TO VALIDATE THAT START YEAR IS SMALLER THAN END YEAR

			//validation
		
		 
		  
		else if (e.getSource() == plus) {
			
			
			
			int analysisChoice = ch_analysis.getSelectedIndex();
			if (analysisChoice == 0 ) {
			//	int viewerChoice = ch_view.getSelectedIndex();
			
				int viewerChoice = ch_view.getSelectedIndex();
	            switch(viewerChoice) {
	           
	            case 0:
	            	JFreeChart fc = a1.makeLineChart();
					ChartPanel cp = new ChartPanel(fc);
					cp.setPreferredSize(new Dimension(650, 300));
					cp.setBackground(Color.white);
					cp.revalidate();
					panelarry[0][0].add(cp);
					panelarry[0][0].revalidate();
					break;
	            case 1:
	            	JFreeChart scatter = a1.makeScatterChart();
					ChartPanel scatter_cp = new ChartPanel(scatter);
					scatter_cp.setPreferredSize(new Dimension(650, 300));
					scatter_cp.setBackground(Color.white);
					scatter_cp.revalidate();
					panelarry[0][1].add(scatter_cp); 
					panelarry[0][1].revalidate();
					break;
	            case 2:
	            	JFreeChart bar = a1.makeBarChart();
					ChartPanel bar_cp = new ChartPanel(bar);
					bar_cp.setPreferredSize(new Dimension(650, 300));
					bar_cp.setBackground(Color.white);
					bar_cp.revalidate();
					panelarry[1][0].add(bar_cp);
					panelarry[1][0].revalidate();
					break;
	            case 3:
	            	JFreeChart area = a1.makeAreaChart();
					ChartPanel area_cp = new ChartPanel(area);
					area_cp.setPreferredSize(new Dimension(650, 300));
					area_cp.setBackground(Color.white);
					area_cp.revalidate();
					panelarry[1][1].add(area_cp);
					panelarry[1][1].revalidate();
					break;
	            }
			}
			 else if (analysisChoice == 1) {
				 int viewerChoice = ch_view.getSelectedIndex();
		            switch(viewerChoice) {
		           
		            case 0:
		            	JFreeChart fc = a2.makeLineChart();
		            	ChartPanel cp = new ChartPanel(fc);
		            	cp.setPreferredSize(new Dimension(650, 300));	
		            	cp.setBackground(Color.white);
						cp.revalidate();
						panelarry[0][0].add(cp);
						panelarry[0][0].revalidate();
						break;
						
		            case 1:
		            	JFreeChart scatter = a2.makeScatterChart();
						ChartPanel scatter_cp = new ChartPanel(scatter);
						scatter_cp.setPreferredSize(new Dimension(650, 300));
						scatter_cp.setBackground(Color.white);
						scatter_cp.revalidate();
						panelarry[0][1].add(scatter_cp); 
						panelarry[0][1].revalidate();
						break;

						
		            case 2:
		            	JFreeChart bar = a2.makeBarChart();
						ChartPanel bar_cp = new ChartPanel(bar);
						bar_cp.setPreferredSize(new Dimension(650, 300));
						bar_cp.setBackground(Color.white);
						bar_cp.revalidate();
						panelarry[1][0].add(bar_cp);
						panelarry[1][0].revalidate();
						break;
						
		            case 3:
		            	JFreeChart area = a2.makeAreaChart();
						ChartPanel area_cp = new ChartPanel(area);
						area_cp.setPreferredSize(new Dimension(650, 300));
						area_cp.setBackground(Color.white);
						area_cp.revalidate();
						panelarry[1][1].add(area_cp);
						panelarry[1][1].revalidate();
						break;
		            }
	            }
			 else if (analysisChoice == 2) {
				 int viewerChoice = ch_view.getSelectedIndex();
		            switch(viewerChoice) {
		           
		            case 0:
		            	JFreeChart fc = a3.makeLineChart();
		            	ChartPanel cp = new ChartPanel(fc);
		            	cp.setPreferredSize(new Dimension(650, 300));	
		            	cp.setBackground(Color.white);
						cp.revalidate();
						panelarry[0][0].add(cp);
						panelarry[0][0].revalidate();
						break;
						
		            case 1:
		            	JFreeChart scatter = a3.makeScatterChart();
						ChartPanel scatter_cp = new ChartPanel(scatter);
						scatter_cp.setPreferredSize(new Dimension(650, 300));
						scatter_cp.setBackground(Color.white);
						scatter_cp.revalidate();
						panelarry[0][1].add(scatter_cp); 
						panelarry[0][1].revalidate();
						break;

						
		            case 2:
		            	JFreeChart bar = a3.makeBarChart();
						ChartPanel bar_cp = new ChartPanel(bar);
						bar_cp.setPreferredSize(new Dimension(650, 300));
						bar_cp.setBackground(Color.white);
						bar_cp.revalidate();
						panelarry[1][0].add(bar_cp);
						panelarry[1][0].revalidate();
						break;
						
		            case 3:
		            	JFreeChart area = a3.makeAreaChart();
						ChartPanel area_cp = new ChartPanel(area);
						area_cp.setPreferredSize(new Dimension(650, 300));
						area_cp.setBackground(Color.white);
						area_cp.revalidate();
						panelarry[1][1].add(area_cp);
						panelarry[1][1].revalidate();
						break;
		            }
			 }
			 
			 else if (analysisChoice == 3) {
				 int viewerChoice = ch_view.getSelectedIndex();
		            switch(viewerChoice) {
		           
		            case 0:
		            	JFreeChart fc = a4.makePieChart();
		            	ChartPanel cp = new ChartPanel(fc);
		            	cp.setPreferredSize(new Dimension(650, 300));	
		            	cp.setBackground(Color.white);
						cp.revalidate();
						panelarry[0][0].add(cp);
						panelarry[0][0].revalidate();
						break;
						
		            case 1:
		            	JFreeChart bubble = a4.makeBubbleChart();
						ChartPanel bubble_cp = new ChartPanel(bubble);
						bubble_cp.setPreferredSize(new Dimension(650, 300));
						bubble_cp.setBackground(Color.white);
						bubble_cp.revalidate();
						panelarry[0][1].add(bubble_cp); 
						panelarry[0][1].revalidate();
						break;

						
		            case 2:
		            	JFreeChart bar = a4.makeBarChart();
						ChartPanel bar_cp = new ChartPanel(bar);
						bar_cp.setPreferredSize(new Dimension(650, 300));
						bar_cp.setBackground(Color.white);
						bar_cp.revalidate();
						panelarry[1][0].add(bar_cp);
						panelarry[1][0].revalidate();
						break;
						
		            case 3:
		            	JFreeChart area = a4.makeAreaChart();
						ChartPanel area_cp = new ChartPanel(area);
						area_cp.setPreferredSize(new Dimension(650, 300));
						area_cp.setBackground(Color.white);
						area_cp.revalidate();
						panelarry[1][1].add(area_cp);
						panelarry[1][1].revalidate();
						break;
		            }
			 }
			
			 else if (analysisChoice == 4) {
				 int viewerChoice = ch_view.getSelectedIndex();
		            switch(viewerChoice) {
		           
		            case 0:
		            	JFreeChart fc = a5.makePieChart();
		            	ChartPanel cp = new ChartPanel(fc);
		            	cp.setPreferredSize(new Dimension(650, 300));	
		            	cp.setBackground(Color.white);
						cp.revalidate();
						panelarry[0][0].add(cp);
						panelarry[0][0].revalidate();
						break;
						
		            case 1:
		            	JFreeChart bubble = a5.makeBubbleChart();
						ChartPanel bubble_cp = new ChartPanel(bubble);
						bubble_cp.setPreferredSize(new Dimension(650, 300));
						bubble_cp.setBackground(Color.white);
						bubble_cp.revalidate();
						panelarry[0][1].add(bubble_cp); 
						panelarry[0][1].revalidate();
						break;

						
		            case 2:
		            	JFreeChart bar = a5.makeBarChart();
						ChartPanel bar_cp = new ChartPanel(bar);
						bar_cp.setPreferredSize(new Dimension(650, 300));
						bar_cp.setBackground(Color.white);
						bar_cp.revalidate();
						panelarry[1][0].add(bar_cp);
						panelarry[1][0].revalidate();
						break;
						
		            case 3:
		            	JFreeChart area = a5.makeAreaChart();
						ChartPanel area_cp = new ChartPanel(area);
						area_cp.setPreferredSize(new Dimension(650, 300));
						area_cp.setBackground(Color.white);
						area_cp.revalidate();
						panelarry[1][1].add(area_cp);
						panelarry[1][1].revalidate();
						break;
		            }
				 
			 }
			
			 else if (analysisChoice == 5) {
				 int viewerChoice = ch_view.getSelectedIndex();
		            switch(viewerChoice) {
		           
		            case 0:
		            	JFreeChart fc = a6.makeLineChart();
		            	ChartPanel cp = new ChartPanel(fc);
		            	cp.setPreferredSize(new Dimension(650, 300));	
		            	cp.setBackground(Color.white);
						cp.revalidate();
						panelarry[0][0].add(cp);
						panelarry[0][0].revalidate();
						break;
						
		            case 1:
		            	JFreeChart scatter = a6.makeScatterChart();
						ChartPanel scatter_cp = new ChartPanel(scatter);
						scatter_cp.setPreferredSize(new Dimension(650, 300));
						scatter_cp.setBackground(Color.white);
						scatter_cp.revalidate();
						panelarry[0][1].add(scatter_cp); 
						panelarry[0][1].revalidate();
						break;

						
		            case 2:
		            	JFreeChart bar = a6.makeBarChart();
						ChartPanel bar_cp = new ChartPanel(bar);
						bar_cp.setPreferredSize(new Dimension(650, 300));
						bar_cp.setBackground(Color.white);
						bar_cp.revalidate();
						panelarry[1][0].add(bar_cp);
						panelarry[1][0].revalidate();
						break;
						
		            case 3:
		            	JFreeChart area = a6.makeAreaChart();
						ChartPanel area_cp = new ChartPanel(area);
						area_cp.setPreferredSize(new Dimension(650, 300));
						area_cp.setBackground(Color.white);
						area_cp.revalidate();
						panelarry[1][1].add(area_cp);
						panelarry[1][1].revalidate();
						break;
		            }
			 }
			 else if (analysisChoice == 6) {
				 int viewerChoice = ch_view.getSelectedIndex();
		            switch(viewerChoice) {
		           
		            case 0:
		            	JFreeChart fc = a7.makeLineChart();
		            	ChartPanel cp = new ChartPanel(fc);
		            	cp.setPreferredSize(new Dimension(650, 300));	
		            	cp.setBackground(Color.white);
						cp.revalidate();
						panelarry[0][0].add(cp);
						panelarry[0][0].revalidate();
						break;
						
		            case 1:
		            	JFreeChart scatter = a7.makeScatterChart();
						ChartPanel scatter_cp = new ChartPanel(scatter);
						scatter_cp.setPreferredSize(new Dimension(650, 300));
						scatter_cp.setBackground(Color.white);
						scatter_cp.revalidate();
						panelarry[0][1].add(scatter_cp); 
						panelarry[0][1].revalidate();
						break;

						
		            case 2:
		            	JFreeChart bar = a7.makeBarChart();
						ChartPanel bar_cp = new ChartPanel(bar);
						bar_cp.setPreferredSize(new Dimension(650, 300));
						bar_cp.setBackground(Color.white);
						bar_cp.revalidate();
						panelarry[1][0].add(bar_cp);
						panelarry[1][0].revalidate();
						break;
						
		            case 3:
		            	JFreeChart area = a7.makeAreaChart();
						ChartPanel area_cp = new ChartPanel(area);
						area_cp.setPreferredSize(new Dimension(650, 300));
						area_cp.setBackground(Color.white);
						area_cp.revalidate();
						panelarry[1][1].add(area_cp);
						panelarry[1][1].revalidate();
						break;
		            }
			 }
			 else if (analysisChoice == 7) {
				 int viewerChoice = ch_view.getSelectedIndex();
		            switch(viewerChoice) {
		           
		            case 0:
		            	JFreeChart fc = a8.makeLineChart();
		            	ChartPanel cp = new ChartPanel(fc);
		            	cp.setPreferredSize(new Dimension(650, 300));	
		            	cp.setBackground(Color.white);
						cp.revalidate();
						panelarry[0][0].add(cp);
						panelarry[0][0].revalidate();
						break;
						
		            case 1:
		            	JFreeChart scatter = a8.makeScatterChart();
						ChartPanel scatter_cp = new ChartPanel(scatter);
						scatter_cp.setPreferredSize(new Dimension(650, 300));
						scatter_cp.setBackground(Color.white);
						scatter_cp.revalidate();
						panelarry[0][1].add(scatter_cp); 
						panelarry[0][1].revalidate();
						break;

						
		            case 2:
		            	JFreeChart bar = a8.makeBarChart();
						ChartPanel bar_cp = new ChartPanel(bar);
						bar_cp.setPreferredSize(new Dimension(650, 300));
						bar_cp.setBackground(Color.white);
						bar_cp.revalidate();
						panelarry[1][0].add(bar_cp);
						panelarry[1][0].revalidate();
						break;
						
		            case 3:
		            	JFreeChart area = a8.makeAreaChart();
						ChartPanel area_cp = new ChartPanel(area);
						area_cp.setPreferredSize(new Dimension(650, 300));
						area_cp.setBackground(Color.white);
						area_cp.revalidate();
						panelarry[1][1].add(area_cp);
						panelarry[1][1].revalidate();
						break;
		            }
			 }
			
	
		}
		
		else if (e.getSource() == remove) {
			int analysisChoice = ch_analysis.getSelectedIndex();
			int viewerChoice = ch_view.getSelectedIndex();
			if (analysisChoice == 0) {
				switch (viewerChoice) {
				case 0:
					if (a1.getLine().getStatus() == true) {
						panelarry[0][0].removeAll();
						panelarry[0][0].revalidate();
						panelarry[0][0].repaint();
						a1.getLine().setStatus(false);
					}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Line Graph since it has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				case 1:
					if (a1.getScat().getStatus() == true) {
						panelarry[0][1].removeAll();
						panelarry[0][1].revalidate();
						panelarry[0][1].repaint();
						a1.getScat().setStatus(false); 
					}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Scatter Graph since it has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				case 2:
					if (a1.getBar().getStatus() == true) {
						panelarry[1][0].removeAll();
						panelarry[1][0].revalidate();
						panelarry[1][0].repaint();
						a1.getBar().setStatus(false);
					}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Bar Graph since it has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
					
				case 3:
					if (a1.getArea().getStatus() == true) {
						panelarry[1][1].removeAll();
						panelarry[1][1].revalidate();
						panelarry[1][1].repaint();
						a1.getArea().setStatus(false);
					}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Area Graph since it has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				}
			}
			else if (analysisChoice == 1) {
				
				switch (viewerChoice) {
				case 0:
					if (a2.getLine().getStatus() == true) {
						panelarry[0][0].removeAll();
						panelarry[0][0].revalidate();
						panelarry[0][0].repaint();
						a2.getLine().setStatus(false);
				}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Line Graph, has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
					
				case 1:
					if (a2.getScat().getStatus() == true) {
						panelarry[0][1].removeAll();
						panelarry[0][1].revalidate();
						panelarry[0][1].repaint();
						a2.getScat().setStatus(false);
					}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Scatter Graph, has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
					
				case 2:
					if (a2.getBar().getStatus() == true) {
						panelarry[1][0].removeAll();
						panelarry[1][0].revalidate();
						panelarry[1][0].repaint();
						a2.getBar().setStatus(false);
					}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Bar Graph, has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				case 3:
					if (a2.getArea().getStatus() == true) {
						panelarry[1][1].removeAll();
						panelarry[1][1].revalidate();
						panelarry[1][1].repaint();
						a2.getArea().setStatus(false);
					}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Area Graph, has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				}
				
			}
			
			else if (analysisChoice == 2) {

				switch (viewerChoice) {
				case 0:
					if (a3.getLine().getStatus() == true) {
						panelarry[0][0].removeAll();
						panelarry[0][0].revalidate();
						panelarry[0][0].repaint();
						a3.getLine().setStatus(false);
				}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Line Graph, has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
					
				case 1:
					if (a3.getScat().getStatus() == true) {
						panelarry[0][1].removeAll();
						panelarry[0][1].revalidate();
						panelarry[0][1].repaint();
						a3.getScat().setStatus(false);

					}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Scatter Graph, has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
					
				case 2:
					if (a3.getBar().getStatus() == true) {
						panelarry[1][0].removeAll();
						panelarry[1][0].revalidate();
						panelarry[1][0].repaint();
						a3.getBar().setStatus(false);

					}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Bar Graph, has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				case 3:
					if (a3.getArea().getStatus() == true) {
						panelarry[1][1].removeAll();
						panelarry[1][1].revalidate();
						panelarry[1][1].repaint();
						a3.getArea().setStatus(false);

					}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Area Graph, has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				}
				
			}
			//Pie
			else if (analysisChoice == 3) {				
				switch (viewerChoice) {
				case 0:
					if (a4.getPie().getStatus() == true) {
						panelarry[0][0].removeAll();
						panelarry[0][0].revalidate();
						panelarry[0][0].repaint();
						a4.getPie().setStatus(false);
				}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Pie Graph, has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
					
				case 1:
					if (a4.getBubble().getStatus() == true) {
						panelarry[0][1].removeAll();
						panelarry[0][1].revalidate();
						panelarry[0][1].repaint();
						a4.getBubble().setStatus(false);
					}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Bubble Graph, has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
					
				case 2:
					if (a4.getBar().getStatus() == true) {
						panelarry[1][0].removeAll();
						panelarry[1][0].revalidate();
						panelarry[1][0].repaint();
						a4.getBar().setStatus(false);
					}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Bar Graph, has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				case 3:
					if (a4.getArea().getStatus() == true) {
						panelarry[1][1].removeAll();
						panelarry[1][1].revalidate();
						panelarry[1][1].repaint();
						a4.getArea().setStatus(false);
					}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Area Graph, has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				}
				
			}//Pie
			else if (analysisChoice == 4) {
				
				switch (viewerChoice) {
				case 0:
					if (a5.getPie().getStatus() == true) {
						panelarry[0][0].removeAll();
						panelarry[0][0].revalidate();
						panelarry[0][0].repaint();
						a5.getPie().setStatus(false);
				}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Pie Graph, has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
					
				case 1:
					if (a5.getBubble().getStatus() == true) {
						panelarry[0][1].removeAll();
						panelarry[0][1].revalidate();
						panelarry[0][1].repaint();
						a5.getBubble().setStatus(false);
					}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Bubble Graph, has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
					
				case 2:
					if (a5.getBar().getStatus() == true) {
						panelarry[1][0].removeAll();
						panelarry[1][0].revalidate();
						panelarry[1][0].repaint();
						a5.getBar().setStatus(false);
					}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Bar Graph, has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				case 3:
					if (a5.getArea().getStatus() == true) {
						panelarry[1][1].removeAll();
						panelarry[1][1].revalidate();
						panelarry[1][1].repaint();
						a5.getArea().setStatus(false);
					}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Area Graph, has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				}
				
				
			}
			else if (analysisChoice == 5) {
				switch (viewerChoice) {
				case 0:
					if (a6.getLine().getStatus() == true) {
						panelarry[0][0].removeAll();
						panelarry[0][0].revalidate();
						panelarry[0][0].repaint();
						a6.getLine().setStatus(false);
				}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Line Graph, has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
					
				case 1:
					if (a6.getScat().getStatus() == true) {
						panelarry[0][1].removeAll();
						panelarry[0][1].revalidate();
						panelarry[0][1].repaint();
						a6.getScat().setStatus(false);

					}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Scatter Graph, has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
					
				case 2:
					if (a6.getBar().getStatus() == true) {
						panelarry[1][0].removeAll();
						panelarry[1][0].revalidate();
						panelarry[1][0].repaint();
						a6.getBar().setStatus(false);

					}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Bar Graph, has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				case 3:
					if (a6.getArea().getStatus() == true) {
						panelarry[1][1].removeAll();
						panelarry[1][1].revalidate();
						panelarry[1][1].repaint();
						a6.getArea().setStatus(false);

					}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Area Graph, has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				}
			}
			else if (analysisChoice == 6) {
				switch (viewerChoice) {
				case 0:
					if (a7.getLine().getStatus() == true) {
						panelarry[0][0].removeAll();
						panelarry[0][0].revalidate();
						panelarry[0][0].repaint();
						a7.getLine().setStatus(false);
					}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Line Graph since it has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				case 1:
					if (a7.getScat().getStatus() == true) {
						panelarry[0][1].removeAll();
						panelarry[0][1].revalidate();
						panelarry[0][1].repaint();
						a7.getScat().setStatus(false); 
					}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Scatter Graph since it has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				case 2:
					if (a7.getBar().getStatus() == true) {
						panelarry[1][0].removeAll();
						panelarry[1][0].revalidate();
						panelarry[1][0].repaint();
						a7.getBar().setStatus(false);
					}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Bar Graph since it has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
					
				case 3:
					if (a7.getArea().getStatus() == true) {
						panelarry[1][1].removeAll();
						panelarry[1][1].revalidate();
						panelarry[1][1].repaint();
						a7.getArea().setStatus(false);
					}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Area Graph since it has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				}
			}
			else if (analysisChoice == 7) {
				switch (viewerChoice) {
				case 0:
					if (a8.getLine().getStatus() == true) {
						panelarry[0][0].removeAll();
						panelarry[0][0].revalidate();
						panelarry[0][0].repaint();
						a8.getLine().setStatus(false);
					}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Line Graph since it has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				case 1:
					if (a8.getScat().getStatus() == true) {
						panelarry[0][1].removeAll();
						panelarry[0][1].revalidate();
						panelarry[0][1].repaint();
						a8.getScat().setStatus(false); 
					}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Scatter Graph since it has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				case 2:
					if (a8.getBar().getStatus() == true) {
						panelarry[1][0].removeAll();
						panelarry[1][0].revalidate();
						panelarry[1][0].repaint();
						a8.getBar().setStatus(false);
					}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Bar Graph since it has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
					
				case 3:
					if (a8.getArea().getStatus() == true) {
						panelarry[1][1].removeAll();
						panelarry[1][1].revalidate();
						panelarry[1][1].repaint();
						a8.getArea().setStatus(false);
					}
					else {
						JOptionPane.showMessageDialog(null,"Cannot remove Area Graph since it has not been added yet ", "Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				}
				
			}
			
		}
		
		else if (e.getSource() == recal) {
			panelarry[0][0].removeAll();
			panelarry[0][0].revalidate();
			panelarry[0][0].repaint();
			
			panelarry[0][1].removeAll();
			panelarry[0][1].revalidate();
			panelarry[0][1].repaint();
			
			panelarry[1][0].removeAll();
			panelarry[1][0].revalidate();
			panelarry[1][0].repaint();
			
			panelarry[1][1].removeAll();
			panelarry[1][1].revalidate();
			panelarry[1][1].repaint();
			userSel = Selection.getInstance();
	
			
			a1 = new Analysis1(userSel);
			a2 = new Analysis2(userSel);
			a3 = new Analysis3(userSel);
			a4 = new Analysis4(userSel);
			a5 = new Analysis5(userSel);
			a6 = new Analysis6(userSel);
			a7 = new Analysis7(userSel);
			a8 = new Analysis8(userSel);
		}
		 
		else if (e.getSource() == ch_analysis) {
			//JOptionPane.showMessageDialog(null,"Please make a new SelectionChoice for the new analysis!", "Error!", JOptionPane.INFORMATION_MESSAGE);
			ch_country.setSelectedIndex(0);
			ch_start.setSelectedIndex(0);
			ch_end.setSelectedIndex(0);			

			SelectionChoice[3] = (String) ch_analysis.getSelectedItem();
			
			//depending on analysis type chosen, update the viewer list accordingly 
			int analysis_Index = ch_analysis.getSelectedIndex();
			ch_view.removeAllItems();
			userSel = Selection.getInstance();
			switch (analysis_Index ) {
			
			//**** List Updating not done yet
			//1. CO2 emissions (metric tons per capita) vs Energy use (kg of oil equivalent per capita) vs PM2.5 air pollution, mean annual exposure (micrograms per cubic meter) -> 3 series graph
			case 0:
				userSel.setAnal("EN.ATM.CO2E.PC");
				userSel.setAnal2("EG.USE.PCAP.KG.OE");
				userSel.setAnal3("EN.ATM.PM25.MC.M3");
				ch_view.addItem("Line Graph");
				ch_view.addItem("Scatter Plot");
				ch_view.addItem("Bar Graph");
				ch_view.addItem("Area Graph");
				break;
				
			case 1:
				userSel.setAnal("EN.ATM.PM25.MC.M3");
				userSel.setAnal2("AG.LND.FRST.ZS");
				userSel.setAnal3(null);
				ch_view.addItem("Line Graph");
				ch_view.addItem("Scatter Plot");
				ch_view.addItem("Bar Graph");
				ch_view.addItem("Area Graph");
				
				break;
			case 2:
				userSel.setAnal("EN.ATM.CO2E.PC");
				userSel.setAnal2("NY.GDP.PCAP.CD");
				userSel.setAnal3(null);
				ch_view.addItem("Line Graph");
				ch_view.addItem("Scatter Plot");
				ch_view.addItem("Bar Graph");
				ch_view.addItem("Area Graph");
				break;
			case 3:
				userSel.setAnal("AG.LND.FRST.ZS");
				userSel.setAnal2(null);
				userSel.setAnal3(null);
				ch_view.addItem("Pie Chart");
				ch_view.addItem("Bubble Graph");
				ch_view.addItem("Bar Graph");
				ch_view.addItem("Area Graph");
				
				break;
			case 4:
				userSel.setAnal("SE.XPD.TOTL.GD.ZS");
				userSel.setAnal2(null);
				userSel.setAnal3(null);
				ch_view.addItem("Pie Chart");
				ch_view.addItem("Bubble Graph");
				ch_view.addItem("Bar Graph");
				ch_view.addItem("Area Graph");
				break;
			case 5:
				userSel.setAnal("SH.MED.BEDS.ZS");
				userSel.setAnal2("SP.DYN.CBRT.IN");
				userSel.setAnal3(null);
				ch_view.addItem("Line Graph");
				ch_view.addItem("Scatter Plot");
				ch_view.addItem("Bar Graph");
				ch_view.addItem("Area Graph");
				break;
			case 6:
				userSel.setAnal("SH.XPD.CHEX.PC.CD");
				userSel.setAnal2("SP.DYN.IMRT.IN");
				userSel.setAnal3(null);
				ch_view.addItem("Line Graph");
				ch_view.addItem("Scatter Plot");
				ch_view.addItem("Bar Graph");
				ch_view.addItem("Area Graph");
				break;
			case 7:
				userSel.setAnal("SE.XPD.TOTL.GD.ZS");
				userSel.setAnal2("SH.XPD.CHEX.GD.ZS");
				userSel.setAnal3(null);
				ch_view.addItem("Line Graph");
				ch_view.addItem("Scatter Plot");
				ch_view.addItem("Bar Graph");
				ch_view.addItem("Area Graph");
				break;
				
			}
		}
		
	}
	
	//Labels
//	"Choose a Country"
	//"from"
	//"to"a
	//"Availble Viewers" 
	//"choose analysis method"
	
	
	//Dropdown Menu
	//Country
	//STartYear
	//End Year
	//Analkysis
	
	//Buttons
	// +/-  viewers
	//Recalculate button
//>>>>>>> branch 'master' of https://repo.csd.uwo.ca/scm/compsci2212_w2021/group21.git


	
/**
* Constructor for assembling the main GUI
//Plan: FRAME -> Top PANEL ->  JLabels + ComboBox -> Bottom PANEL -> JLabels + ComboBox + Buttons  
*
*/	
public FrontEnd() {
	pop_an();
	frame = new JFrame();		
	frame.setSize(1400, 700);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//m
	//Create List of years heres
	start_year[0] = "   ";
	int c = 1960;
	for (int j=1; j < 62; j++) {
		String str = Integer.toString(c);
		start_year[j] = str;
		c++;
		
	}
	end_year = start_year;
	
	//Top Panel
	
	//JPanels 
	panel = new JPanel();
	panel.setBackground(Color.LIGHT_GRAY);
	panel.setPreferredSize(new Dimension(10,50));
	
	frame.add(panel,BorderLayout.NORTH);
	
	//Jlalbel and Dropdown for analysis	
	analysis = new JLabel("Choose analysis method: ");
	panel.add(analysis);
	ch_analysis = new JComboBox(a_Types);
	panel.add(ch_analysis);
	ch_analysis.addActionListener(this);
	
	//Bottom Panel
	botPan = new JPanel();
	botPan.setPreferredSize(new Dimension(10,50));
	botPan.setBackground(Color.LIGHT_GRAY);
	frame.add(botPan,BorderLayout.SOUTH);
	
	
	//Jlabel + dropdown for viewers 
	av = new JLabel("Available Viewers");
	botPan.add(av);
	ch_view = new JComboBox(view_default);
	botPan.add(ch_view);
	
	//Buttons and adding listeners for plus/remove buttons
	plus = new JButton("+");
	remove = new JButton("-");
	botPan.add(plus);
	botPan.add(remove);
	plus.addActionListener(this);
	remove.addActionListener(this);
	
	//Jlabel + dropdown for country
	Country = new JLabel("Choose a country:");
	botPan.add(Country);
	ch_country = new JComboBox(countries);
	ch_country.addActionListener(this);
	botPan.add(ch_country);
	
	//Jlalbel and Dropdown for Start Year
	start = new JLabel("From");
	botPan.add(start);	
	ch_start = new JComboBox(start_year);
	botPan.add(ch_start);
	ch_start.addActionListener(this);
	
	//Jlalbel and Dropdown for End Year
	end = new JLabel("To");
	botPan.add(end);
	ch_end = new JComboBox(end_year);
	botPan.add(ch_end);
	ch_end.addActionListener(this);
	
	//Button for recalculate with listner
	recal = new JButton("Recalculate");
	botPan.add(recal);
	recal.addActionListener(this);
	
	frame.setVisible(true);
	
	//initializing panel array 
    chartpanel = new JPanel(new GridLayout(2,2)); 
    for(int m = 0; m < 2; m++) {
           for(int n = 0; n < 2; n++) {
              panelarry[m][n] = new JPanel();
              panelarry[m][n].setVisible(true);
              panelarry[m][n].setBackground(Color.PINK);
              chartpanel.add(panelarry[m][n]);
           }
    }
    chartpanel.setVisible(true);
    chartpanel.revalidate();
    frame.add(chartpanel, BorderLayout.CENTER); 
    frame.revalidate();

}

}



