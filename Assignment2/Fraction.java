public class Fraction {
    
    private long numerator; // the top num of a fraction
    private long denominator; // the bottom num of a fraction


    public Fraction(long a, long b){
        this.numerator = a;
        this.denominator = b;
    }
    public Fraction(long a){ // default constructor
        this.numerator = a;
        this.denominator = 1;
    } 

    public long getNumerator(){
        return this.numerator;
    }

    public long getDenominator(){
        return this.denominator;
    }

    public long gcd(long a, long b){
        if (a < 0){
            a = -a;
            while(b != 0){
                int remainder = a % b;
                a = b;
                b = remainder;
            }
            if(a == 0){
                a = 1;
            }
        }
        return a;
    }


    // gcd( a, b ):
    //  if ( a < 0 ) 
    //      then a = -a // to avoid sign problems
    //      while b != 0:
    //          remainder = a % b
    //          a = b
    //          b = remainder
    //      if a == 0
    //          a = 1
    // return a





}