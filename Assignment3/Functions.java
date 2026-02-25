import java.util.Arrays;

public class Functions{

// Question 1 [10 marks]
// Write a JAVA program that reads in a string S from the user and displays the length of S. In doing
// so, the program will use a recursive function that takes S as an argument and returns the number
// of characters in S recursively! Solutions to this question using a loop are not acceptable! In
// addition, calculate the running time of this function and show your work in details.
public static int recursiveLength(String s, int currLength){
    
    // BaseCase; if the currLength = s.length(), then we pop back up
    if(currLength == s.length()){
        return currLength;
    } 
    else{
        // Otherwise we increment the currLength to make it reach the base case.
        return recursiveLength(s, currLength + 1); 
    }

}

// Question 2 [20 marks]
// Write a JAVA program that reads a string S and a single character C from the user and displays
// the number of times C occurs in S. This program will use a function that takes S and C as
// arguments and returns the number of times C appears in S recursively! Solutions to this question
// which use a loop are not acceptable! In addition, calculate the running time of this function and
// show your work in details.
public static int characterFinder(String s, char c, int currCount){
    //Basecase: if the string is empty, then we return the number of times 
    if(s == ""){
        return currCount;
    }
    else{
        if(s.charAt(0) == c){
            currCount += 1;
        }
        return characterFinder(s.substring(1), c, currCount);
    }
}

// Question 3 [10 marks]
// Write a JAVA program that reads a list of integers from the user and stores them into an array A,
// then, the program will find the maximum integer in A using a recursive function max().
// Solutions to this question using a loop are not acceptable!! In addition, calculate the running time
// of this function. Show your work in details.
public static int max(int[] A, int numCount, int i){
    int max = A[0];
    //Basecase; if i  hits numCount, then we output whatever max is.
    if(i == numCount){
        return max;
    }

    else{
        if(A[0] < A[1]){
            max = A[1];
        }
        int newA[] = Arrays.copyOfRange(A, 1, A.length);
        max = max(newA, numCount, i);
        return max;
    }

}
}

