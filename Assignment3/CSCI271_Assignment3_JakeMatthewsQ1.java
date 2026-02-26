/*************************************************************************
* Project 3.1 for CSCI 271-001 Spring 2026
*
* Author: Jake Matthews
* OS: Windows 11
* Compiler: javac 21.0.9
* Date: February 25th, 2026
*
* Purpose
* This program reads a string from the user and 
* recursively finds the length of the string before 
* outputting this length to the user.
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
* Question 1 [10 marks]
* Write a JAVA program that reads in a string S from the user and displays the length of S. In doing
* so, the program will use a recursive function that takes S as an argument and returns the number
* of characters in S recursively! Solutions to this question using a loop are not acceptable! In
* addition, calculate the running time of this function and show your work in details.
*/

import java.util.Scanner;

public class CSCI271_Assignment3_JakeMatthewsQ1{


    /*****************************length()****************************
    * Description: This function finds the length of a string recursively. 
    *
    * Parameters: a list each parameter the function takes
    *
    * Pre: list the preconditions; i.e., the things that must be true
    * before the function is called. Usually these involve whether
    * and how parameters must be initialised before the call, etc.
    *
    * Post: List the postconditions; i.e., the things that are guaranteed
    * to be true when the function finishes, assuming that the
    * listed preconditions are satisfied.
    *
    * Returns: Describe what value the function returns, if any.
    *
    * Called by: list the name(s) of the function(s) that call this one.
    * Calls: list the name(s) of the function(s) that this one calls.
    ************************************************************************/
    public static int length(String s){
        // Base Case; if s has no characters left, we've looked at all of them.
        if(s == ""){
            return 0;
        } 
        // Recursive Case
        // Call 1 + length() with the string missing its first character 
        // (1 states we've searched one character so far, this increments as we recursively search)
        else{
            return 1 + length(s.substring(1)); 
        }
    }

    /*****Time Complexity Calculation*********
     * T(n) = O(1) + T(n-1) * O(n) [n = string length]
     * 
     * T(n-1) = length(*NEW STRING*)
     * O(n)   = s.substring(1)
     * O(1)   = 1 + (Above Information)
     * 
     * 
     * The time complexity for this is O(n^2), as the time grows quadratically 
     * with the string's length. This is because to remove a character from the string
     * using java's substring() function is of linear time, and we must increment through every letter.
     * 
     *****************************************/
    public static void main(String[] args){

        //  The below code is commented out, but is used to read information in and test that information.
        // I commented this code out due to the Test Cases section of the Evalutation portion on the rubric.
        // "Test cases in the main program will be graded with another 10% — please document these
        // clearly. For each test case, please explain the condition it tests and how it does so briefly"

        /*Scanner input = new Scanner(System.in); // create input object
        String testString = input.nextLine(); // initialize the string to find the length of
        int length = length(testString); // call the function, assign its value to int length.
        System.out.println("Length: " + length); // return value to user.
        input.close(); // close input
        */

        // Test Case 1 (this tests if nothing is entered).
        int length1 = length("");
        System.out.println("The length of '' is: " + length1);

        // Test Case 2 (tests a normal word)
        int length2 = length("Assignment");
        System.out.println("The length of 'Assignment' is: " + length2);

        // Test Case 3 (tests whitespace)
        int length3 = length("Hello World!");
        System.out.println("The length of 'Hello World!' is: " + length3);
    }

    
}