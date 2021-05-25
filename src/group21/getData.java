package group21;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser; 

public class getData {
	/**
	 * getData class represents data extraction.
	 * 
	 *
	 */
	String urlString = "";
	HttpURLConnection connect;
	
	/**
	* getData constructor that is passed a link
	* 
	*/	
	public getData(String link) {
		urlString = link; 
	}
	
	/**
	* empty getData method
	* 
	*/	
	public getData() {
	}
	
	/**
	* Getter that returns response code
	* 
	*/	 
	public int getCode() {
		try {
			URL url = new URL(urlString); 
			connect = (HttpURLConnection) url.openConnection();
			connect.setRequestMethod("GET");
			int responsecode = connect.getResponseCode(); 
			return responsecode; 	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
	
	
	/**
	* Getter that returns data object from json response  
	* @param countries.get(country)
	*/	
	public Data getJason() {
		Data data = new Data(); 
		
		try {
			URL url = new URL(urlString); 
			connect = (HttpURLConnection) url.openConnection();
			connect.setRequestMethod("GET");
			int responsecode = connect.getResponseCode(); 
			
			if(responsecode == 200) {
				//reading in url content 
				String content = ""; 
				Scanner sc = new Scanner(url.openStream());
				while(sc.hasNext()) 
					content+= sc.nextLine(); 
				sc.close();
				
				//now content has all the json as a string, so we convert to a jsonarray to parse through it easily 
				JsonArray jsonArray = JsonParser.parseString(content).getAsJsonArray(); 
				
				int size = jsonArray.size(); //number of pages 
					
				if(size>1 && !jsonArray.get(1).isJsonNull()) {
						
						int sizeResults = jsonArray.get(1).getAsJsonArray().size(); //number of objects per page 
						//for each json entry we will have a year as "date" and a corresponding "value"  
						int date; float value; 
						for (int i =0; i< sizeResults; i++) {
							
							
							//if there is a value for this year 
							if(!jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").isJsonNull()) {
								date = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsInt();
								data.addYear(date);
								value = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").getAsFloat();
								data.addValue(value);
							}
						}
					}
			}
			else {
				//error code 
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//some tests 
		getData test = new getData("http://api.worldbank.org/v2/country/ata/indicator/EN.ATM.CO2E.PC" + 
			"?date=1960:2020&format=json") ;
		
		System.out.println(test.getCode());
		System.out.println(test.getJason().getValues().toString());

	}

}


