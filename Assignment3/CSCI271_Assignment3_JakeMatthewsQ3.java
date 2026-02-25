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

    public static int max(int[] A, int numCount, int i){
        int max = A[0];
        //Basecase; if i  hits numCount, then we output whatever max is.
        if(i == numCount-1){
            return max;
        }

        else{
            int newA[] = Arrays.copyOfRange(A, 1, A.length);
            int alternativeMax = max(newA, numCount, i+1);
            if(max < alternativeMax){
                return alternativeMax;
            }
            return max;

        }
    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        int numTotal = input.nextInt();
        int numList[] = new int[numTotal];

        for(int i = 0; i < numTotal; i++){
            System.out.print("Enter your next number: ");
            numList[i] = input.nextInt();
        }

        // Use max() to find the max.
        int maxValue = max(numList, numList.length, 0);
        
        System.out.println("The maximum value in the list is: " + maxValue);

        input.close();


    }

}