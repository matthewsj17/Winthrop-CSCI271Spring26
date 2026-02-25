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

// Question 4
// Write a JAVA program that reads in an integer N and a single digit D from the user and displays
// the number of times D occurs in N. The program will use a recursive function that takes N and D
// as arguments and returns the number of times D appears in N recursively!
import java.util.Scanner;
public class CSCI271_Assignment3_JakeMatthewsQ4{


    public static int digitNum(long N, int D, int occurances){
        
        if(N == 0){
            return occurances;
        }
        else{

            long oneDigit = N % 10;
            long newN = N / 10;
            if(oneDigit == D){
                occurances += 1;
            }
            return digitNum(newN, D, occurances);
        }
        


    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        long N = input.nextLong();
        int D = input.nextInt();
        int answer = digitNum(N, D, 0);

        System.out.println(D + " occurs in " + N + ": " + answer + " times.");

        input.close();
    }





}