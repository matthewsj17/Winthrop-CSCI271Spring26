public class Fraction {
    
    private long numerator; // the top num of a fraction
    private long denominator; // the bottom num of a fraction

    /*****************************<Fraction(long a, long b)>***********************************
    * Description: Constructions a fraction with specified numerator and denominator.
    * Parameters: long a, long b
    * Pre: long a and long b must be supplied.
    * Post: 
    * Returns: A new object of the fraction class, numerator set to a, denominator set to b. 
    * Called by: add(), subtract(), multiply(), divide(), negate(), pow()
    * Calls: gcd()
    *********************************************************************************/
    public Fraction(long a, long b){
        long gcd = gcd(a, b); // the greatest common denominator between a and b.
        a /= gcd; // a is divided by the gcd to simplify the fraction
        b /= gcd; // b is divided by the gcd to simplify the fraction
        this.numerator = a; // a takes the place of the numerator in the fraction object
        this.denominator = b; // b takes the place of the denominator in the fraction object
    }

    /*****************************<Fraction(long a)>***********************************
    * Description: Constructions a fraction with specified numerator.
    * Parameters: long a
    * Pre: long a must be supplied.
    * Post: 
    * Returns: A new object of the fraction class, numerator set to a, denominator set to 1. 
    * Called by: pow()
    * Calls: n/a 
    *********************************************************************************/
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
        return this.numerator; // returns the numerator value of the fraction to the user. (type long)
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
        return this.denominator; // returns the denominator value of the fraction to the user. (type long)
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
        if (a < 0){  // we need a to be positive, so if its negative we flip the sign
            a = -a;
        }
        while(b != 0){ // we run this loop as long as b isn't zero. 
                long remainder = a % b;
                a = b;
                b = remainder;
        }
        if(a == 0){ // if a ends up being zero, we set it to one since every number has a common factor of 1. 
                a = 1;
        }
        return a; // return the GCD back to the user.
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
        String output = ""; // start with an empty string, to make it easier to modify later.
        long n = this.getNumerator(); // get the numerator value
        long d = this.getDenominator(); // get the denominator value

        int nSign = Long.signum(n); // Long.signum(n) gives us the signage of n. -1 = negative, 0 = 0, 1 = postive
        
        // Cases where not a number is outputted.
        // If the denominator is 0, then a number can not be sent to output.
        if(d == 0){ 
            switch(nSign){ // we determine what string to return based on the signage of the numerator.
                case -1: // if the numerator is negative, then the fraction must be -x/0. This is expressed with -Infinity.
                    output = "-Infinity"; 
                    break;
                case 0: // if the numerator is of value 0, then the fraction must be 0/0. This is expressed with NaN.
                    output = "NaN";
                    break;
                case 1: // if the numerator is positive, then the fraction must be x/0. This is expressed with Infinity.
                    output = "Infinity";
                    break;
            }
        }
        else if(n == 0){ // if the denominator is not 0, but the numerator is, then we simply output zero. ex: 0/5 = 0.
            output = "0";
        }
        // Cases where a number is outputted
        else if(d == 1){ // if the denominator is 1, then the fraction is a whole number. Numerator outputted as whole number.
            output = Long.toString(n);
        }
        else{ //If the input is a normal fraction, then we output it as such.
            output = output + Long.toString(n) + "/" + Long.toString(d);
        }



        return output; // return the string to the user.


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
        long newDen = this.getDenominator() * inFrac.getDenominator(); // set the newDenominator to the product of both fractions' denominators.
        long nTemp1 = this.getNumerator() * inFrac.getDenominator(); // converts this.Numerator to the base of the newDenominator
        long nTemp2 = inFrac.getNumerator() * this.getDenominator(); // converts inFrac.Numerator to the base of the newDenominator
        long newNum = nTemp1 + nTemp2; // add the two numerators to match with the newDenominator.
        
        return new Fraction(newNum, newDen); // create a new fraction with the new values. Return to user.
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
        // 'Keep Change Flip'. 
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
        long newNum = this.getNumerator() * -1; // set the numerator to the opposite power.

        // we don't need to worry about double negatives (ie: numerator and denominator being negative)
        // this is due to the Fraction constructors use of gcd() which removes cases of negative denominators.
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
        
        // create a temporary fraction to be modified
        Fraction tempFrac = new Fraction(this.getNumerator(), this.getDenominator()); 


        if(inPow == 0){ // if the power is 0, we just return a fraction of '1' as out answer. 
            tempFrac = new Fraction(1);
            return tempFrac; // exits the function early.
        }

        if(inPow < 0){ // if the power is negative, we need it to be positive.
            // set tempFrac to the reciprocal of itself, that way it can be multiplied to find the correct value.
            long newNum = tempFrac.getDenominator();
            long newDen = tempFrac.getNumerator();
            tempFrac = new Fraction(newNum, newDen); // reassign the new values to tempFrac
            inPow *= -1; // flips sign of inPow so it functions in the next for loop as intended.
        }

        for(int i = 1; i < inPow; i++){ // we multiply tempFrac by itself until i equals inPow.
                tempFrac = tempFrac.multiply(tempFrac); // self-multiplication
        }
    

        return tempFrac; // return the tempFrac to user. This is the new fraction!

    }

    


}