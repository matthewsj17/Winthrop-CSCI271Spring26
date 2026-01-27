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


// These both were automatically added to the file when working on the I/O.
import java.util.Scanner;

public class CSCI271_Assignment1_JakeMatthews_W30661304 { //matches fileName
    public static void main(String[] args) { // equivalent to C++'s 'int main()'
    
    // Declaring Variables    
    double A, T, M, F; // Variables used in the final Grade calculation.
    double assignments[] = new double[7]; // This is an array with 7 'spaces' to be filled with assignment scores.
    double tests[] = new double[7]; // Similarly, this is an array to be filled with test scores.
    
    Scanner input = new Scanner(System.in); // A Scanner Object, to read input from the terminal.

    // Read In Information from the User.
    System.out.print("Enter All Assignment Grades Seperated by Whitespace on the same line. (ie: 70 50 35... etc): "); // give the user information about what they are entering

    // This for loop increments through the 7 slots in the array, and assigns each slot a value that is entered by the user.
    int num = 0; // incrementation number
    for(double assignment : assignments){
        assignment = input.nextDouble(); // Take an assignment input from the user
        assignments[num] = assignment; // Assign input to a space in the array
        num++; // Increment num as to move to the next space in the array.
    }
    System.out.print("Enter All Test Grades Seperated by Whitespace on the same line. (ie: 70 50 35... etc): "); // give the user information about what they are entering

    // This for loop increments through the 7 slots in the array, and assigns each slot a value that is entered by the user.
    num = 0; // incrementation number
    for(double test : tests){
        test = input.nextDouble(); // Take a test input from the user
        tests[num] = test; // Assign input to a space in the array
        num++; // Increment num as to move to the next space in the array.
    }

    System.out.print("Enter Midterm Grade: "); // give the user information about what they are entering

    M = input.nextDouble(); // Take the midterm grade as input from the user and assign it to M.
   

    System.out.print("Enter Final Grade: "); // give the user information about what they are entering

    F = input.nextDouble(); // Take the midterm grade as input from the user and assign it to F.
    
    input.close(); // Close Scanner object. We will not need anymore input from user.

    // Averaging Grades (Creating A, and T)

    double assignmentTotal = 0; // this double keeps track of the total assignment points to calculate average. 
    // This for loop increments through the assignments[] array and adds each value to the assignmentTotal.
    for (int i = 0; i < assignments.length; ++i) {
        assignmentTotal += assignments[i]; // add each value to assignmentTotal
    }
    A = assignmentTotal / 7.0; // we average these values and assign it to variable A. 

    double testTotal = 0; // this double keeps track of the total test points to calculate average. 
    // This for loop increments through the tests[] array and adds each value to the testTotal.
    for (int i = 0; i < tests.length; ++i){
        testTotal += tests[i]; // add each value to testTotal
    }
    T = testTotal / 7.0; // average test scores and assign it to T.

    
    
    // Determining Which G to use. (PieceWise Function)
    double G; // Final Grade
    double E = ((0.4 * F) + (0.2 * M) + (0.1 * T)) / .70; // this is a variable used in the grade calculation's piecewise function.
    double W = ((E - 60) / 20) * 0.3; // variable used in the case of E being between 60 and 80.
  

    // These If/else statements determine which grading scale will be used based off the syllabus.
    if (E >= 80){
        G = (0.4 * F) + (0.2 * M) + (0.1 * T) + (0.3 * A); // If E >= 80, G is determined with Assignments being worth 30%.
    }
    else if (E < 80 && E >= 60){ 
        G = ((1 - W) * E) + (W * A); // If 60 <= E < 80, G is determined using the variable W. Assignments are weighed accordingly.
    }
    else if (E < 60){
        G = E; // If E < 60, then G is just assigned E. Assignments do not contribute towards the final grade.
    }
    // If E does not fall under any of these categories, something has went wrong and we end the program prematurely.
    else{
        System.err.println("Something went wrong, retry the program!");
        G = 0;
        System.exit(0);
    }

    // Output Final Grade to the User.
    System.out.print("The final grade is: ");
    System.out.print(G);

}
}