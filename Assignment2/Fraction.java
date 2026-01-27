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

        if(denominator == 0){
            switch(numeratorSignage){
                case -1:
                    out = "-Infinity";
                    break;
                case 0:
                    out = "NaN";
                    break;
                case 1:
                    out = "Infinity";
                    break;

            }
        }

        num = String.valueOf(numerator);
        if(denominator == 1){
            den = "1";
            out = num;
        }
        if(denominator!= 0 && denominator != 1){
            den = String.valueOf(denominator);
            out = num + "/" + den;
        }
        
        if((numeratorSignage == -1 && denominatorSignage == -1)){
            num = num.substring(1); // this removes the first character of the string. "-"
            den = den.substring(1); // this removes the first character of the string. "-
            out = num + "/" + den; // output
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