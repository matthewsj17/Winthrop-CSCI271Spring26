// Question 3 [10 marks]
// Write a JAVA program that reads a list of integers from the user and stores them into an array A,
// then, the program will find the maximum integer in A using a recursive function max().
// Solutions to this question using a loop are not acceptable!! In addition, calculate the running time
// of this function. Show your work in details.

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