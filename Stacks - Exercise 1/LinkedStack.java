/*
 * Author:
 * @Natalie Stepankevycova
 * 
 * 
 * This program is part of an exercise of a stack
 * This program:
 * 		creates a stack
 * 		checks if stack is empty
 * 		adds data to stack
 * 		tests peek, push and pop methods
 * 		tests clear method */


public class LinkedStack<T> implements StackInterface<T> {

	private Node firstNode; // References the first node in the chain

	private int numOfEntries;


	// constructor
	public LinkedStack() {

		firstNode = null;

		numOfEntries = 0;

	} // end default constructor

	// push method adds data to stack
	public void push(T newEntry) {

		firstNode = new Node(newEntry, firstNode);

		numOfEntries++;

		return;

	} // end push

	
	// returns first node, null if stack is empty
	public T peek() {

		if (isEmpty())

			return null;

		else

			return firstNode.getData();

	} // end peek

	
	// pop removes top most node from the stack
	public T pop() {

		T top = peek();

		if (firstNode != null) {

			firstNode = firstNode.getNextNode();

			numOfEntries--;

		}

		return top;

	} // end pop

	
	// check if the stack is empty
	public boolean isEmpty() {

		if (firstNode == null) {

			return true;

		} else

			return false;

	} // end isEmpty

	public int size() {

		return numOfEntries;

	}

	// create node 
	private class Node {

		private T data; // Entry in stack

		private Node next; // Link to next node

		private Node(T dataPortion) {

			this(dataPortion, null);

		} // end constructor

		private Node(T dataPortion, Node linkPortion) {

			data = dataPortion;

			next = linkPortion;

		} // end constructor

		private T getData() {

			return data;

		} // end getData


		private void setData(T newData) {

			data = newData;

		} // end setData

		private Node getNextNode() {

			return next;

		} // end getNextNode

		private void setNextNode(Node nextNode) {

			next = nextNode;

		} // end setNextNode

	} // end Node

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

} // end LinkedStack



/*SAMPLE OUTPUT
 * 
 * 
 * Create a stack: 
isEmpty() returns true

Add to stack to get
Joe Jane Jill Jess Jim

isEmpty() returns false

Testing peek and pop:

Joe is at the top of the stack.
Joe is removed from the stack.

Jane is at the top of the stack.
Jane is removed from the stack.

Jill is at the top of the stack.
Jill is removed from the stack.

Jess is at the top of the stack.
Jess is removed from the stack.

Jim is at the top of the stack.
Jim is removed from the stack.

The stack should be empty: isEmpty() returns true

Add to stack to get
Jim Jess Joe


Testing clear:
The stack should be empty: 

isEmpty() returns false

 myStack.peek() returns 
Jim

 myStack.pop()  returns 
Jim


Done.*/

