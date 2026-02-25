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

/*
* Question 1 [10 marks]
* Write a JAVA program that reads in a string S from the user and displays the length of S. In doing
* so, the program will use a recursive function that takes S as an argument and returns the number
* of characters in S recursively! Solutions to this question using a loop are not acceptable! In
* addition, calculate the running time of this function and show your work in details.
*/

import java.util.Scanner;

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