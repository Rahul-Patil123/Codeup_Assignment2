/*
 * Name : Rahul Ganeshwar Patil 
 * Date: 04/09/2024
 */
public class Dependencies {
	static public String ENTER_INPUT = "Enter any String : ";
	static public String INDEX_START = "Enter starting Index ";
	static public String START_INDEX = "Enter length from starting Index ";
	static public String SPLICED_STRING = "Spliced String : ";
	static public String NOTEMPTY = "Main String cannot be empty.";
	static public String SPECIAL_CHARACTERS = "!@#$%^&*()-=+[]{};:'\",<.>/?\\|";
	static public String ISPALINDROME = "The given String is Palindrome";
	static public String ONLY_ALPHABETS = "Enter Only Alphabets!!";
	static public String NOT_FOUND = "No string found that is to be replaced!!";
	static public String TOTAL_WORDS = "Total number of words : ";
	static public String INVALID = "Invalid input. Please enter an integer value.";
	static public String NOTPALINDROME = "The given String is not Palindrome : ";
	static public String REPLACE_STRING = "Enter replacing string ";
	static public String NEWREPLACE_STRING = "Enter new words for replacing ";
	static public String MOVE_CHARACTER = "Enter moving Character : ";
	static public String OUTOFBOUNDS = "Invalid input. Start index is out of bounds.";
	static public String PATTERN_ERROR = "Pattern cannot be empty.";
	static public String PATTERN_INPUT = "Enter a pattern for splitting into CharacterArrayay: ";
	static public String NEGATIVE_ERROR = "Cannot be negative : ";
	static public String OUTPUT_MESSAGE = "The Output will be : \n";
	public static String ENTER_OPTION = "Select any option from given below[Type 1,2,3 etc.] : ";
	static public String appendMessage = "Using Append function : \n";
	static public String sortString = "Using sort function : \n";
	static public String countWordsMessage = "Using Count Words Function : \n";
	static public String replaceMessage = "Using Replace Function : \n";
	static public String palindromeMessage = "Using Palindrome Function : \n";
	static public String spliceMessage = "Using Splice Function : \n";
	static public String splitMessage = "Using Split the String Function : \n";
	static public String maxCharMessage = "Using Maximum Character Display Function : \n";
	static public String shiftMessage = "Using Shift Function : \n";
	static public String reverseMessage = "Using Reverse Function : \n";
	static public String newStringMessage = "Enter new String : \n";
	static public String exitMessage = "Thank you For Trusting Us :)\nProgram Exited..";
	static public String invalidOptionMessage = "Invalid option Entered!!\nPlease Follow Instructions!!";
	static public void display_options() {
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
		System.out.println(ENTER_OPTION);
		System.out.println("1. Append: \"This function appends one string to another.\"\r\n"
				+ "2. CountWords: \"This function counts the number of words in a string.\"\r\n"
				+ "3. Replace: \"This function replaces occurrences of a substring within a string.\"\r\n"
				+ "4. isPalindrome: \"This function checks if a string is a palindrome.\"\r\n"
				+ "5. Splice: \"This function removes or adds elements to an array.\"\r\n"
				+ "6. Split: \"This function splits a string into an array of substrings.\"\r\n"
				+ "7. MaxRepeatingCharacter: \"This function finds the character that repeats the most in a string.\"\r\n"
				+ "8. Sort: \"This function sorts an array or list in a specific order.\"\r\n"
				+ "9. Shift: \"This function shifts the elements in an array to the left or right.\"\r\n"
				+ "10. Reverse: \"This function reverses the order of elements in an array or string.\n"
				+ "11. New String: \"This function is used to take new input String.\n"
				+ "12. Print Main String. \n"
				+ "13. Exit From the Program");
		
	}
}
