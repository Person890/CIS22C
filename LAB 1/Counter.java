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

public class Counter {
	// private data
	private int max;

	private int min;

	private int value;

	private boolean overflow;

	// default constructor
	public Counter() {

		overflow = false;
	}

	/*
	 * The alternate constructor for objects of class Counter. Parameters: minimum
	 * maximum value
	 */
	public Counter(int min, int max) {

		if (min < max) {

			this.min = min;

			this.max = max;

			overflow = false;
		} else {

			throw new ExceptionInInitializerError("Incorrect max or min value");
		}
		value = min;
	}

	/*
	 * Determine if two counters are in the same state Pre-condition: otherObject is
	 * an instance of object Counter Post-condition: The boolean true if values
	 * equal is returned, false otherwise Test cases: none.
	 */
	public boolean equals(Object otherObject) {

		boolean result = true;

		if (otherObject instanceof Counter) {

			if (((Counter) otherObject).min == this.min && ((Counter) otherObject).max == this.max
					&& ((Counter) otherObject).value == this.value && ((Counter) otherObject).overflow == overflow) {

				return result;
			}

			else

				result = false;

			return false;

		}
		return result;
	}

	/*
	 * Increase counter by one Pre-condition: none Post-condition: none Test cases:
	 * none
	 */
	public void increase() {

		if (value < max) {

			value++;

			overflow = false;

		} else {

			value = min;

			overflow = true;
		}
	}

	/*
	 * Decrease counter by one Pre-condition: none Post-condition: none Test cases:
	 * none
	 */
	public void decrease() {

		if (value > min) {

			value--;

			overflow = false;
		}

		else {

			value = max;

			overflow = true;
		}
	}

	/*
	 * Get value of the counter Pre-condition: none Post-condition: return value
	 * Test cases: none
	 */
	public int value() {

		return value;

	}

	/*
	 * Method to determine if the stack overflowed Pre-condition: none
	 * Post-condition: Return overflow Test cases: none
	 */
	public boolean rolledOver() {

		return overflow;
	}

	/*
	 * This method overrides the toString method to provide a more info about the
	 * counter Pre-condition: none Post-condition: return string Test cases: none
	 */
	public String toString() {
		// CHANGE THE RETURN TO A DESCRIPTION OF THE COUNTER
		return "This counter which will increase value or decrease value when user "
				+ "doing different operation, and it'will rooledover while the value out of range";
	}

}
