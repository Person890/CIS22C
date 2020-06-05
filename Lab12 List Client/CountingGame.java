import java.util.*;

/**
 * CountingGame is a program that will simulate a children's counting game used
 * to select someone.
 * 
 * CIS 22C - Data Structures
 * 
 * May 25, 2020
 * 
 * @author Charles Hoot, Natalie Stepankevycova
 * @version 4.0
 */

public class CountingGame {

	public static void main(String args[]) {

		ListInterface<Integer> players = null;

		ListInterface<String> rhyme = null;

		int position = 1; // we're starting the game with first player

		int max;

// taking number of players from user 
		System.out.println("Please enter the number of players.");

		max = getInt("It should be an integer value greater than or equal to 2.");

		System.out.println("Constructing list of players");

// list of players
		players = new AList<Integer>(max);

		// adding players to the list
		for (int i = 1; i <= max; i++) {
			players.add(i);
		}

		System.out.println("The players list is : " + players);

//getting rhyme from the user
		rhyme = getRhyme();

//run the game until one player wins
		while (players.getLength() > 1) {

			position = doRhyme(players, rhyme, position);
		}

//printing the winner
		System.out.println("The winner is " + players.getEntry(1));
	}

	/**
	 * Get an integer value from user
	 *
	 * @return An integer
	 */
	private static int getInt(String prompt) {
		
		Scanner in;
		
		int result = 10; // default
		
		try {
			
			in = new Scanner(System.in);
			
			System.out.println(prompt);
			
			result = in.nextInt();

			//handling exceptions
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
	

	/**
	 * This method gets rhyme from user
	 *
	 * @retur: list of word in a rhyme
	 */
	private static ListInterface<String> getRhyme() {
		
		Scanner in;
		
		String inputRhyme = "";
		
		ListInterface<String> rhyme = new AList<String>();

		try {
			
			in = new Scanner(System.in);

			System.out.println("Please enter a rhyme:");
			
			inputRhyme = in.nextLine().trim();

			Scanner wordsInRhyme = new Scanner(inputRhyme);
			
			//if we're not in the end, keep going
			while (wordsInRhyme.hasNext()) {
				
				rhyme.add(wordsInRhyme.next());
			}
			wordsInRhyme.close();

		} catch (Exception e) {
			System.out.println("There was an error with System.in");
			System.out.println(e.getMessage());
			System.out.println("Will use a rhyme of size one");
		}

// if user doesn't enter any words in the rhyme, default word is "default"
		
		if (rhyme.getLength() == 0)
			
			rhyme.add("Default");

		return (ListInterface<String>) rhyme;

	}



	
	
	/**
	 * Do the rhyme with the players in the list and remove the selected player.
	 *
	 * @param: a list of players, a list of of words of the rhyme, a position in
	 *           which the rhyme starts
	 * 
	 * @return the index of the player who got eliminated
	 */
	public static int doRhyme(ListInterface<Integer> players, ListInterface<String> rhyme, int start) {

		int i = 0, j = start;

		for (i = 1; i <= rhyme.getLength(); i++) {
			
			if (j <= players.getLength()) {
				
				System.out.println("Player " + players.getEntry(j) + ":" + rhyme.getEntry(i));
				
				j++;
			}
//if we've done through all the players, we'll start all over
			if (j > players.getLength()) {
				
				j = 1;
			}
		}
		
		j--;
//if j is zero, we'll go to last player
		if (j < 1)
			
			j = players.getLength();

		
		System.out.println("Removing player " + players.getEntry(j) + "\n");
		players.remove(j);

//next round will start either at 1 or where we finished
		if (j == (players.getLength() + 1)) {
			
			return 1;
		}
		return j;

	}
}



/*=====================SAMPLE OUTPUT======================
Please enter the number of players.
It should be an integer value greater than or equal to 2.
7
Constructing list of players
The players list is : { <1> <2> <3> <4> <5> <6> <7> }
Please enter a rhyme:

Player 1:Default
Removing player 1

Player 2:Default
Removing player 2

Player 3:Default
Removing player 3

Player 4:Default
Removing player 4

Player 5:Default
Removing player 5

Player 6:Default
Removing player 6

The winner is 7

==========================================================

Please enter the number of players.
It should be an integer value greater than or equal to 2.
3
Constructing list of players
The players list is : { <1> <2> <3> }
Please enter a rhyme:
A B C
Player 1:A
Player 2:B
Player 3:C
Removing player 3

Player 1:A
Player 2:B
Player 1:C
Removing player 1

The winner is 2

 */
