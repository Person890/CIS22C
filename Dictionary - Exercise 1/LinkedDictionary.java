import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * CIS22C - Data Structures
 * 
 * Spring 2020
 * 
 * June 1, 2020
 * 
 * @author Natalie Stepankevycova
 * 
 * 
 * This program implements the ADT Dictionary
 * 
 * */

public class LinkedDictionary<K, V> implements DictionaryInterface<K, V> {

	private Node firstNode; // Reference to first node of chain
	
	private int numberOfEntries;

	
	public LinkedDictionary() {
	
		// initializeDataFields();
		
		this.firstNode = null;
		
		this.numberOfEntries = 0;
	} // end default constructor

	
	public V add(K key, V value) {
	
		// Check if dictionary is empty
		
		if (isEmpty())
		
			this.firstNode = new Node(key, value);
		
		else {
			// Get first node
			Node node = this.firstNode;

			// reference to previous node
			Node prev = null;

			// Traverse through the dictionary to find key
			while (node != null) {
				// Check if key at node is same as the given key
				if (node.key.equals(key)) {
					// Get value at node
					V val = node.value;

					// Set value at node as the given value
					node.value = value;

					// Return val
					return val;
				}

				// Set prev to node
				prev = node;

				// Move to next node
				node = node.next;
			}

			// If key is not found, add it as a new node at the end
			prev.next = new Node(key, value);
		}

		// Increment value of numberOfEntries by 1
		this.numberOfEntries += 1;

		// Default return
		return null;
	}

	/* This method removes entry from dictionary
	 * 
	 * @param object which is to be removed
	 * 
	 * @return key of removed object or null*/
	public V remove(K key) {
		
		// Get firstNode
		Node node = this.firstNode;

		// Previous node
		Node prev = null;

		// Traverse through 
		while (node != null) {
			
			// check if node and key match
			if (node.key.equals(key)) {
				
				V value = node.value;

				// If node is the firstNode
				if (node == this.firstNode)
					
					// Set the next node as firstNode
					this.firstNode = node.next;
				else
					// Set prev.next as node.next
					prev.next = node.next;
				
				this.numberOfEntries -= 1;

				// Return value
				return value;
			}

			// Set prev as node
			prev = node;

			// Move to next node
			node = node.next;
		}

		// Default return
		return null;
	}

	/*this method gets value from dictionary
	 * 
	 * @param key corresponding to the value that is to be retrieved
	 * 
	 * @return value*/
	public V getValue(K key) {
		// Get firstNode
		Node node = this.firstNode;

		// Traverse through the dictionary to find key
		while (node != null) {
			// Check if key at node is same as the given key
			if (node.key.equals(key))
				return node.value;

			// Move to next node
			node = node.next;
		}

		// Default return
		return null;
	}

	
	/* This method checks if dictionary contains specific entry
	 * 
	 * @param key referring to an entry
	 * 
	 * @return a boolean indicating if value was found*/
	public boolean contains(K key) {
		
		//  firstNode
		Node node = this.firstNode;

		// Traverse through the dictionary to find key
		while (node != null) {
			// Check if key at node is same as the given key
			if (node.key.equals(key))
				return true;

			// Move to next node
			node = node.next;
		}

		// Default return
		return false;
	}


	/* This is Iterator - traverses search keys through the dictionary*/
	public Iterator<K> getKeyIterator() {
		// Return KeyIterator instance
		return new KeyIterator();
	}


	/* This is Iterator - traverses values through the dictionary*/
	public Iterator<V> getValueIterator() {
		// Return ValueIterator instance
		return new ValueIterator();
	}

	
	//check if dictionary is empty
	public boolean isEmpty() {
		// Return whether firstNode is null
		return (this.firstNode == null);
	}


	
	// get size of dictionary
	public int getSize() {
		// Return numberOfEntries
		return this.numberOfEntries;
	}

	/* Remove all entries from the dictionary. */

	public void clear() {
		// Set firstNode to null
		this.firstNode = null;

		// Set to zero numberOfEntries
		this.numberOfEntries = 0;
	}

	
	
	private class KeyIterator implements Iterator<K> {
		private Node nextNode;

		private KeyIterator() {
			nextNode = firstNode;
		} // end default constructor

		public boolean hasNext() {
			return nextNode != null;
		} // end hasNext

		public K next() {
			K result;

			if (hasNext()) {
				result = nextNode.getKey();
				nextNode = nextNode.getNextNode();
			} else {
				throw new NoSuchElementException();
			} // end if

			return result;
		} // end next

		public void remove() {
			throw new UnsupportedOperationException();
		} // end remove
	} // end KeyIterator

	private class ValueIterator implements Iterator<V> {
		private Node nextNode;

		private ValueIterator() {
			nextNode = firstNode;
		} // end default constructor

		public boolean hasNext() {
			return nextNode != null;
		} // end hasNext

		public V next() {
			V result;

			if (hasNext()) {
				result = nextNode.getValue();
				nextNode = nextNode.getNextNode();
			} else {
				throw new NoSuchElementException();
			} // end if

			return result;
		} // end next

		public void remove() {
			throw new java.lang.UnsupportedOperationException();
		} // end remove
	} // end getValueIterator

	private class Node {
		private K key;
		private V value;
		private Node next;

		private Node(K searchKey, V dataValue) {
			key = searchKey;
			value = dataValue;
			next = null;
		} // end constructor

		private Node(K searchKey, V dataValue, Node nextNode) {
			key = searchKey;
			value = dataValue;
			next = nextNode;
		} // end constructor

		private K getKey() {
			return key;
		} // end getKey

		private V getValue() {
			return value;
		} // end getValue

		private void setValue(V newValue) {
			value = newValue;
		} // end setValue

		private Node getNextNode() {
			return next;
		} // end getNextNode

		private void setNextNode(Node nextNode) {
			next = nextNode;
		} // end setNextNode
	} // end Node

} // end LinkedDictionary

/*
 * ========================SAMPLE OUTPUT========================
 * 
 * Create a dictionary:
 * 
 * Initial dictionary should be empty; isEmpty() returns true
 * 
 * 
 * Testing add():
 * 
 * 11 (should be 11) items in dictionary, as follows:
 * 
 * Dirk : 555-1234 Abel : 555-5678 Miguel : 555-9012 Tabatha : 555-3456 Tom :
 * 555-5555 Sam : 555-7890 Reiss : 555-2345 Bette : 555-7891 Carole : 555-7892
 * Derek : 555-7893 Nancy : 555-7894
 * 
 * 
 * 
 * Testing getValue():
 * 
 * 
 * Abel: 555-5678 should be 555-5678
 * 
 * Sam: 555-7890 should be 555-7890
 * 
 * Tom: 555-5555 should be 555-5555
 * 
 * Reiss: 555-2345 should be 555-2345
 * 
 * Miguel: 555-9012 should be 555-9012
 * 
 * 
 * 
 * Testing contains():
 * 
 * 
 * Sam is in dictionary - OK
 * 
 * Abel is in dictionary - OK
 * 
 * Miguel is in dictionary - OK
 * 
 * Tom is in dictionary - OK
 * 
 * Bo is not in dictionary - OK
 * 
 * 
 * 
 * Removing first item Nancy - Nancy's number is 555-7894 should be 555-7894
 * Replacing phone number of Reiss and Miguel:
 * 
 * Reiss's old number 555-2345 is replaced by 555-5432 Miguel's old number
 * 555-9012 is replaced by 555-2109
 * 
 * 10 (should be 10) items in dictionary, as follows:
 * 
 * Dirk : 555-1234 Abel : 555-5678 Miguel : 555-2109 Tabatha : 555-3456 Tom :
 * 555-5555 Sam : 555-7890 Reiss : 555-5432 Bette : 555-7891 Carole : 555-7892
 * Derek : 555-7893
 * 
 * 
 * 
 * Removing interior item Reiss:
 * 
 * 
 * 9 (should be 9) items in dictionary, as follows:
 * 
 * Dirk : 555-1234 Abel : 555-5678 Miguel : 555-2109 Tabatha : 555-3456 Tom :
 * 555-5555 Sam : 555-7890 Bette : 555-7891 Carole : 555-7892 Derek : 555-7893
 * 
 * 
 * 
 * Removing last item Dirk:
 * 
 * 
 * 8 (should be 8) items in dictionary, as follows:
 * 
 * Abel : 555-5678 Miguel : 555-2109 Tabatha : 555-3456 Tom : 555-5555 Sam :
 * 555-7890 Bette : 555-7891 Carole : 555-7892 Derek : 555-7893
 * 
 * 
 * Removing Bo (not in dictionary):
 * 
 * Bo was not found in the dictionary.
 * 
 * 
 * 8 (should be 8) items in dictionary, as follows:
 * 
 * Abel : 555-5678 Miguel : 555-2109 Tabatha : 555-3456 Tom : 555-5555 Sam :
 * 555-7890 Bette : 555-7891 Carole : 555-7892 Derek : 555-7893
 * 
 * 
 * 
 * Testing clear():
 * 
 * Dictionary should be empty; isEmpty() returns true
 * 
 * 
 * Done.
 */
