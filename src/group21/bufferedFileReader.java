 package group21;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * Buffered File Reader class to handle reading in user inputs for login system 
 * @author group21 
 *
 */
public class bufferedFileReader {
	private String lineRead = "";
	private BufferedReader bufferedReader; 
	private String username = ""; //Username read from file
	private String password = ""; //Password read from file
	
	/**
	 * Constructor, the class is passed a file name to read from.
	 */
	public bufferedFileReader(String fileName) {
		
		try {
			
			bufferedReader = new BufferedReader(new FileReader(fileName)); //Initializes buffered reader

			this.username = bufferedReader.readLine(); //Reads and stores username value from file
			System.out.println(username);
			
			this.password = bufferedReader.readLine(); //Reads and stores password value from file
			System.out.println(password);
			
			
		}
		 
		catch (IOException e) { //Catches error in instance where file is unable to be read.
			
			System.out.println("Error: Can't read file.");
			System.exit(0);
		}
		
		
	}
	
	/**
	 * Getter that returns the username extracted from the file.
	 */
	public String getUserName() {
		 return username; 
	}
	
	/**
	 * Getter that returns the password extracted from the file.
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Method that indicates the end of the file has been reached.
	 */
	public boolean endReached() {
		
		if (lineRead == null) {
			return true;
		}
		
		else return false;
	}
	
	/**
	 * Reads the text in the file.
	 */
	public String stringReader() {
		String lineReader = lineRead;
		
		if (lineRead == null) { //Checks if end of file has been reached
			
			System.out.println("Error: No more lines to read, end of file has been reached.");
			return null;
		}
		
		try {
			
			lineRead = bufferedReader.readLine(); //Reads lines from the file.
		}
		
		catch (IOException e) {
			
			System.out.println("Error: Can't read file."); //Catches error in instance where file is unable to be read.
			System.exit(0);
		}
		return lineReader;
	}
	

}
