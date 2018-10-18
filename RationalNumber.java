public class RationalNumber extends RealNumber {
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super(0);//this value is ignored!
    if (deno == 0) {
      numerator = 0;
      denominator = 1;
    }
    else {
      denominator = deno;
      numerator = nume;
    }
    reduce();
  }

  public double getValue(){
    return (double)numerator / (double)denominator;//???
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    return new RationalNumber(denominator, numerator);
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    if (this.getNumerator() == other.getNumerator() && this.getDenominator() == other.getDenominator()) {
      return true;
    }
    return false;
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    return "" + numerator + "/" + denominator;
  }



  /**Calculate the GCD of two integers.
  *@param a the first integer
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    int big = Math.max(Math.abs(a), Math.abs(b));
    int small = Math.min(Math.abs(a), Math.abs(b));
    int remainder;
    while (small != 0) {
      remainder = big % small;
      big = small;
      small = remainder;
    }
    return big;
  }



  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    int divisor = gcd(numerator, denominator);
    numerator = numerator / divisor;
    denominator = denominator / divisor;
    if (denominator < 0) {
      numerator *= -1;
      denominator *= -1;
    }
  }



  /******************Operations!!!!****************/


  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    int num = this.numerator * other.numerator;
    int den = this.denominator * other.denominator;
    return new RationalNumber(num, den);
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    int num = this.numerator * other.denominator;
    int den = this.denominator * other.numerator;
    return new RationalNumber(num, den);
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    int num = ((this.numerator * other.denominator) + (other.numerator * this.denominator));
    int den = this.denominator * other.denominator;
    return new RationalNumber(num, den);
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    int num = ((this.numerator * other.denominator) - (other.numerator * this.denominator));
    int den = this.denominator * other.denominator;
    return new RationalNumber(num, den);
  }
}
