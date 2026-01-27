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

    public String fracToString(){
        String out = "";
        String num = "";
        String den = "";
        int numeratorSignage = Long.signum(numerator);
        int denominatorSignage = Long.signum(denominator);

        num = String.valueOf(numerator);

        if(denominator == 0){
            switch(numeratorSignage){
                case -1:
                    out = "-Infinity";
                case 0:
                    out = "NaN";
                case 1:
                    out = "Infinity";

                default:
                    System.err.println("Something went wrong!");
                    break;
            }
        }
        if(denominator == 1){
            den = "1";
            out = num + "/" + den;
        }
        if(denominator!= 0 && denominator != 1){
            den = String.valueOf(denominator);
            out = num + "/" + den;
        }
        
        if((numeratorSignage == -1 && denominatorSignage == -1)){
            out =  num + "/" + den;
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