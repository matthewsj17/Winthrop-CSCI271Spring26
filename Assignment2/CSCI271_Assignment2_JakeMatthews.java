import java.util.Scanner;

public class CSCI271_Assignment2_JakeMatthews {
    public static void main(String[] args) { 
         Scanner input = new Scanner(System.in);
        long num = input.nextLong();
        long den = input.nextLong();
        Fraction test = new Fraction(num, den);
        String testPrint = test.toString();
    
        System.out.println(testPrint);

        input.close();
    
    
    }
}

 // a