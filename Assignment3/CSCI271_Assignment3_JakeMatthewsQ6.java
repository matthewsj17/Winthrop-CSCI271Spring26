/*************************************************************************
* Project 3.6 for CSCI 271-001 Spring 2026
*
* Author: Jake Matthews
* OS: Windows 11
* Compiler: javac 21.0.9
* Date: February 25th, 2026
*
* Purpose
* This program reads a list from the user, and summs only the even numbers together.
* This is done recursively using the evenSum() function, and the result is sent to the user.
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
// Question 6 [20 marks]
// Write a JAVA program that reads a list of integers from the keyboard and stores them into an
// array A, then, the program will return the sum of all even integers in A using a recursive function
// sumEven(). The program will then print the resulting sum to the screen. In doing so, the function
// must be recursive and should not print anything to the screen, the main program will! Solutions
// to this question using a loop are not acceptable! In addition, calculate the running time of this
// function and show your work in details

import java.util.Arrays;
import java.util.Scanner;
public class CSCI271_Assignment3_JakeMatthewsQ6{

    /*****************************<evenSum()>****************************
    * Description: a brief description of what the function does.
    *
    * Parameters: int[] A, int sum, int numCount, int i
    *
    * Pre: All parameters must be initialized before the function call. 
    *      int[] A especially, as it is used to find int numCount.
    *
    * Post: The function will calculate the evenSum of the array and return
    *       the int value of the evenSum to the user.
    *
    * Returns: The int value of the evenSum to the user.
    *
    * Called by: evenSum()
    * Calls: evenSum()
    ************************************************************************/

    public static int evenSum(int[] A, int sum, int numCount, int i){
        // Base Case
        // if our incrementation value = the length of the array, we've sorted through the whole list.
        if(i == numCount){ 
            return sum;
        }
        // Recursive Case
        else{
            // If the number is is even, then we add it to the total sum. If it is odd, we do nothing.
            if((A[0] % 2) == 0){ 
                sum += A[0];
            }
            // We create a new array that doesn't include the number we just tested previously.
            int newA[] = Arrays.copyOfRange(A, 1, A.length);

            // We recurively call the function with the new array and i+1 to keep track of progress.
            return evenSum(newA, sum, numCount, i+1);
        }


    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in); // create input device

        System.out.println("Enter how many numbers will be used in the evenSum() function: ");
        int numTotal = input.nextInt(); // allocate a number for the total amount in the array.
        int numList[] = new int[numTotal]; // allocate space for the array in the heap.

        // For every number in the array, prompt the user to enter a number.
        for(int i = 0; i < numTotal; i++){
            System.out.print("Enter your next number: ");
            numList[i] = input.nextInt(); // assign this number to the next avaliable array space.
        }

        // initialize evenSum value and call recursive function with necessary information
        // (sum and i both as zero to begin.)
        int evenSum = evenSum(numList, 0, numList.length, 0); 
        System.out.println("The evenSum of the list is: " + evenSum); // output result to user.

        input.close(); // close input.


    }

}