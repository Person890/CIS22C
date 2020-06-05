import java.util.*;

/**
 * Primes is a program that will compute prime numbers using the sieve of Eratosthenes.
 * 
 * CIS 22C - Data Structures 
 * 
 * May 25, 2020
 * 
 * 
 * @author Natalie Stepankevycova
  * @version 4.0
 */

public class Primes {

	public static void main(String args[]) {

		int max;

		System.out.println("Please enter the maximum value to test for primality");
		max = getInt(" It should be an integer value greater than or equal to 2.");

// creating a list of candidates
		
		ListInterface<Integer> candidates = new AList<Integer>();
		
		// starting at smallest integer which is 2
		for (int i = 2; i <= max; i++) {
			
			candidates.add(i);
		}

//printing the candidates
		System.out.println(candidates);

// creating a list of primes and composites
		ListInterface<Integer> primes = new AList<Integer>();
		
		ListInterface<Integer> composites = new AList<Integer>();

		
//Remove the first value from the primes list and remember it in a variable
		while (!candidates.isEmpty()) {
			
			int prime = candidates.getEntry(1);
			
			candidates.remove(1);
			
			getComposites(candidates, composites, prime);

//Add it to the primes list.
			primes.add(prime);

		}

//Print out all three lists.
		System.out.println("Candidates:" + candidates);
		System.out.println("Primes:" + primes);
		System.out.println("Composites:" + composites);

	}

	/**
	 * This method removes the composite values from a list and puts them in composites list
	 *
	 * @param: List of integers that are candidates, A list of integers that are composites, a prime
	 * 
	 * @return: none
	 */
	public static void getComposites(ListInterface<Integer> candidates, ListInterface<Integer> composites,
			Integer prime) {

		// this loop will check if candidate is multiple of prime
		for (int i = 1; i <= candidates.getLength(); i++) {
			
			int y = candidates.getEntry(i);

			if (y % prime == 0) {
				
				// if it's a multiple, we'll remove it from candidates list and add to composites
				composites.add(y);
				
				candidates.remove(i);
			}
		}
	}

	/**
	 * Get input from a user
	 *
	 * @return:	An integer
	 */
	private static int getInt(String rangePrompt) {
		
		Scanner in;
		
		int result = 10; // default
		
		try {
			
			in = new Scanner(System.in);
			
			System.out.println(rangePrompt);
			
			result = in.nextInt();

// catch exeptions
		} catch (NumberFormatException e) {
			System.out.println("Could not convert input to an integer");
			System.out.println(e.getMessage());
			System.out.println("Will use 10 as the default value");
			
		} catch (Exception e) {
			System.out.println("There was an error with System.in");
			System.out.println(e.getMessage());
			System.out.println("Will use 10 as the default value");
		}
		return result;

	}

}




/*===================SAMPLE OUTPUT===================
 * 
 * 
 * Please enter the maximum value to test for primality
 It should be an integer value greater than or equal to 2.
7
{ <2> <3> <4> <5> <6> <7> }
Candidates:{ }
Primes:{ <2> <3> <5> <7> }
Composites:{ <4> <6> }
*/