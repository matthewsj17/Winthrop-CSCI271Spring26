/*************************************************************************
* Project 3.5 for CSCI 271-001 Spring 2026
*
* Author: Jake Matthews
* OS: Windows 11
* Compiler: javac 21.0.9
* Date: February 25th, 2026
*
* Purpose
* This program reads a string in from the user and uses recursion to 
* display it in backwards ordfer back to the user.
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

// Question 5 [20 marks]
// Write a JAVA program that reads in a string S from the user and displays it backwards. The
// program must use a recursive function that takes S as an argument and returns S’ as S but
// backwards. Solutions to this question using a loop are not acceptable! In addition, calculate the
// running time of this function and show your work in details
import java.util.Scanner;
public class CSCI271_Assignment3_JakeMatthewsQ5{

    /*****************************reverse()****************************
    * Description: The function recursively reverses a string and 
    * returns it to the user.
    *
    * Parameters: String inString, String outString, int i
    *
    * Pre: inString must be allocated in main.
    *
    * Post: inString will be reversed and returned to the user.
    *
    * Returns: The reversed string will be returned. 
    *
    * Called by: reverse()
    * Calls: reverse()
    ************************************************************************/
    public static String reverse(String inString){
        // Base Case. If our inString contains nothing, 
        // then we've incremented through the whole string and return the reversed string.
        if(inString == ""){ 
            return "";
        }
        // Recursive Case
        // We get the first character from the inString, remove it from inString, 
        // and add it to the end of the reversed string.
        else{
            char c = inString.charAt(0); // isolate 1st char
            inString = inString.substring(1); // remove 1st char from string.
            return reverse(inString) + c; // recursively call the function including the first c at the front.

        }
    }
    /*****Time Complexity Calculation*********
     * T(n) = O(1) + O(1) + O(1) + T(n-1)
     * 
     * The time complexity for this is linear [O(n)], 
     * as the time grows linearly with the inString's length
     * 
     *****************************************/

    public static void main(String[] args){

        // Scanner input = new Scanner(System.in); // create input object
        // System.out.print("Enter the string to be reversed: ");
        // String inString = input.nextLine();  // allocate space for the string and initialize it.
        // String outString = reverse(inString); // allocate space for outString, and call the reverse function.
        // System.out.println(inString + " printed backwards is: " + outString); // return result to terminal.
        // input.close(); // close input.

        // Test Case 1 (this tests if nothing is entered).
        String test1 = reverse("");
        System.out.println("'' backwards is: " + test1 );

        // Test Case 2 (this tests a normal case).
        String test2 = reverse("Labrador");
        System.out.println("'Labrador' backwards is: " + test2);

        // Test Case 3 (this tests whitespace case).
        String test3 = reverse("Jake Matthews");
        System.out.println("'Jake Matthews' backwards is: " + test3);
    }
}