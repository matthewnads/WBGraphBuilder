package group21;

import java.util.ArrayList;

/**
 * Data class represents the extracted data depending on years and values. 
 * 
 *
 */
public class Data {
	
	private ArrayList<Integer> years ; 
	private ArrayList<Float> values; 
	

	/**
	* Data constructor that populates arraylists.
	* 
	*/	
	public Data() {
		years = new ArrayList<Integer>(); 
		values = new ArrayList<Float>(); 
	}
	
	/**
	* Getter that returns years.
	* 
	*/	
	public ArrayList<Integer> getYears() {
		return years;
	}
	
	/**
	* Getter that returns values.
	* 
	*/	
	public ArrayList<Float> getValues() {
		return values ;
	}
	
	/**
	* Setter that sets the years variable.
	* 
	*/	
	public void setYears(ArrayList<Integer> years) {
		this.years = years;
	}
	
	/**
	* Setter that sets the value variable.
	* 
	*/	
	public void setValues(ArrayList<Float> values) {
		this.values = values; 
	}
	
	/**
	* Method to add a value.
	* 
	*/	
	public void addValue(float v) {
		values.add(v);
	}
	
	/**
	* Method to add a year.
	* 
	*/	
	public void addYear(int y) {
		years.add(y);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
