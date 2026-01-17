/*************************************************************************
* Project 1 for CSCI 271-001 Spring 2026
*
* Author: Jake Matthews
* OS: Windows 11
* Compiler: javac 25.0.1
* Date: January 23rd, 2026
*
* Purpose
* This program computes the final grade in CSCI 271 based off the 
* grading scale function seen in the syllabus. Users input graded assignments,
* and a final grade is outputted.
*
*************************************************************************/



/************************************************************************
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
* W30661304
************************************************************************/



import java.util.Scanner;
public class CSCI271_Assignment1_JakeMatthews_W30661304 { //matches fileName
    public static void main(String[] args) { // equivalent to C++'s 'int main()'
    
    // Declaring Variables    
    double A, T, M, F; // Variables used in the final Grade calculation.
    double assignments[] = new double[7]; // This is an array with 7 'spaces' to be filled with assignment scores.
    double tests[] = new double[7]; // Similarly, this is an array to be filled with test scores.
    

    Scanner input = new Scanner(System.in); // A Scanner Object, to read input from the terminal.

    // Read In Information from the User.

    System.out.print("Enter All Assignment Grades Seperated by Whitespace on the same line. (ie: 70 50 35... etc): ");

    int num = 0; // incrementation number
    for(double assignment : assignments){
        assignment = input.nextDouble();
        assignments[num] = assignment;
        num++;
    }
    System.out.print("Enter All Test Grades Seperated by Whitespace on the same line. (ie: 70 50 35... etc): ");

    num = 0; // incrementation number
    for(double test : tests){
        test = input.nextDouble();
        tests[num] = test;
        num++;
    }

    System.out.print("Enter Midterm Grade: ");
    M = input.nextDouble();
   

    System.out.print("Enter Final Grade: ");
    F = input.nextDouble();
    
    input.close();

    // Averaging Grades (Creating A, and T)

    double assignmentTotal = 0;
    for (int i = 0; i < assignments.length; ++i) {
        assignmentTotal += assignments[i];
    }
    A = assignmentTotal / 7.0;

    double testTotal = 0;
    for (int i = 0; i < tests.length; ++i){
        testTotal += tests[i];
    }
    T = testTotal / 7.0;

    // Creating E
    }
}