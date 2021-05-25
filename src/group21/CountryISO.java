package group21;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/**
 * * CountryISO class represents the country codes extracted necessary for user selections.  
 * 
 * @author group21
 *
 */
public class CountryISO {
	
	
	Map<String, String> countries; //Map populated with countries
	
	/**
	* CountryISO constructor that populates countries map with the ISO Country Codes
	* @param userSel
	*/	
	public CountryISO() {
		countries = new HashMap<>(); 
		for (String country : Locale.getISOCountries()) {
			Locale l = new Locale("", country); 
			countries.put(l.getDisplayCountry(), l.getISO3Country()); 
		}
	}
	
	/**
	* Getter that returns country code
	* @param countries.get(country)
	*/	
	public String iso(String country) {
		return countries.get(country);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
