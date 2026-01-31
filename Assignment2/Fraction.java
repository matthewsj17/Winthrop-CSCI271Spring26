public class Fraction {
    
    private long numerator; // the top num of a fraction
    private long denominator; // the bottom num of a fraction


    public Fraction(long a, long b){
        long gcd = gcd(a, b);
        a /= gcd;
        b /= gcd;
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
        }
        while(b != 0){
                long remainder = a % b;
                a = b;
                b = remainder;
        }
        if(a == 0){
                a = 1;
        }
        return a;
    }

    @Override
    public String toString(){
        String output = "";
        long n = this.getNumerator();
        long d = this.getDenominator();

        int nSign = Long.signum(n);
        int dSign = Long.signum(d);

        // Handling assigning the negative sign to the numerator if present in denominator.
        // THIS ALL MIGHT BE REDUNDANT GCD SEEMS TO SOLVETHIS
        // if(nSign == 1 && dSign == -1){
        //     nSign = -1;
        //     dSign = 1;
        //     n *= -1;
        //     d *= -1;
        // }
        // else if(nSign == -1 && dSign == -1){
        //     nSign = 1;
        //     dSign = 1;
        //     n *= -1;
        //     d *=-1;
        // }

        // Cases where not a number is outputted.
        if(d == 0){
            switch(nSign){
                case -1:
                    output = "-Infinity";
                    break;
                case 0:
                    output = "NaN";
                    break;
                case 1:
                    output = "Infinity";
                    break;

            }
        }
        else if(n == 0){
            output = "0";
        }
        // Cases where a number is outputted
        else if(d == 1){
            output = Long.toString(n);
        }
        else{
            output = output + Long.toString(n) + "/" + Long.toString(d);
        }



        return output;


    }

    public Fraction add(Fraction inFrac){
        long newDen = this.getDenominator() * inFrac.getDenominator();
        long nTemp1 = this.getNumerator() * inFrac.getDenominator();
        long nTemp2 = inFrac.getNumerator() * this.getDenominator();
        long newNum = nTemp1 + nTemp2;
        
        return new Fraction(newNum, newDen);
    }

    public Fraction subtract(Fraction inFrac){
        long newDen = this.getDenominator() * inFrac.getDenominator();
        long nTemp1 = this.getNumerator() * inFrac.getDenominator();
        long nTemp2 = inFrac.getNumerator() * this.getDenominator();
        long newNum = nTemp1 - nTemp2;

        return new Fraction(newNum, newDen);
    }

    public Fraction multiply(Fraction inFrac){
        long newDen = this.getDenominator() * inFrac.getDenominator();
        long newNum = this.getNumerator() * inFrac.getNumerator();
        
        return new Fraction(newNum, newDen);
    }

    public Fraction divide(Fraction inFrac){
        long newNum = this.getNumerator() * inFrac.getDenominator();
        long newDen = this.getDenominator() * inFrac.getNumerator();

        return new Fraction(newNum, newDen);
    }

    public Fraction negate(Fraction inFrac){
        long newNum = this.getNumerator() * -1;

        return new Fraction(newNum, this.getDenominator());
    }

    


}