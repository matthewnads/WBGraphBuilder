package group21;

import java.util.ArrayList;
import java.util.List;

/**
 * Container for getdata, program will use this to create api requests and recieve data from WB database 
 * 
 *
 */
public class Reader {
	
	private String url ="" ; 
	private String country;
	private String analy;
	private int start;
	private int end;
	
	
	/**
	 * Getters and Setters 
	 */
	/***************************************************************************************************************************************************/
	/**
	 * setURL Method 
	 * @return void 
	 * @param string s that is the url used for GET request 
	 */
	public void setURL (String s) {
		url = s; 
	}
	
	/**
	 * gets the response code (ex. 200) of the api request 
	 * @return integer form of code 
	 */
	public int getResponse() {
		getData getter = new getData(url); 
		return getter.getCode();
	}
	
	/**
	 * Gets data object that holds the dataset as ArrayList objects directly from the json response 
	 * use data.getYear() and data.getValues() to get each set of data 
	 * @return Data object
	 */
	public Data getRaw() {
		getData getter = new getData(url);
		
		return getter.getJason(); 
	}
	/***************************************************************************************************************************************************/

	
	
	//constructors double as a url constructor for api get requests 
	//added a bunch to help making testing easier 
	public Reader(String url) {
		this.url = url ;
	}
	public Reader(String country, String analy, int start, int end) {
		url = String.format("http://api.worldbank.org/v2/country/%s/indicator/%s?date=%d:%d&format=json", country, analy, start, end);
	}
	
	public Reader(Selection user) {
		country = user.getCountry(); 
		analy = user.getAnalsis(); 
		start = user.getStart(); 
		end = user.getEnd(); 
		url = String.format("http://api.worldbank.org/v2/country/%s/indicator/%s?date=%d:%d&format=json", country, analy, start, end);
	}
	/***************************************************************************************************************************************************/

/**
 * checking if country selected has available data. 1 if true (available), -1 if false (not available)
 * @param country
 * @param analy is analysis indicator code 
 * @return int 1 or -1
 */
	public int countryValid() {

		
		getData getter = new getData(url); 
		
		Data data = getter.getJason(); 
		
		if(data.getValues().isEmpty())
			return -1;
		
		return 1; 
		
	}


	/**
	 * checking if the period selected has all the data(1), some(0) or none (-1)
	 * @param country
	 * @param analy (analysis indicator code) 
	 * @param start year int 
	 * @param end year int
	 * @return int 1, 0 or -1
	 */
	public int yearsValid() {
		
		getData getter= new getData(url); 
		
		Data data = getter.getJason(); 
		if(data.getYears().isEmpty())
			return -1;
		else if(data.getYears().size() == start-end)
			return 1; 
		else
			return 0;
	}
	
	
	
	 // 
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String country = "can"; 
		String analy = "EG.USE.PCAP.KG.OE";
		int start = 1960; int end = 2001;
		Reader test = new Reader(country, analy, start, end) ; 
		Data raw = test.getRaw();
		
		System.out.println(test.countryValid()); 
		System.out.println(test.yearsValid());
		
		
//		System.out.println(raw.getYears().toString()); 
//		System.out.println(raw.getValues().toString()); 
	}

}
