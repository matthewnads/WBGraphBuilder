
package group21;
/**
 * Selection class represents user session and their choices which are stored as member variables. Using singleton design pattern to ensure only one object is made. 
 * 
 *
 */
public class Selection {
	private String country, username, password; 
	private int startYear, endYear; 
	private String anaType, anaType2, anaType3; //change this to analysis type once the class is made 
	private String[] viewers; //change this to viewers type
	private static Selection instance = null; 
	
	/**
	 * Constructor, the member variables are set using setters, called in front end 
	 */
	private Selection() {
		
	}
	
	/**
	 * Singleton constructor to ensure only one selection object is created 
	 * @return instance of Selection
	 */
	public static Selection getInstance() {
		if (instance == null) 
			instance = new Selection(); 
		
		return instance; 
	}
	
	/**
	 * Constructor with 2 analysis types used for testing 
	 * @param anaType
	 * @param anaType2
	 */
	public Selection(String anaType, String anaType2) {
		this.anaType = anaType;
		this.anaType2 = anaType2;	
	}
	
	/**
	 * Constructor with 3 types used for testing
	 * @param anaType
	 * @param anaType2
	 * @param anaType3
	 */
	public Selection(String anaType, String anaType2, String anaType3) {
		this.anaType = anaType;
		this.anaType2 = anaType2;
		this.anaType3 = anaType3;
	}
	
	//GETTERS 
	
	/**
	 * 
	 * @return country code 
	 */
	public String getCountry() {
		return country; 
	}
	
	/** 
	 * 
	 * @return start year selected 
	 */
	public int getStart() {
		return startYear ;
	}
	
	/**
	 * 
	 * @return end year selected
	 */
	public int getEnd() {
		return endYear; 
	}
	
	/**
	 * 
	 * @return analysis code (may be upto 3)
	 */
	public String getAnalsis2() {
		return anaType2;
	}
	
	/**
	 * 
	 * @return analysis code (may be upto 3)
	 */
	public String getAnalsis3() {
		return anaType3;
	}
	
	
	/**
	 * 
	 * @return anaylsis code (may be upto 3)
	 */
	public String getAnalsis() { //change  types 
		return anaType;
	}
	
	/**
	 * 
	 * @return array of all the viewers selected 
	 */
	public String[] viewers() { //and here
		return viewers; 
	}
	
	
	//SETTERS 
	
	
	/**
	 * Set the country code 
	 * @param country 
	 */
	public void setCountry(String country) {
		this.country= country; 
	}
	
	/**
	 * Set the period in years
	 * @param start
	 * @param end
	 */
	public void setTime(int start, int end) {
		startYear= start;
		endYear = end;
	}
	
	/**
	 * Set start year 
	 * @param start
	 */
	public void setStart(int start) {
		startYear = start;
	}
	
	/**
	 * Set end year 
	 * @param end
	 */
	public void setEnd(int end) {
		endYear = end; 
	}
	
	/**
	 * Set anaylsis type 
	 * @param anal 
	 */
	public void setAnal(String anal) {
		anaType = anal;
	}
	
	public void setAnal2(String anal) {
		anaType2 = anal;
	}
	
	public void setAnal3(String anal) {
		anaType3 = anal;
	}
	
}
