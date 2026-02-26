/*************************************************************************
* Project 3.4 for CSCI 271-001 Spring 2026
*
* Author: Jake Matthews
* OS: Windows 11
* Compiler: javac 21.0.9
* Date: February 25th, 2026
*
* Purpose
* This program reads in an long integer and a single digit from the user. It
* recursively finds how many times the digit occurs in the long int and
* outputs this to the user.
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
// Question 4
// Write a JAVA program that reads in an integer N and a single digit D from the user and displays
// the number of times D occurs in N. The program will use a recursive function that takes N and D
// as arguments and returns the number of times D appears in N recursively!
import java.util.Scanner;
public class CSCI271_Assignment3_JakeMatthewsQ4{


    /*****************************digitNum()****************************
    * Description: This function identifies how many of a given 
    * digit are present in a long integer.
    *
    * Parameters: long N, int D,
    *
    * Pre: A long N must be created and supplied, 
    * as well as an integer to be searched for (int D).
    *
    * Post: The number of times D occurs in N will be found 
    * recursively.
    *
    * Returns: digitNum() returns the number of times D occurs in N (type int)
    *
    * Called by: digitNum()
    * Calls: digitNum()
    ************************************************************************/
    public static int digitNum(long N, int D){
        
        // Base Case
        // If N = 0, then we have search through every digit in the number.
        // We return how many times D has occured.
        if(N == 0){
            return 0;
        }
        // Recursive Case
        else{
            long oneDigit = N % 10; // Isolate the 'ones' place from N. 
            long newN = N / 10; // remove the ones place from N.
            // If the digit we isolated from N is the digit we are looking for, we increment
            if(oneDigit == D){
                return 1 + digitNum(newN, D);
            }
            else{
                return digitNum(newN, D); // recursively call digitNum() with out newN.
            }
        }
    }
    /*****Time Complexity Calculation*********
     * T(n) = O(1)a + O(1)b + O(1)c + T(n-1) [n = array length] 
     * O(1)a = oneDigit initialization
     * O(1)b = newN initialization
     * O(1)c = incrementation
     * 
     * The time complexity for this is linear [O(n)], 
     * as the time grows linearly with the array's length.
     * 
     *****************************************/

    public static void main(String[] args){

        // Scanner input = new Scanner(System.in); // create input object
        // long N = input.nextLong(); // initialize our long N to be searched
        // int D = input.nextInt(); // initialize our digit to search for within N.
        // int answer = digitNum(N, D); // initlaiize answer variable and 
        // // call our function
        // System.out.println(D + " occurs in " + N + ": " + answer + " times."); // return results to terminal.
        // input.close(); // close input.

        // Test Case 1 (this tests if nothing is entered). [Some logic error perhaps? Unsure how to fix without breaking.]
        int test1 = digitNum(0, 0);
        System.out.println("0 occurs in 0 " + test1 + " times.");

        // Test Case 2 (this tests a normal case).
        int test2 = digitNum(31245871, 1);
        System.out.println("1 occurs in 31245871 " + test2 + " times.");

        // Test Case 3 (this tests a negatives case).
        int test3 = digitNum(31245871, -1);
        System.out.println("-1 occurs in 31245871 " + test3 + " times.");

        
    }
}