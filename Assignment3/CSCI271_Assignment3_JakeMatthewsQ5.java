import java.util.Scanner;


// Question 5 [20 marks]
// Write a JAVA program that reads in a string S from the user and displays it backwards. The
// program must use a recursive function that takes S as an argument and returns S’ as S but
// backwards. Solutions to this question using a loop are not acceptable! In addition, calculate the
// running time of this function and show your work in details
public class stringReverse{

    public static String reverse(String inString, String outString, int i){
        if(inString == ""){
            return outString;
        }
        else{
            char c = inString.charAt(0);
            inString = inString.substring(1);
            outString = c + outString;
            return reverse(inString, outString, i);

        }
    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        String inString = input.nextLine(); 

        String outString = reverse(inString, "", 0);

        System.out.println(inString + " printed backwards is: " + outString);

        input.close();
    }


}