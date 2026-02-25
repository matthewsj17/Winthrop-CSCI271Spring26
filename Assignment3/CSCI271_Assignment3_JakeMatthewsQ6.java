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

    public static int evenSum(int[] A, int sum, int numCount, int i){
        if(i == numCount){
            return sum;
        }
        else{
            if((A[0] % 2) == 0){
                sum += A[0];
            }
            int newA[] = Arrays.copyOfRange(A, 1, A.length);

            return evenSum(newA, sum, numCount, i+1);
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

        int evenSum = evenSum(numList, 0, numList.length, 0);
        System.out.println("The evenSum of the list is: " + evenSum);

        input.close();


    }

}