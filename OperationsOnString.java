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
import java.util.CharacterArrayays;
import java.util.Scanner;
public class OperationsOnString{
	static String MainString;
	public static Scanner input = new Scanner(System.in);
	static Dependencies dependency = new Dependencies();;
	public static void main(String[] args) {
		System.out.println(dependency.ENTER_INPUT);
		MainString = input.nextLine();
		if (MainString.isEmpty()) {
            System.out.println("Main String cannot be empty.");
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
                char[] maxFrequency = maxRepeatedChar(MainString);
                if (maxFrequency != null) {
                    System.out.println("Character: " + maxFrequency[0] + ", Frequency: " + maxFrequency[1]);
                } else {
                    System.out.println("The string is empty.");
                }
                System.out.println("\n");
                break;
            case "8":
                System.out.println(dependency.sortString);
                String specialCharacters = "!@#$%^&*()-=+[]{};:'\",<.>/?\\|";
                for(int i = 0; i< specialCharacters.length();i++) {
                	if(MainString.contains(Character.toString(specialCharacters.charAt(i)))) {
                		System.out.println("Enter Only Alphabets!!");
                		break;
                	}
                }
                char[] newString = (MainString.toLowerCase()).toCharCharacterArrayay();
        		quickSort(newString,0,(newString.length)-1);
                System.out.println(CharacterArrayays.toString(newString));                
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
        System.out.println("Total number of words : "+count);
    }

    public static void replace(){
        System.out.println("Enter replacing string ");
        String a = input.next();        
        System.out.println("Enter new words for replacing ");
        String b = input.next();

        String newString = "";
        int count = 0;
        
        for (int i = 0; i < MainString.length(); i++) {
            char currentChar = MainString.charAt(i);

            if (MainString.substring(i).startsWith(a)) {
                newString += b;
                i = i + a.length()-1;
                count++;
            }else{
                newString = newString + currentChar;
            }
        }
        if(count==0) {
        	System.out.println("No string found that is to be replaced!!");
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
        if (newString == MainString) {
            System.out.println("The given String is Palindrome");
            return;
        }
        System.out.println("The given String is not Palindrome : "+newString);
    }

    public static void splice(){
        System.out.println("Enter starting Index ");
        int startIndex = input.nextInt();
        
        System.out.println("Enter length from starting Index ");
        int length = input.nextInt();

        String newString = "";
        for (int i = 0; i <MainString.length() ; i++) {
            char currentChar = MainString.charAt(i);
            if (!(i>=startIndex && i<=startIndex+length-1)) {
                newString += currentChar;
            }
        }
        System.out.println("Spliced String : "+newString);
    }

    public static void shift(){
        System.out.println("Enter moving Character : ");
        int n = input.nextInt();
        String firstString = "";
        String secondString = "";
        
        int stringlength = MainString.length();
        for (int i = MainString.length()-1; i >=0 ; i--) {
            if (i>=stringlength-n) {
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
        System.out.println("Enter a pattern for splitting into CharacterArrayay: ");
        input.nextLine();
        String pattern = input.nextLine();
        String[] words = new String[OriginalString.length() + 1];
        int indexCount = 0;
        if (pattern.isEmpty()) {
            System.out.println("Pattern cannot be empty.");
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
        System.out.println(CharacterArrayays.toString(withoutNull));
    }
    public static void quickSort(char[] CharacterArray, int low, int high) {
            if (low < high) {
                int pi = partition(CharacterArray, low, high);

                quickSort(CharacterArray, low, pi - 1);
                quickSort(CharacterArray, pi + 1, high);
            }
     }

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
     public static char[] maxRepeatedChar(String str) {
         if (str == null || str.isEmpty()) {
             return null;
         }
         char maxChar = str.charAt(0);
         int maxFreq = 0;
         for (int i = 0; i < str.length(); i++) {
             char currentChar = str.charAt(i);
             int currentFreq = 0;
             for (int j = 0; j < str.length(); j++) {
                 if (str.charAt(j) == currentChar) {
                     currentFreq++;
                 }
             }
             if (currentFreq > maxFreq) {
                 maxChar = currentChar;
                 maxFreq = currentFreq;
             }
         }
         char[] result = {maxChar, (char) (maxFreq+'0')};
         return result;
     }
     public static void newString() {
    	 Scanner input = new Scanner(System.in);
    	 MainString = input.nextLine();
     }
}
