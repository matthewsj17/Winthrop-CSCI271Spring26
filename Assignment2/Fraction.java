public class Fraction {
    
    private long numerator; // the top num of a fraction
    private long denominator; // the bottom num of a fraction

    public Fraction(long a){ // default constructor
        numerator = a;
        denominator = 1;
    } 

    public Fraction(long a, long b){
        numerator = a;
        denominator = b;
    }

    public String toString(Fraction f){
        String out = "";
        String num = "";
        String den = "";

        if(f.denominator == 1){
            num = String.valueOf(f.numerator);
            den = "1";
            out = num + "/" + den;
        }

        return out;
    }





    // Methods of Fraction

    // public int GetNumerator(){
    //     return numerator;
    // }

    // public int GetDenominator(){
    //     return denominator;
    // }

    // public Fraction add(Fraction f){
    //     return f;
    // }

    // public Fraction subtract(Fraction f){
    //     return f;
    // }
    // public Fraction multiply(Fraction f){
    //     return f;
    // }

    // public Fraction divide(Fraction f){
    //     return f;
    // }

    // public Fraction negate(Fraction f){
    //     return f;
    // }
    


}