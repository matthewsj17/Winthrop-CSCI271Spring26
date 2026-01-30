import java.util.Scanner;

public class CSCI271_Assignment2_JakeMatthews {
    public static void main(String[] args) { 
         Scanner input = new Scanner(System.in);
        long num = input.nextLong();
        long den = input.nextLong();
        // Fraction test = new Fraction(num, den);
        // String testPrint = test.toString();
        // System.out.println(testPrint);

        // Fraction AddTest = new Fraction(num, den);
        // Fraction AddTest2 = new Fraction(2,3);
        // AddTest = AddTest.add(AddTest2);

        // String AddTestPrint = AddTest.toString();
        // System.out.println(AddTestPrint);

        Fraction SubTest = new Fraction(num, den);
        Fraction SubTest2 = new Fraction(2,3);
        SubTest = SubTest.add(SubTest2);

        String SubTestPrint = SubTest.toString();
        System.out.println(SubTestPrint);

        input.close();
    
    
    }
}

 // a