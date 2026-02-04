public class Fraction {
    
    private long numerator; // the top num of a fraction
    private long denominator; // the bottom num of a fraction


    public Fraction(long a, long b){
        long gcd = gcd(a, b); // the greatest common denominator between a and b.
        a /= gcd; // a is divided by the gcd to simplify the fraction
        b /= gcd; // b is divided by the gcd to simplify the fraction
        this.numerator = a; // a takes the place of the numerator in the fraction object
        this.denominator = b; // b takes the place of the denominator in the fraction object
    }
    public Fraction(long a){ // default constructor
        this.numerator = a; // we set a to the numerator.
        this.denominator = 1; // since this call doesn't get a denominator value, we assume 1 as instructed. 
    } 

    
    /*****************************<getNumerator()>***********************************
    * Description: Returns the numerator (a long variable) to the user.
    * Parameters: n/a
    * Pre: A fraction must be created to call this function.
    * Post: The numerator of the specified fraction will be returned.
    * Returns: The numerator of the fraction, of type long.
    * Called by: toString(), add(), subtract(), multiply(), divide(), negate(), pow().
    * Calls: n/a
    *********************************************************************************/
    public long getNumerator(){ 
        return this.numerator;
    }


    /*****************************<getDenominator()>***********************************
    * Description: Returns the denominator (a long variable) to the user.
    * Parameters: n/a
    * Pre: A fraction must be created to call this function.
    * Post: The denominator of the specified fraction will be returned.
    * Returns: The denominator of the fraction, of type long.
    * Called by: toString(), add(), subtract(), multiply(), divide(), negate(), pow().
    * Calls: n/a
    *********************************************************************************/
    public long getDenominator(){
        return this.denominator;
    }

    /*****************************<gcd()>***********************************
    * Description: Calculates the Greatest Common Denominator between two long numbers.
    * Parameters: (long a, long b)
    * Pre: Two long numbers must be supplied to the function.
    * Post: The GCD of the two numbers is found.
    * Returns: The GCD of the two numbers, type long.
    * Called by: Fraction(a, b).
    * Calls: n/a
    *********************************************************************************/
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

    /*****************************<toString()>***********************************
    * Description: Prints the fraction class in a custom manner.
    * Parameters: n/a
    * Pre: A fraction must be created to call this function.
    * Post: 
    * Returns: A string describing the fraction will be returned to the user. 
    * Called by: n/a
    * Calls: getNumerator(), getDenominator()
    *********************************************************************************/
    @Override
    public String toString(){
        String output = "";
        long n = this.getNumerator();
        long d = this.getDenominator();

        int nSign = Long.signum(n);
        // int dSign = Long.signum(d);

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


    /*****************************<add()>***********************************
    * Description: Adds two fractions together.
    * Parameters: Fraction inFrac
    * Pre: A fraction must be created to call this function.
    * Post: 
    * Returns: A new fraction, which is the result of the two supplied.
    * Called by: n/a 
    * Calls: getNumerator(), getDenominator()
    *********************************************************************************/
    public Fraction add(Fraction inFrac){
        long newDen = this.getDenominator() * inFrac.getDenominator();
        long nTemp1 = this.getNumerator() * inFrac.getDenominator();
        long nTemp2 = inFrac.getNumerator() * this.getDenominator();
        long newNum = nTemp1 + nTemp2;
        
        return new Fraction(newNum, newDen);
    }


    /*****************************<subtract()>***********************************
    * Description: Subtracts two fractions.
    * Parameters: Fraction inFrac
    * Pre: A fraction must be created to call this function.
    * Post: 
    * Returns: A new fraction, which is the difference of the two supplied.
    * Called by: n/a 
    * Calls: getNumerator(), getDenominator()
    *********************************************************************************/
    public Fraction subtract(Fraction inFrac){
        long newDen = this.getDenominator() * inFrac.getDenominator();
        long nTemp1 = this.getNumerator() * inFrac.getDenominator();
        long nTemp2 = inFrac.getNumerator() * this.getDenominator();
        long newNum = nTemp1 - nTemp2;

        return new Fraction(newNum, newDen);
    }


    /*****************************<multiply()>***********************************
    * Description: Multiplies two fractions.
    * Parameters: Fraction inFrac
    * Pre: A fraction must be created to call this function.
    * Post: 
    * Returns: A new fraction, which is the product of the two supplied.
    * Called by: pow() 
    * Calls: getNumerator(), getDenominator()
    *********************************************************************************/
    public Fraction multiply(Fraction inFrac){
        long newDen = this.getDenominator() * inFrac.getDenominator();
        long newNum = this.getNumerator() * inFrac.getNumerator();
        
        return new Fraction(newNum, newDen);
    }


    /*****************************<divide()>***********************************
    * Description: Divides two fractions.
    * Parameters: Fraction inFrac
    * Pre: A fraction must be created to call this function.
    * Post: 
    * Returns: A new fraction, which is the quotient of the two supplied.
    * Called by: n/a 
    * Calls: getNumerator(), getDenominator()
    *********************************************************************************/
    public Fraction divide(Fraction inFrac){
        long newNum = this.getNumerator() * inFrac.getDenominator();
        long newDen = this.getDenominator() * inFrac.getNumerator();

        return new Fraction(newNum, newDen);
    }
    
    
    /*****************************<negate()>***********************************
    * Description: Reverses the sign of the fraction in question.
    * Parameters: n/a
    * Pre: A fraction must be created to call this function.
    * Post: 
    * Returns: A new fraction, which is the opposite signage of the one supplied.
    * Called by: n/a 
    * Calls: getNumerator(), getDenominator()
    *********************************************************************************/
    public Fraction negate(){
        long newNum = this.getNumerator() * -1;

        return new Fraction(newNum, this.getDenominator());
    }


    /*****************************<pow()>***********************************
    * Description: Sets a fraction to a given exponential power.
    * Parameters: int inPow
    * Pre: A fraction must be created to call this function.
    * Post: 
    * Returns: A new fraction, which is to the power supplied.
    * Called by: n/a 
    * Calls: Fraction(), getNumerator(), getDenominator(), multiply()
    *********************************************************************************/
    public Fraction pow(int inPow){

        // try looping the multiplication function.
        

        Fraction tempFrac = new Fraction(this.getNumerator(), this.getDenominator());


        if(inPow == 0){ // if the power is 0, we just return a fraction of '1' as out answer. 
            tempFrac = new Fraction(1);
            return tempFrac;
        }

        if(inPow < 0){ // set tempFrac to the reciprocal of itself, that way it can be multiplied to find the correct value.
            long newNum = tempFrac.getDenominator();
            long newDen = tempFrac.getNumerator();
            tempFrac = new Fraction(newNum, newDen);
            inPow *= -1; // flips sign of inPow so it functions in the next for loop as intended.
        }

        for(int i = 1; i < inPow; i++){
                tempFrac = tempFrac.multiply(tempFrac);
        }
        
        

        return tempFrac;

    }

    


}