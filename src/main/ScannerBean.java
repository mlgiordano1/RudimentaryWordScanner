package main;
import util.annotations.Tags;

@Tags({"ScannerBean"})
public class ScannerBean {
	String scannedString;

	public String getScannedString() {
		return scannedString;
	}

	public void setScannedString(String inputString) {
		scannedString = inputString;
		// scans and prints with ScannedString
		scanString(scannedString);
	}
	
	//------------------------------------------------------------
	// scanString and indexOf are static methods here
	//------------------------------------------------------------
	public static void scanString(String myNewString) {
		// tokenStart and tokenEnd will be our running indexes
		int tokenStart = 0;
		int tokenEnd; 
		// stringToken will hold the token
		String stringToken;
		// firstChar will hold first character of token;
		char firstChar;

		// Starting from index of 0, find the start of the first token;
		while(tokenStart == indexOf(myNewString, ' ', tokenStart)) {
			tokenStart = tokenStart +1;
		}
		
		
		// This is the meat of the scanner
		while (tokenStart < myNewString.length()) {

			//Check if we finished the full string
			//if (indexOf(myNewString, ' ', tokenStart)== -1) {
			//	break;
			//}
			
			// Define the first character in the string;
			firstChar = myNewString.charAt(tokenStart);
			// if the first char is a " 
			if (firstChar == '"') {
				// Find the end of the quote
				tokenEnd = indexOf(myNewString, '"', tokenStart+1);
				// pull out the token
				stringToken = myNewString.substring(tokenStart+1, tokenEnd);
				// Print the token
				System.out.println("quoted string: " + stringToken);
			} else if (Character.isDigit(firstChar)) {
				// Find the end of the quote
				tokenEnd = indexOf(myNewString, ' ', tokenStart);
				// Pull out the token
				stringToken = myNewString.substring(tokenStart, tokenEnd);
				// Print the token
				System.out.println("number: " + stringToken);
			} else {
				// Find the end of the quote
				tokenEnd = indexOf(myNewString, ' ', tokenStart);
				// Pull out the token
				stringToken = myNewString.substring(tokenStart, tokenEnd);
				// Print the token
				System.out.println("word: " + stringToken);
			}
			
			// Next we have to find the start of the next token.
			tokenStart = tokenEnd;
			// Check for the end of the string

			// adjust the start of the next token given variable spacing
			while(tokenStart+1 == indexOf(myNewString, ' ', tokenStart+1)) {
				tokenStart = tokenStart +1;
			}
			// add one and start the loop over
			tokenStart = tokenStart +1;
		}

	}
	
	// ------------------------------------------------------
	// indexOf method 
	// ------------------------------------------------------
	public static int indexOf(String myNewString, char ch, int index) {
		while (true) {
			if (index >= myNewString.length()) {
				index = -1;
				break;
			}
			if (myNewString.charAt(index)==ch) {
				break;
			} else {
				index++;
			}
		}
	return(index);
	}	

}
