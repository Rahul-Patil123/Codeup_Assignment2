/*
 * Name : Rahul Ganeshwar Patil 
 * Date: 04/09/2024
 * 
 * Problem Description :
 *  [When the program is run, the user will first enter a string. After that, the program should
	ask the user which operation they want to execute on the string. The available operations are
	listed below: Append, CountWords, Replace, isPalindrome, Splice, Split,
	MaxRepeatingCharacter, Sort, Shift, and Reverse. Each method should perform its
	respective operation based on the user's input.]
	
	Examples:
	[
		1. append(String newString)
			String currentString = "Hello";
			append(" World"); // Result: "Hello World"
			append(" Java"); // Result: "Hello World Java"
		2. countWords()
			String text = "Hello World from Codeup";
			int wordCount = countWords(); // Result: 4
		3. replace(String a, String b)
			String text = "Java Programming";
			replace('a', 'o'); // Result: "Jovo Progromming"
			replace('ava', 'o'); // Result: "Jo Progromming"
		4. isPalindrome()
			String text = "madam";
			boolean isPal = isPalindrome(); // Result: true
		5. splice(int start, int length)
			String text = "Academy";
			splice(2, 2); // Result: "Acemy"
		6. split(String pattern)
			String text = "Codeup ACE Academy";
			String[] words = split(“ “); // Result: ["Codeup", "ACE", "Academy"]
		7. maxRepeat()
			String text = "success";
			char maxChar = maxRepeat(); // Result:
			's' -> 3
		8. sort()
			String text = "program";
			String sortedText = sort(); // Result: "agmnoprr"
		9. shift(int n)
			String text = "abcdef";
			shift(2); // Result: "efabcd"
		10. reverse()
			String text = "Java";
	]
**/
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
public class OperationsOnString{
	static String MainString;
	public static Scanner input = new Scanner(System.in);
	static public Dependencies dependency = new Dependencies();;
	public static void main(String[] args) {
		System.out.println(dependency.ENTER_INPUT);
		MainString = input.nextLine();
		if (MainString.isEmpty()) {
            System.out.println(dependency.NOTEMPTY);
            return;
        }
		dependency.display_options();		
		String input_option = input.next();
		boolean isQuit = false; 
		do {
			switch(input_option) {
            case "1":
                System.out.println(dependency.appendMessage);
                append();
                break;
            case "2":
                System.out.println(dependency.countWordsMessage);
                countWords();
                break;
            case "3":
                System.out.println(dependency.replaceMessage);
                replace();
                break;
            case "4":
                System.out.println(dependency.palindromeMessage);
                isPalindrome();
                break;
            case "5":
                System.out.println(dependency.spliceMessage);
                splice();
                break;
            case "6":
                System.out.println(dependency.splitMessage);
                split(MainString);
                break;
            case "7":
                System.out.println(dependency.maxCharMessage);
                maxRepeatedCharacter(MainString);
                System.out.println("\n");
                break;
            case "8":
                System.out.println(dependency.sortString);
                String specialCharacters = dependency.SPECIAL_CHARACTERS;
                for(int i = 0; i < specialCharacters.length();i++) {
                	if(MainString.contains(Character.toString(specialCharacters.charAt(i)))) {
                		System.out.println(dependency.ONLY_ALPHABETS);
                		break;
                	}
                }
                char[] newString = (MainString.toLowerCase()).toCharArray();
        		quickSort(newString,0,(newString.length)-1);
                System.out.println(Arrays.toString(newString));                
                break;
            case "9":
                System.out.println(dependency.shiftMessage);
                shift();
                break;
            case "10":
                System.out.println(dependency.reverseMessage);
                String MainString1 = reverse(MainString);
                System.out.println(dependency.OUTPUT_MESSAGE);
                System.out.println(MainString1);
                break;
            case "11":
                System.out.println(dependency.newStringMessage);
                newString();
                break;
            case "12": 
            	
            	System.out.println(MainString);
            case "13":
                System.out.println(dependency.exitMessage);
                isQuit = true;
                break;
            default:
                System.out.println(dependency.invalidOptionMessage);
                isQuit = false;
                break;
				}
			if(!isQuit) {
				dependency.display_options();
				input_option = input.next();
			}
		}while(!isQuit);	
	}
	static void append(){
        System.out.println(dependency.ENTER_INPUT);
        input.nextLine();
        String newString = input.nextLine();
		MainString = MainString + newString;
		System.out.println(dependency.OUTPUT_MESSAGE);
		System.out.println(MainString);
	}
    
    public static void countWords(){
        int count = 0;
        boolean isWord = false;

        for (int i = 0; i < MainString.length(); i++) {
            char currentChar = MainString.charAt(i);
            if (currentChar != ' ') {
                isWord = true;
            }else if(isWord){
                count++;
                isWord = false;
            }
        }
        if (isWord) {
            count++;
        }
        System.out.println(dependency.TOTAL_WORDS + count);
    }

    public static void replace(){
        System.out.println(dependency.REPLACE_STRING);
        String replaceString = input.next();
        System.out.println(dependency.NEWREPLACE_STRING);
        String replacingString = input.next();
        String newString = "";
        int count = 0;
        
        for (int i = 0; i < MainString.length(); i++) {
            char currentChar = MainString.charAt(i);

            if (MainString.substring(i).startsWith(replaceString)) {
                newString += replacingString;
                i = i + replaceString.length() - 1;
                count++;
            }else{
                newString = newString + currentChar;
            }
        }
        if(count == 0) {
        	System.out.println(dependency.NOT_FOUND);
        }
        else {
        	System.out.println(dependency.OUTPUT_MESSAGE);
            System.out.println(newString);
        }

    }
    
    public static void isPalindrome(){
        String newString = "";
        for (int i = MainString.length()-1; i >=0 ; i--) {
            char currentLastChar = MainString.charAt(i);
            newString += currentLastChar;
        }
        if (newString == MainString){
            System.out.println(dependency.ISPALINDROME);
            return;
        }
        System.out.println(dependency.NOTPALINDROME+newString);
    }

    public static void splice(){
        int startIndex;
        while (true) {
            try {
                System.out.println(dependency.INDEX_START);
                startIndex = input.nextInt();
                if (startIndex < 0) {
                    System.out.println(dependency.NEGATIVE_ERROR);
                } else if (startIndex >= MainString.length()) {
                    System.out.println((dependency.OUTOFBOUNDS));
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println(dependency.INVALID);
                input.next();
            }
        }
        int length = input.nextInt();
        while (true) {
            try {
                System.out.println(dependency.START_INDEX);
                startIndex = input.nextInt();
                if (startIndex < 0) {
                    System.out.println(dependency.NEGATIVE_ERROR);
                } else if (startIndex >= MainString.length()) {
                    System.out.println(dependency.OUTOFBOUNDS);
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println(dependency.INVALID);
                input.next();
            }
        }

        String newString = "";
        for (int i = 0; i < MainString.length(); i++) {
            char currentChar = MainString.charAt(i);
            if (!(i >= startIndex && i <= startIndex + length - 1)) {
                newString += currentChar;
            }
        }
        System.out.println(dependency.SPLICED_STRING+newString);
    }

    public static void shift(){
        System.out.println(dependency.MOVE_CHARACTER);
        int FrequencyOfMoving;
        while (true) {
            try {
                System.out.println(dependency.MOVE_CHARACTER);
                FrequencyOfMoving = input.nextInt();
                if (FrequencyOfMoving < 0) {
                    System.out.println(dependency.NEGATIVE_ERROR);
                }else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println(dependency.INVALID);
                input.next();
            }
        }
        String firstString = "";
        String secondString = "";
        int stringlength = MainString.length();
        for (int i = MainString.length() - 1; i >=0 ; i--) {
            if (i >= stringlength-(FrequencyOfMoving%stringlength)) {
                firstString += MainString.charAt(i);
            }else{
                secondString += MainString.charAt(i);
            }
        }
        firstString = reverse(firstString);
        secondString = reverse(secondString);
        System.out.println(firstString+secondString);
    }

    public static String reverse(String MainString){
        String newString = "";
        for (int i = MainString.length()-1; i >=0 ; i--) {
            char currentLastChar = MainString.charAt(i);
            newString += currentLastChar;
        }
        
        return newString;
    }
    public static void split(String OriginalString) {
        System.out.println(dependency.PATTERN_INPUT);
        input.nextLine();
        String pattern = input.nextLine();
        String[] words = new String[OriginalString.length() + 1];
        int indexCount = 0;
        if (pattern.isEmpty()) {
            System.out.println(dependency.PATTERN_ERROR);
            return;
        }
        for (int i = 0; i < OriginalString.length(); i++) {
            if (OriginalString.startsWith(pattern, i)) {
                words[indexCount] = OriginalString.substring(0, i);
                indexCount++;
                OriginalString = OriginalString.substring(i + pattern.length());
                i = -1;
            }
        }
        
        words[indexCount] = OriginalString;        
        String[] withoutNull = new String[indexCount+1];
        for (int i = 0; i < indexCount+1; i++) {
            withoutNull[i] = words[i];
        }
        System.out.println(Arrays.toString(withoutNull));
    }
    public static void quickSort(char[] CharacterArray, int low, int high) {
            if (low < high) {
                int pi = partition(CharacterArray, low, high);

                quickSort(CharacterArray, low, pi - 1);
                quickSort(CharacterArray, pi + 1, high);
            }
     }
    //

     private static int partition(char[] CharacterArray, int low, int high) {
            char pivot = CharacterArray[high];
            int i = (low - 1);

            for (int j = low; j < high; j++) {
                if (CharacterArray[j] < pivot) {
                    i++;

                    char temp = CharacterArray[i];
                    CharacterArray[i] = CharacterArray[j];
                    CharacterArray[j] = temp;
                }
            }

            char temp = CharacterArray[i + 1];
            CharacterArray[i + 1] = CharacterArray[high];
            CharacterArray[high] = temp;

            return i + 1;
        }
     public static void maxRepeatedCharacter(String MainString) {
    	    int[] charFrequency = new int[256];
    	    for (int i = 0; i < MainString.length(); i++) {
    	        charFrequency[MainString.charAt(i)]++;
    	    }
    	    
    	    int maxFrequency = 0;
    	    boolean isduplicate = false;
    	    for (int i = 0; i < 256; i++) {
    	        if (charFrequency[i] > maxFrequency) {
    	            maxFrequency = charFrequency[i];
    	            isduplicate = false;
    	        } else if (charFrequency[i] == maxFrequency) {
    	        	isduplicate = true;
    	        }
    	    }
    	    if (isduplicate) {
    	        System.out.print("Characters with max frequency " + maxFrequency + ": ");
    	        for (int i = 0; i < 256; i++) {
    	            if (charFrequency[i] == maxFrequency) {
    	                System.out.println((char) i + " ");
    	            }
    	        }
    	    } else {
    	        System.out.print("Character with max frequency " + maxFrequency + ": ");
    	        for (int i = 0; i < 256; i++) {
    	            if (charFrequency[i] == maxFrequency) {
    	                System.out.println((char) i);
    	            }
    	        }
    	        }
    	    System.out.println();
    	}

     public static void newString() {
    	 Scanner input = new Scanner(System.in);
    	 MainString = input.nextLine();
     }
}