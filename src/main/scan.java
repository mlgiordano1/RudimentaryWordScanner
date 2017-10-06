
package main;

// importing the scanner
import java.util.Scanner; 

// Assignment 1 naming the main class
public class scan {
	public static void main(String[] args) {	
		// Use processInput() here; 
		processInput();
	}
	
	// ------------------------------------------------------
	// processInput() method 
	// Description:
	// It takes no argument and reads input lines in a loop, 
	// passing each non terminating line to scanString() 
	// as the argument. It does not return a value. Its
	// loop exits when a terminating line is detected.
	// ------------------------------------------------------
	public static void processInput() {
		// Defining the scanner?
		Scanner scanner = new Scanner(System.in);
		// Start a loop for strings
		while (true) {
			// Printing a message to the console
			System.out.println("Enter a string, Please and Thank you");
			// User inputs string and its saved as myNewString
			String myNewString = scanner.nextLine();

			// Checking for space at end of line;
			// If no space add one helping usability;
			if (myNewString.charAt(myNewString.length()-1) != ' ') {
				myNewString = myNewString + " ";
			}
			// Checking for program ending condition
			if (myNewString.charAt(0)=='.') {
				break;
			}
			// Here we need to call scan string
			scanString(myNewString);
		}
		// Close the scanner
		scanner.close();
		// Prints when the loop is broken out of
		System.out.println("Fin.");
	}
	
	
	// ------------------------------------------------------
	// scanString method 
	// Description:
	// It takes a String argument, finds the numbers in the
	// String, and produces the output associated with the string.
	// It uses indexOf() to perform its task. It returns no value.
	// ------------------------------------------------------
	public static void scanString(String myNewString) {
		// initiate a few helpful variables
		int sum = 0;
		int prod = 1;
		String stringToken ;
		int token ; 


		// Starting from zero	
		int tokenStart = 0;
		// If first character is not an integer this will change the starting point
		while(tokenStart == indexOf(myNewString, ' ', tokenStart)) {
			tokenStart = tokenStart +1;
		}
		// This is the meat of the scanner
		while (tokenStart <= myNewString.length()-1) {
			// from the current 'tokenStart' find the next space
			int space = indexOf(myNewString, ' ', tokenStart);
			// We have the start and end of the token:
			// Substring, Convert to integer, and print.
			stringToken = myNewString.substring(tokenStart, space);
			token = Integer.parseInt(stringToken);
			System.out.println(stringToken);
			// running the arithmetic on the running sums and products
			sum = sum + token;
			prod = prod*token;
			// Next we have to find the start of the next token.
			tokenStart = space;
			// Check for the end of the string
			if (indexOf(myNewString, ' ', tokenStart+1)== -1) {
				break;
			}
			// adjust the start of the next token given variable spacing
			while(tokenStart+1 == indexOf(myNewString, ' ', tokenStart+1)) {
				tokenStart = tokenStart +1;
			}
			// add one and start the loop over
			tokenStart = tokenStart +1;
		}
		// Print the total sum and product of the integers.
		System.out.println("Sum: " + sum);
		System.out.println("Product: " + prod);
	}

		

	// ------------------------------------------------------
	// indexOf method 
	// Description:
	// 	It takes as arguments a String s, a char ch, an int fromIndex (in this order). 
	//	It returns the index (position) of the first occurrence of the ch in s that is
	//	greater than or equal to fromIndex, or -1 if the ch does not occur. Thus, the value 
	//	returned is either -1 or k, where fromIndex <= k < s.length(), and
	//	aString.charAt(k) == ch. You are of course free to rename the arguments.
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
	

	



	
	
