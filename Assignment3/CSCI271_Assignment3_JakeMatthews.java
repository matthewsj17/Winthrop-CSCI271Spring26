import java.util.Scanner;

public class CSCI271_Assignment3_JakeMatthews {
    public static void main(String[] args) {
        
    
    Scanner input = new Scanner(System.in);

    
    // String testString = input.nextLine();
    // int stringLength = Functions.recursiveLength(testString, 0);

    // System.out.println("The length of the string is: " + stringLength + ".");

    // String testString = "chocolate";
    // char testChar = 'c';
    // int ans = Functions.characterFinder(testString, testChar, 0);

    // System.out.println("The char is in the string " + ans + " times.");

    int[] numList = {1, 2, 3, 4, 5};

    System.out.println("The highest number is: " + Functions.max(numList, 10, 0) + ".");

    input.close();
    }


}