/*
 * Author
 * @Natalie Stepankevycova
 * 
 * CIS 22C - Data Structures
 * 
 * 
 * This program is testing the methods of a bag
 * The program performs the following methods:
 * 		adds numbers to list
 * 		checks if the list is empty 
 * 		outputs number of nodes in linked list
 * 		clears the linked list
 * 		replaces data at different positions
 * 		removes nodes
 * 		checks if there is given data at the linked list
 * 		gets position of an entry
 * */


public final class LinkedBag<T> implements BagInterface<T> {
	private Node firstNode; // create first node
	private int numberOfEntries;

	// constructor
	public LinkedBag() {
		firstNode = null;
		numberOfEntries = 0;
	}

	// create Nodes
	private class Node {
		private T data; // Entry in bag
		private Node next; // Link to next Node

		public Node(T dataPortion) {
			this(dataPortion, null);
		}

		public Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}
	}

	// this method adds an entry
	public boolean add(T newEntry) {

		// add to the beginning
		Node newNode = new Node(newEntry);

		newNode.next = firstNode;

		firstNode = newNode; // make the new node the first

		numberOfEntries++;

		return true;
	}

	// getter
	public boolean isEmpty() {

		return numberOfEntries == 0;
	}

	// getter
	public int getCapacity() {

		return Integer.MAX_VALUE;
	}

	// getter
	public int getCurrentSize() {

		return numberOfEntries;
	}

	// go to element
	public T[] toArray() {

		@SuppressWarnings("unchecked")

		T[] result = (T[]) new Object[numberOfEntries];

		int index = 0;

		Node currentNode = firstNode;

		while ((index < numberOfEntries) && (currentNode != null)) {

			result[index] = currentNode.data;

			currentNode = currentNode.next; // traverse

			index++;
		}
		return result;
	}

	// see if the bag contains an entry
	public boolean contains(T anEntry) {

		boolean isFound = false;

		Node currentNode = firstNode;

		while (!isFound && (currentNode != null)) {

			if (anEntry.equals(currentNode.data)) {

				isFound = true;

			} else {

				currentNode = currentNode.next;
			}
		}
		return isFound;
	}

	// outputs how many times does the element occur
	public int getFrequencyOf(T anEntry) {

		int occurence = 0;

		int counter = 0;

		Node currentNode = firstNode;

		while ((counter < numberOfEntries) && (currentNode != null)) {

			if (anEntry.equals(currentNode.data)) {

				occurence++;
			}

			counter++;

			currentNode = currentNode.next;
		}
		return occurence;
	}

	// give reference to element containing an entry or output 0
	private Node getReferenceTo(T anEntry) {

		boolean isFound = false;

		Node currentNode = firstNode;

		while (!isFound && (currentNode != null)) {

			if (anEntry.equals(currentNode.data)) {

				isFound = true;

			} else {

				currentNode = currentNode.next;

			}

		}
		return currentNode;
	}

	// delete all elements
	public void clear() {

		while (!isEmpty()) {

			remove();

		}
	}

	// remove last element
	public T remove() {

		T result = null;

		if (firstNode != null) {

			result = firstNode.data;

			firstNode = firstNode.next;

			numberOfEntries--;
		}
		return result;
	}

	// remove specific entry
	public boolean remove(T anEntry) {

		boolean result = false;

		Node toRemove = getReferenceTo(anEntry);

		if (toRemove != null) {

			// store first element's data in element to be removed
			toRemove.data = firstNode.data;

			firstNode = firstNode.next;

			numberOfEntries--;

			result = true;
		}

		return result;
	}
}


/*SAMPLE OUTPUT
 * 
 * Testing add to end: Add 15, 25, 35, 45


List should contain
15 25 35 45 
The list contains 4 string(s), as follows:
15 25 35 45 

Is List empty? false
Add more entries to end: Add 55, 65, 75, 85, 95


Is List empty? false
-------------------------



List should contain 15 25 35 45 55 65 75 85 95
The list contains 9 string(s), as follows:
15 25 35 45 55 65 75 85 95 

------------------------

Testing clear() 
List should be empty: 
Is list empty? true
-------------------------

Create a new list.

Add 15 at position 1:
Add 25 at position 2:
Add 35 at position 3:


List should contain
15 25 35 
The list contains 3 string(s), as follows:
15 25 35 
Is List empty? false
Add 19 at position 1:
Add 39 at position 3:
Add 29 at position 2:
Add 55 at position 7:
Add 65 at position 8:


List should contain
19 29 15 39 25 35 55 65
The list contains 8 string(s), as follows:
19 29 15 39 25 35 55 65 
Is List empty? false

-------------------------

Testing remove() 
Removing 15 at position 3: returns 15
Removing 19 at position 1: returns 19
Removing 65 at position 6: returns 65


List should contain
29 39 25 35 55
The list contains 5 string(s), as follows:
29 39 25 35 55 

-------------------------

Testing replace() 
Replace 29 at position 1 with 92 : returns 29
Replace 39 at position 2 with 93 : returns 39
Replace 25 at position 3 with 52 : returns 25
Replace 35 at position 4 with 53 : returns 35
Replace 55 at position 5 with 50 : returns 55


List should contain
92 93 52 53 50
The list contains 5 string(s), as follows:
92 93 52 53 50 
Is List empty? false

-------------------------

Testing getEntry() 

The list contains 5 entries, as follows:
92 is entry 1
93 is entry 2
52 is entry 3
53 is entry 4
50 is entry 5


-------------------------

Testing contains() [results should be TRUE]
List contains 92: true
List contains 52: true
List contains 53: true
List contains 50: true


Testing contains() [results should be FALSE]
List contains 91 returns : false
List contains 55 returns : false
List contains 4  returns : false
List contains 12 returns : false


Done.
*/
