package main;

//importing the scanner
import java.util.Scanner; 

public class Driver {
	public static void main(String[] args) {	
		// Use processInput() here; 
		Scanner scanner = new Scanner(System.in);
		// instantiate the scanner bean
		main.ScannerBean scanString = new main.ScannerBean();
		
		while (true) {
			// Printing a message to the console
			System.out.println("Enter a string, Please and Thank you");
			// User inputs string and its saved as myNewString
			String myNewString = scanner.nextLine();

			// Checking for program ending condition
			if (myNewString.charAt(0)=='.') {
				break;
			}
			
			// Checking for space at end of line;
			// If no space add one helping usability;
			if (myNewString.charAt(myNewString.length()-1) != ' ') {
				myNewString = myNewString + " ";
			}

			// Here we need to call scan string
			scanString.setScannedString(myNewString);
		}
		// Close the scanner
		scanner.close();
		// Prints when the loop is broken out of
		System.out.println("Fin.");
	}
	


	
}