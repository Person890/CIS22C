import java.util.*;

/*
 * CIS 22C - Data Structures 
 * 
 * May 27, 2020
 * 
 * Author: @Natalie Stepankevycova
 * 
 * 
 * LongestCommonSubsequence is a program that uses bag ADT: 
 * 		prompts user to enter a two sequences of letters as strings
 * 		finds the string that is the longest common subsequence (substring) 
 * 		outputs the longest subsequence if there is any found
 *  */

public class LongestCommonSubsequence {

	@SuppressWarnings("resource")
	public static void main(String args[]) {

		Scanner in;
		in = new Scanner(System.in);
		
		System.out.println("This program finds the longest common subsequence of two words.");
		
		System.out.println("Please enter the first string: ");
		
		String first = in.next();
		
		System.out.println("Please enter the second string: ");
		
		String second = in.next();
		
		
		@SuppressWarnings("unused")
		//declaring common subsequence
		String commonSub = new String("");
		
		//flag
		boolean subsequence = isSubsequence(first, second);

		if (subsequence) // if is subsequence it will print it out
			System.out.println("Found " + first + " for the longest common subsequence.");
	}

	/**
	 * This method will check if there is common subsequence in the two strings
	 *
	 * @param string number one
	 * @param string number two
	 * 
	 * @return a boolean that says if there is common subsequence
	 * 
	 */
	public static boolean isSubsequence(String one, String two) {
										
		int x = one.length();
		int y = two.length();
		
		int j = 0;
		
		// the loop is as long as the strings
		for (int i = 0; i < y && j < x; i++) {
			
			// check if character at the index matches
			if (one.charAt(j) == two.charAt(i))
				
				j++;
		}
		
		// returns true if we reached the end
		return j == x;
	}
}


/*=================SAMPLE OUTPUT======================
 * 
 * This program determines the longest string that is a subsequence of two input string.
Please enter the first string:
AA
Please enter the second string:
ABA
Found AA for the longest common subsequence.

*/
