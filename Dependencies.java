public class Dependencies {
	public String ENTER_INPUT = "Enter any String : ";
	public String OUTPUT_MESSAGE = "The Output will be : \n";
	public static String ENTER_OPTION = "Select any option from given below[Type 1,2,3 etc.] : ";
	public String appendMessage = "Using Append function : \n";
	public String sortString = "Using sort function : \n";
    public String countWordsMessage = "Using Count Words Function : \n";
    public String replaceMessage = "Using Replace Function : \n";
    public String palindromeMessage = "Using Palindrome Function : \n";
    public String spliceMessage = "Using Splice Function : \n";
    public String splitMessage = "Using Split the String Function : \n";
    public String maxCharMessage = "Using Maximum Character Display Function : \n";
    public String shiftMessage = "Using Shift Function : \n";
    public String reverseMessage = "Using Reverse Function : \n";
    public String newStringMessage = "Enter new String : \n";
    public String exitMessage = "Thank you For Trusting Us :)\nProgram Exited..";
    public String invalidOptionMessage = "Invalid option Entered!!\nPlease Follow Instructions!!";
    public void display_options() {
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
				+ "12. Exit From the Program");
		
	}
}
