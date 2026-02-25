import java.util.Scanner;

// Question 2 [20 marks]
// Write a JAVA program that reads a string S and a single character C from the user and displays
// the number of times C occurs in S. This program will use a function that takes S and C as
// arguments and returns the number of times C appears in S recursively! Solutions to this question
// which use a loop are not acceptable! In addition, calculate the running time of this function and
// show your work in details.
public class characterFinder{

    public static int charNum(String s, char c, int charCount){
    //Basecase: if the string is empty, then we return the number of times c appears 
    if(s == ""){
        return charCount;
    }
    // Recursive Case 
    else{
        if(s.charAt(0) == c){
            charCount += 1;
        }
        return charNum(s.substring(1), c, charCount);
    }
}

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the string to search: ");
        String testString = input.nextLine();
        System.out.print("Enter the character to search for: ");
        char testChar = input.next().charAt(0);

        int length = charNum(testString, testChar, 0);

        System.out.println(testChar + " appears in " + testString + " " + length + " times.");
        input.close();

    }

}