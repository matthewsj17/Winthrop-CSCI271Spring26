/*************************************************************************
* Project 2 for CSCI 271-001 Spring 2026
*
* Author: Jake Matthews
* OS: Windows 11
* Compiler: javac 21.0.9
* Date: February 6, 2026
*
* Purpose
* This program tests the accompaning Fraction.java class. All functions 
* within the fraction class are tested accordingly.
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


public class CSCI271_Assignment2_JakeMatthews {
    public static void main(String[] args) { 

        Fraction TestingArray[] = new Fraction[7];

        // Req Fractions
        // 6/-24
        // 0/8
        // 8/-6
        // 23/0
        // -6/0
        // 7/1
        // 0/0
        TestingArray[0] = new Fraction(6, -24);
        TestingArray[1] = new Fraction(0, 8);
        TestingArray[2] = new Fraction(8, -6);
        TestingArray[3] = new Fraction(23, 0);
        TestingArray[4] = new Fraction(-6, 0);
        TestingArray[5] = new Fraction(7, 1);
        TestingArray[6] = new Fraction(0, 0);

        System.out.println("---Testing Implementation of Fraction Class---");
        System.out.println("\n"+ "1) Construction of Fractions");

        System.out.println("a) GCD Algorithm: 6/-24 => -1/4");

        for(int i = 0; i < TestingArray.length; i++){
            System.out.print("Numerator: " + TestingArray[i].getNumerator());
            System.out.println(" Denominator: " + TestingArray[i].getDenominator());
        }

        System.out.println("b) Numbers 7/1: 7 => 0/1");
        
        for(int i = 0; i< TestingArray.length; i++){
            // System.out.print()
        }
    //     Fraction fractionTest3 = new Fraction(7);
    //     System.out.print("Numerator: " + fractionTest3.getNumerator());
    //     System.out.println(" Denominator: " + fractionTest3.getDenominator() + "\n");


        System.out.println("2) toString() Function");
        for(int i = 0; i < TestingArray.length; i++){
            System.out.println(TestingArray[i]);
        }

        System.out.println("3) Mathematical Functions");

        System.out.println("a) add()");
        for(int i = 0; i < TestingArray.length/2; i++){
            System.out.println(TestingArray[i].add(TestingArray[i+1]));
        }

        System.out.println("b) subtract()");
        for(int i = 0; i < TestingArray.length/2; i++){
            System.out.println(TestingArray[i].subtract(TestingArray[i+1]));
        }

        System.out.println("c) multiply()");
        for(int i = 0; i < TestingArray.length/2; i++){
            System.out.println(TestingArray[i].multiply(TestingArray[i+1]));
        }
        
        System.out.println("d) divide()");
        for(int i = 0; i < TestingArray.length/2; i++){
            System.out.println(TestingArray[i].divide(TestingArray[i+1]));
        }


        System.out.println("e) negate()");
        for(int i = 0; i < TestingArray.length; i++){
            System.out.println(TestingArray[i].negate());
        }

        System.out.println("f) pow()");
        int PowArray[] = new int[5];
        PowArray[0] = -2;
        PowArray[1] = -10;
        PowArray[2] = 0;
        PowArray[3] = 2;
        PowArray[4] = 2000;
        for(int i = 0; i < TestingArray.length; i++){
            System.out.println("Fraction: " + TestingArray[i]);
            for(int j = 0; j < 5; j++){
                System.out.println("Power: " + PowArray[j]);
                System.out.println(TestingArray[i].pow(PowArray[j]));
            }
        }


    }
}