/*************************************************************************
* Project 3.3 for CSCI 271-001 Spring 2026
*
* Author: Jake Matthews
* OS: Windows 11
* Compiler: javac 21.0.9
* Date: February 25th, 2026
*
* Purpose
* This program reads a list of integers from the user and finds the 
* maximum (largest integer) in the list entered. It does this recursively.
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
Question 3 [10 marks]
Write a JAVA program that reads a list of integers from the user and stores them into an array A,
then, the program will find the maximum integer in A using a recursive function max().
Solutions to this question using a loop are not acceptable!! In addition, calculate the running time
of this function. Show your work in details.
*/

import java.util.Arrays;
import java.util.Scanner;

public class CSCI271_Assignment3_JakeMatthewsQ3{


    /*****************************max()****************************
    * Description: The function finds the maximum value within a given array.
    *
    * Parameters: int[] A, int numCount, int i
    *
    * Pre: The array A must be created and filled with integers before max
    * can be called. 
    *
    * Post: The function will find the maximum value recursively.
    *
    * Returns: The function returns the maximum value found (type int).
    *
    * Called by: max()
    * Calls: max()
    ************************************************************************/
    public static int max(int[] A, int numCount, int i){
        // assume the first number in the array is the max.
        int max = A[0];
        //Basecase; if i  hits numCount-1 (number of spots in the array), then we output whatever max is.
        if(i >= numCount-1){
            return max;
        }
        // Recursive Case
        else{
            int newA[] = Arrays.copyOfRange(A, 1, A.length); // create new array, missing the first number.
            int alternativeMax = max(newA, numCount, i+1); // find the max of this new array.
            if(max < alternativeMax){ // compare the currentMax with the alternativeMax value.
                return alternativeMax; // if alternative is larger, return the alternativeMax.
            }
            return max; // otherwise return the max we got in this function call.

        }
    }

    /*****Time Complexity Calculation*********
     * T(n) = O(n)
     * 
     * The time complexity for this is linear [O(n)],
     * as the time grows linearly with the array's length
     * 
     *****************************************/

    public static void main(String[] args){

        // Scanner input = new Scanner(System.in); // create input object
        // int numTotal = input.nextInt(); //// allocate a number for the total amount in the array.
        // int numList[] = new int[numTotal]; // allocate space for the array in the heap.
        // // For every number in the array, prompt the user to enter a number.
        // for(int i = 0; i < numTotal; i++){
        //     System.out.print("Enter your next number: ");
        //     numList[i] = input.nextInt(); // assign this number to the next avaliable array space.
        // }
        // // Use max() to find the max.
        // int maxValue = max(numList, (numList.length-1), 0); // initialize maxValue and assign it to the recursive functions result.
        // System.out.println("The maximum value in the list is: " + maxValue); // return value to user.
        // input.close(); // close input

        // Test Case 1 (this tests if nothing is entered). [THIS RETURNS AN OUTOFBOUNDS EXCEPTION]
        // int[] a1 = {};
        // int test1 = max(a1, 0, 0);
        // System.out.println("The max of [] is: " + test1);

        // Test Case 2 (this tests a sorted case).
        int[] a2 = {1, 2, 3, 4, 5};
        int test2 = max(a2, 5, 0);
        System.out.println("The max of [1, 2, 3, 4, 5] is: " + test2);

        // Test Case 3 (this tests an unsorted case)
        int[] a3 = {15, 10, 5, 2, 0};
        int test3 = max(a3, 5, 0);
        System.out.println("The max of [15, 10, 5, 2, 0] is: " + test3);

        // Test Case 4 (negative numbers)
        int[] a4 = {-11, -1, 0, 1 ,11};
        int test4 = max(a4, 5, 0);
        System.out.println("The max of [-11, -1, 0, 1, 11] is: " + test4);

    }

}