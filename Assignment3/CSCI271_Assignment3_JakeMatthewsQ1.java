import java.util.Scanner;

// Question 1 [10 marks]
// Write a JAVA program that reads in a string S from the user and displays the length of S. In doing
// so, the program will use a recursive function that takes S as an argument and returns the number
// of characters in S recursively! Solutions to this question using a loop are not acceptable! In
// addition, calculate the running time of this function and show your work in details.
public class CSCI271_Assignment3_JakeMatthewsQ1{


    public static int length(String s, int currLength){
        // Base Case; if s has no characters left, we've looked at all of them.
        if(s == ""){
            return currLength;
        } 
        // Recursive Case
        else{
            return length(s.substring(1), currLength); 
        }
    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        
        String testString = input.nextLine();

        int length = length(testString, 0);

        System.out.println("Length: " + length);
        input.close();

    }

    
}