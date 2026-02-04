// import java.util.Scanner;

public class CSCI271_Assignment2_JakeMatthews {
    public static void main(String[] args) { 

        // Scanner input = new Scanner(System.in);
        long num = 2;
        long den = 4;
        Fraction test = new Fraction(num, den);
        System.out.println(test.pow(2));
        System.out.println(test.pow(-2));
        System.out.println(test.pow(0));

        // input.close();
    }
}
    //     System.out.println("---Testing Implementation of Fraction Class---");
    //     System.out.println("1) Construction of Fractions");

    //     System.out.println("a) GCD Algorithm: 6/-24 => -1/4");
    //     Fraction fractionTest = new Fraction(6,-24);
    //     System.out.print("Numerator: " + fractionTest.getNumerator());
    //     System.out.println(" Denominator: " + fractionTest.getDenominator() + "\n");

    //     System.out.println("a) GCD Algorithm: 0/8 => 0/1");
    //     Fraction fractionTest2 = new Fraction(0,8);
    //     System.out.print("Numerator: " + fractionTest2.getNumerator());
    //     System.out.println(" Denominator: " + fractionTest2.getDenominator() + "\n");

    //     System.out.println("b) Numbers 7/1: 7 => 0/1");
    //     Fraction fractionTest3 = new Fraction(7);
    //     System.out.print("Numerator: " + fractionTest3.getNumerator());
    //     System.out.println(" Denominator: " + fractionTest3.getDenominator() + "\n");


    //     System.out.println("2) toString() Function");
    //     System.out.println("The following fractions are used: (8/6), (23/0), (-6/0), (7/1), (0/0)");
        
    //     Fraction fr = new Fraction(8, -6); System.out.println(fr); // fr.toString() is "-4/3"
    //     Fraction fr2 = new Fraction(23, 0); System.out.println(fr2); // fr.toString() is "Infinity"
    //     Fraction fr3 = new Fraction(-6, 0); System.out.println(fr3); // fr.toString() is "-Infinity"
    //     Fraction fr4 = new Fraction(7, 1); System.out.println(fr4); // fr.toString() is "7" (not "7/1")
    //     Fraction fr5 = new Fraction(0, 0); System.out.println(fr5); // fr.toString() is "NaN

    //     System.out.println("3) Mathematical Functions");
    //     System.out.println("The following fraction pairs are used per mathematical function: ");
    //     System.out.println("[(8/6), (2/3)] [(-6/0), (7/1)] [(0/0) (3/4)]");

    //     System.out.println("a) add()");
    //     Fraction add1a = new Fraction(8,6);
    //     Fraction add1b = new Fraction(2, 3);
    //     Fraction add1c = add1a.add(add1b);
    //     System.out.println(add1c);


    //     Fraction add2a = new Fraction(-6,0);
    //     Fraction add2b = new Fraction(7, 1);
    //     add2a.add(add2b);
    //     Fraction add2c = add2a.add(add2b);
    //     System.out.println(add2c);

    //     Fraction add3a = new Fraction(0,0);
    //     Fraction add3b = new Fraction(3, 4);
    //     add3a.add(add3b);
    //     Fraction add3c = add3a.add(add3b);
    //     System.out.println(add3c);

    //     System.out.println("b) subtract()");
    //     Fraction sub1a = new Fraction(8,6);
    //     Fraction sub1b = new Fraction(2, 3);
    //     Fraction sub1c = sub1a.subtract(sub1b);
    //     System.out.println(sub1c.toString());


    //     Fraction sub2a = new Fraction(-6,0);
    //     Fraction sub2b = new Fraction(7, 1);
    //     sub2a.subtract(sub2b);
    //     Fraction sub2c = sub2a.subtract(sub2b);
    //     System.out.println(sub2c.toString());

    //     Fraction sub3a = new Fraction(0,0);
    //     Fraction sub3b = new Fraction(3, 4);
    //     sub3a.subtract(sub3b);
    //     Fraction sub3c = sub3a.subtract(sub3b);
    //     System.out.println(sub3c.toString());

    //     System.out.println("c) multiply()");
    //     Fraction mul1a = new Fraction(8,6);
    //     Fraction mul1b = new Fraction(2, 3);
    //     Fraction mul1c = mul1a.multiply(mul1b);
    //     System.out.println(mul1c.toString());


    //     Fraction mul2a = new Fraction(-6,0);
    //     Fraction mul2b = new Fraction(7, 1);
    //     mul2a.multiply(mul2b);
    //     Fraction mul2c = mul2a.multiply(mul2b);
    //     System.out.println(mul2c.toString());

    //     Fraction mul3a = new Fraction(0,0);
    //     Fraction mul3b = new Fraction(3, 4);
    //     mul3a.multiply(mul3b);
    //     Fraction mul3c = mul3a.multiply(mul3b);
    //     System.out.println(mul3c.toString());

    //     System.out.println("d) divide()");
    //     Fraction div1a = new Fraction(8,6);
    //     Fraction div1b = new Fraction(2, 3);
    //     Fraction div1c = div1a.divide(div1b);
    //     System.out.println(div1c.toString());


    //     Fraction div2a = new Fraction(-6,0);
    //     Fraction div2b = new Fraction(7, 1);
    //     div2a.divide(div2b);
    //     Fraction div2c = div2a.divide(div2b);
    //     System.out.println(div2c.toString());

    //     Fraction div3a = new Fraction(0,0);
    //     Fraction div3b = new Fraction(3, 4);
    //     div3a.divide(div3b);
    //     Fraction div3c = div3a.divide(div3b);
    //     System.out.println(div3c.toString());

    //     System.out.println("e) negate()");
    //     System.out.println("The following fractions are used for negate(): ");
    //     System.out.println("(8/6) (2/3) (-6/0) (7/1) (0/0) (3/4)");
    //     Fraction neg1a = new Fraction(8,6);
    //     System.out.println(neg1a.negate());
    //     Fraction neg2a = new Fraction(2,3);
    //     System.out.println(neg2a.negate());
    //     Fraction neg3a = new Fraction(-6,0);
    //     System.out.println(neg3a.negate());
    //     Fraction neg4a = new Fraction(7,1);
    //     System.out.println(neg4a.negate());
    //     Fraction neg5a = new Fraction(0,0);
    //     System.out.println(neg5a.negate());
    //     Fraction neg6a = new Fraction(3,4);
    //     System.out.println(neg6a.negate());

    //     System.out.println("e) pow()");
    //     System.out.println("The following fractions are used for pow(): ");
    //     System.out.println("(8/6) (-6/0) (7/1) (0/0)");
    //     System.out.println("The following powers are used for pow(): ");
    //     System.out.println("-2    0    2    -10    2000");

    //     Fraction pow1 = new Fraction(8,6);
    //     System.out.println(pow1.pow(-2));
    //     System.out.println(pow1.pow(0));
    //     System.out.println(pow1.pow(2));
    //     System.out.println(pow1.pow(10));
    //     System.out.println(pow1.pow(2000));

    //     Fraction pow2 = new Fraction(-6,0);
    //     System.out.println(pow2.pow(-2)); // don't work for negative
    //     System.out.println(pow2.pow(0));
    //     System.out.println(pow2.pow(2));
    //     System.out.println(pow2.pow(10));
    //     System.out.println(pow2.pow(2000));

    //     Fraction pow3 = new Fraction(7,1);
    //     System.out.println(pow3.pow(-2));
    //     System.out.println(pow3.pow(0));
    //     System.out.println(pow3.pow(2));
    //     System.out.println(pow3.pow(10));
    //     System.out.println(pow3.pow(2000));

    //     Fraction pow4 = new Fraction(0,0);
    //     System.out.println(pow4.pow(-2));
    //     System.out.println(pow4.pow(0));
    //     System.out.println(pow4.pow(2));
    //     System.out.println(pow4.pow(10));
    //     System.out.println(pow4.pow(2000));

    // }
// }

 // a


//  Old Test

//   Scanner input = new Scanner(System.in);
//         long num = input.nextLong();
//         long den = input.nextLong();
//         // Fraction test = new Fraction(num, den);
//         // String testPrint = test.toString();
//         // System.out.println(testPrint);

//         // Fraction AddTest = new Fraction(num, den);
//         // Fraction AddTest2 = new Fraction(2,3);
//         // AddTest = AddTest.add(AddTest2);

//         // String AddTestPrint = AddTest.toString();
//         // System.out.println(AddTestPrint);

//         Fraction SubTest = new Fraction(num, den);
//         Fraction SubTest2 = new Fraction(2,3);
//         SubTest = SubTest.add(SubTest2);

//         String SubTestPrint = SubTest.toString();
//         System.out.println(SubTestPrint);

//         input.close();