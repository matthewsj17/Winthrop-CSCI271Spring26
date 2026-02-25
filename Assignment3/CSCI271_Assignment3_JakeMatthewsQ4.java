import java.util.Scanner;

// Question 4
// Write a JAVA program that reads in an integer N and a single digit D from the user and displays
// the number of times D occurs in N. The program will use a recursive function that takes N and D
// as arguments and returns the number of times D appears in N recursively!
public class digitOccurance{


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