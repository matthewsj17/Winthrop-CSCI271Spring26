/*************************************************************************
* Project 3.2 for CSCI 271-001 Spring 2026
*
* Author: Jake Matthews
* OS: Windows 11
* Compiler: javac 21.0.9
* Date: February 25th, 2026
*
* Purpose
* This program reads a string and a character from the user and displays
* the number of times that the character occurs in the string. It does 
* this recursively using the charNum() function.
*
*************************************************************************/
/*******************************************************************
* I declare and confirm the following:
* - I have not discussed this program code with anyone other than my
* instructor or the teaching assistants assigned to this course.
* - I have not used programming code obtained from someone else,
* or any unauthorised sources, including the Internet, either
* modified or unmodified.
* - If any source code or documentation used in my program was
* obtained from other sources, like a text book or course notes,
* I have clearly indicated that with a proper citation in the
* comments of my program.
* - I have not designed this program in such a way as to defeat or
* interfere with the normal operation of the supplied grading code.
*
* Jake Matthews
********************************************************************/
/* 
* Question 2 [20 marks]
* Write a JAVA program that reads a string S and a single character C from the user and displays
* the number of times C occurs in S. This program will use a function that takes S and C as
* arguments and returns the number of times C appears in S recursively! Solutions to this question
* which use a loop are not acceptable! In addition, calculate the running time of this function and
* show your work in details.
*/
import java.util.Scanner;
public class CSCI271_Assignment3_JakeMatthewsQ2{


    /*****************************charNum()****************************
    * Description: This functions finds the number of times a character
    * occurs in a string. (CASE SENSITIVE)
    *
    * Parameters: String s, char c, int charCount
    *
    * Pre: A specific string and character must be supplied to the function 
    * (charCount is always 0 at start)
    *
    * Post: The value of c's occurances in s is found.
    *
    * Returns: The function returns charCount, an int with the number of c's
    * occurances in s. 
    *
    * Called by: charNum()
    * Calls: charNum()
    ************************************************************************/
    public static int charNum(String s, char c, int charCount){
    //Basecase: if the string is empty, then we return the number of times c appears 
    if(s == ""){
        return charCount;
    }
    // Recursive Case 
    else{
        // if the first character of the string is the character we are looking for, increment charCount.
        if(s.charAt(0) == c){ 
            charCount += 1;
        }
        
        return charNum(s.substring(1), c, charCount); // call charNum again, missing the first character of s.
    }
}
    /*****Time Complexity Calculation*********
     * T(n) = T(n-1) + O(1) 
     * 
     * T(n-1) = return charNum(s.substring(1), c, charCount);
     * O(1) =  if(s.charAt(0) == c) charCount += 1;
     * 
     * For this reason, the function charNum() grows linearly, 
     * with a big O notation of O(n).
     * 
     *****************************************/



    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in); // create input object
        
        System.out.print("Enter the string to search: ");
        String testString = input.nextLine(); // initialize string to search
        System.out.print("Enter the character to search for: ");
        char testChar = input.next().charAt(0); // initialize char to search for

        int length = charNum(testString, testChar, 0); // initialize length, and assign it the value of the function call

        System.out.println(testChar + " appears in " + testString + " " + length + " times."); // return value to user.
        input.close(); // close input

    }

}