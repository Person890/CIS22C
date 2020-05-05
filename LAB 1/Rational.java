/*
 * Author: 
 * @Natalie Stepankevycova
 * teammate: Victor Diniz 
 * 
 * CIS22C - Data Structures
 * 
 * 
 * This program must be able to do following: 
 * Know the value of the denominator.
 * Know the value of the numerator.
 * Be able to compute the negation of a rational number.
 * Be able to compute the reciprocal of a rational number.
 * Be able to compare two rational numbers for equality.
 * Be able to compute the sum of two rational numbers.
 * Be able to compute the difference of two rational numbers.
 * Be able to compute the result of multiplying two rational numbers.
 * Be able to compute the result of dividing two rational numbers.
 * Be able to compute a printable representation of the rational number.*/

public class Rational {

	// private data
	private int num = 1;

	private int den = 1;

	// default constructor
	public Rational() {

	}

	/*
	 * Rational constructor Pre-condition: none. Post-condition: The rational number
	 * 1 has been constructed. Test cases: none.
	 */
	public Rational(int n, int d) {

		if (d < 0) {
			d = 0 - d;
			this.den = d;
			n = 0 - n;
			this.num = n;

		} else if (d == 0) {

			throw new ArithmeticException("Denominator is zero");

		} else {

			this.num = n;
			this.den = d;
		}
		normalize();

	}

	/*
	 * Pre-condition: The rational n/d is in a valid state. Post-condition: The
	 * value n is returned.
	 */
	public int getNumerator() {
		// CHANGE THE RETURN TO SOMETHING APPROPRIATE
		return num;
	}

	// return the value of denominator
	public int getDenominator() {
		return den;
	}

	/*
	 * Negate the rational number n Pre-condition: The rational n/d is in a valid
	 * state. Post-condition: The rational number –n/d has been returned.
	 */
	public Rational negate() {
		int number = 0 - this.num;
		int denm = this.den;

		Rational negatedRational = new Rational(number, denm);

		return negatedRational;
	}

	/*
	 * Invert n and d in the rational number Pre-condition: The rational n/d is in a
	 * valid state and denominator isn't zero Post-condition: The rational number
	 * –n/d has been returned.
	 */
	public Rational reciprocal() {
		int number = this.den;
		int den = this.num;
		if (den == 0) {
			throw new ArithmeticException("Cannot be 0");
		}

		Rational invertedRational = new Rational(number, den);

		return invertedRational;
	}

	/*
	 * Check if passed object is equal to the rational number Pre-condition: The
	 * passed value isn't null and is a class object Post-condition: The rational
	 * number –n/d has been returned.
	 */
	public boolean equals(Rational x) {

		if (x == null)

			return false;

		if (x.getClass() != this.getClass())

			return false;

		Rational b = (Rational) x;

		return compareTo(b) == 0;
	}

	public int compareTo(Rational y) {

		Rational a = this;

		int lhs = a.num * y.den;

		int rhs = a.den * y.num;

		if (lhs < rhs)

			return -1;

		if (lhs > rhs)
			return +1;

		return 0;
	}

	/*
	 * Add two rational numbers Pre-condition: none Post-condition: Return the sum
	 * of the two numbers
	 */
	public Rational add(Rational addNum) {
		int number = (this.num * addNum.den) + (this.den * addNum.num);

		int denm = this.den * addNum.den;

		Rational rational = new Rational(number, denm);

		return rational;
	}

	/*
	 * Subtract passed number 'other' from this rational number Pre-condition: none
	 * Post-condition: The subtracted number is returned
	 */
	public Rational subtract(Rational other) {

		int number = (this.num * other.den) - (this.den * other.num);

		int denm = this.den * other.den;

		Rational rational = new Rational(number, denm);

		return rational;

	}

	/*
	 * Multiply 'other' rational number with this rational number Pre-condition:
	 * none Post-condition: The multiplied number has been returned.
	 */
	public Rational multiply(Rational other) {

		int number = this.num * other.num;

		int denm = this.den * other.den;

		Rational rational = new Rational(number, denm);

		return rational;
	}

	/*
	 * Divide this rational number by 'other' rational number Pre-condition: The
	 * denominator isn't zero Post-condition: The rational number –n/d has been
	 * returned.
	 */
	public Rational divide(Rational other) {

		int number = this.num * other.den;

		int denm = this.den * other.num;

		if (denm == 0)

			throw new ArithmeticException("Cannot be 0");

		Rational newRational = new Rational(number, denm);

		return newRational;
	}

	/*
	 * Puts numerator and denominator to a form where they share no common factors
	 * Pre-condition: The numerator is larger than zero Post-condition: No return
	 * value
	 */
	private void normalize() {
		if (num < 0) {

			int absolute = 0 - num;

			int greatestCommDen = gcd(absolute, this.den);

			int number = this.num / greatestCommDen;

			int denm = this.den / greatestCommDen;

			this.num = number;

			this.den = denm;

		} else {

			int greatestCommDivivor = gcd(this.num, this.den);

			int number = this.num / greatestCommDivivor;

			int denm = this.den / greatestCommDivivor;

			this.num = number;

			this.den = denm;
		}
	}

	/*
	 * Find greatest common denominator Pre-condition: none Post-condition: Return
	 * greatest common denominator
	 */
	private int gcd(int a, int b) {

		int result = 0;

		if (a < b)

			result = gcd(b, a);

		else if (b == 0)

			result = a;

		else {

			int remainder = a % b;

			result = gcd(b, remainder);

		}
		return result;
	}
}
