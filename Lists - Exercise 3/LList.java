/*
 * Author
 * @Natalie Stepankevycova
 * 
 * CIS 22C - Data Structures
 * 
 * 
 * This program is testing the methods of linked list. 
 * The program performs the following methods:
 * 		adds numbers to linked list
 * 		checks if the list is empty 
 * 		outputs number of nodes in linked list
 * 		clears the linked list
 * 		replaces data at different positions
 * 		removes nodes
 * 		checks if there is given data at the linked list
 * 		gets position of an entry
 * */






public class LList<T> implements ListInterface<T> {

   private Node firstNode; // Reference to first node of chain

   private int numberOfEntries;

   // default constructor
   public LList() {

       initializeDataFields();
   }

   
   private void initializeDataFields() {

       firstNode = null;

       numberOfEntries = 0;

   } // end initializeDataFields

   //  Returns a reference to the node at a given position.
   
   // Precondition: The chain is not empty;
    
   // 1 <= givenPosition <= numberOfEntries. 

   private Node getNodeAt(int givenPosition) {

	   // check if given position is in the list
       assert !isEmpty() && (1 <= givenPosition)

               && (givenPosition <= numberOfEntries);

       Node currentNode = firstNode;

       // Traverse the chain to locate the desired node

       // (skipped if givenPosition is 1)

       for (int counter = 1; counter < givenPosition; counter++)

           currentNode = currentNode.getNextNode();

       assert currentNode != null;

       return currentNode;

   } // end getNodeAt
   
   

   private class Node {

       private T data; // new entry

       private Node next; // reference to next node

       // constructor
       private Node(T dataAtNode) {

           data = dataAtNode;

           next = null;

       } 

       // constructor
       private Node(T dataAtNode, Node nextNode) {

           data = dataAtNode;

           next = nextNode;

       } // end constructor

       //getter
       private T getData() {

           return data;

       } // end getData

       //setter
       private void setData(T newData) {

           data = newData;

       } // end setData
       
       //getter
       private Node getNextNode() {

           return next;

       } // end getNextNode

       //setter
       private void setNextNode(Node nextNode) {

           next = nextNode;

       } // end setNextNode

   } // end Node
   public void clear() {

       initializeDataFields();

   } // end clear

   public void add(T newEntry) {
	   
       Node newNode = new Node(newEntry);

       if (isEmpty())

           firstNode = newNode;

       else {

           Node lastNode = getNodeAt(numberOfEntries);

           lastNode.setNextNode(newNode); // node after last node is new node

       } 
       numberOfEntries++;

   } // end add

   public void add(int newPosition, T newEntry) {

	   // verify if new position is in the linked list
       if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {

           Node newNode = new Node(newEntry);

           // new position is in the beginning of the list
           if (newPosition == 1) {

               newNode.setNextNode(firstNode);

               firstNode = newNode;

           } else {

               Node nodeBefore = getNodeAt(newPosition - 1);

               Node nodeAfter = nodeBefore.getNextNode();

               newNode.setNextNode(nodeAfter);

               nodeBefore.setNextNode(newNode);
               
           }

           numberOfEntries++;

       } else {
    	   
    	  throw new IndexOutOfBoundsException(
                   "Illegal position given to add operation.");
       }

   } // end add

   public T remove(int givenPosition) {

       T result = null; //return value

       if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {

           assert !isEmpty();

        // if first entry is to be removed
           if (givenPosition == 1) {

               result = firstNode.getData(); // entry that will be removed

               firstNode = firstNode.getNextNode(); // dereference to remove

           } else {

               Node nodeBefore = getNodeAt(givenPosition - 1);

               Node nodeToRemove = nodeBefore.getNextNode(); 

               result = nodeToRemove.getData(); // node to be removed

               Node nodeAfter = nodeToRemove.getNextNode();

               nodeBefore.setNextNode(nodeAfter); // node before points to node after

           } // end if

           numberOfEntries--; 

           return result; 

       } else

           throw new IndexOutOfBoundsException(

                   "Illegal position given to remove operation.");

   } // end remove

   public T replace(int givenPosition, T newEntry) {

       if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {

           assert !isEmpty();

           Node desiredNode = getNodeAt(givenPosition);

           T originalEntry = desiredNode.getData();

           desiredNode.setData(newEntry);

           return originalEntry;

       } else

           throw new IndexOutOfBoundsException(

                   "Illegal position given to replace operation.");

   } // end replace

  
   public T getEntry(int givenPosition) {

       if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {

           assert !isEmpty();

           return getNodeAt(givenPosition).getData();

       } else

           throw new IndexOutOfBoundsException(

                   "Illegal position given to getEntry operation.");

   } // end getEntry

   public T[] toArray() {
	   
       int index = 0;
  
       Node currentNode = firstNode;

       @SuppressWarnings("unchecked")
       T[] result = (T[]) new Object[numberOfEntries];

       while ((index < numberOfEntries) && (currentNode != null)) {

           result[index] = currentNode.getData();

           currentNode = currentNode.getNextNode();

           index++;

       } 

       return result;

   } // end toArray

   
   
   public boolean contains(T anEntry) {

       boolean isFound = false;

       Node currentNode = firstNode;

       while (!isFound && (currentNode != null)) {

           if (anEntry.equals(currentNode.getData()))

               isFound = true;

           else

               currentNode = currentNode.getNextNode();

       } // end while

       return isFound;

   } // end contains

   public void swap(int firstPosition, int secondPosition) {

       if(firstPosition >= 1 && firstPosition <= numberOfEntries &&

               secondPosition >=1 && secondPosition <= numberOfEntries) {

           Node firstToSwap = getNodeAt(firstPosition);

           Node secondToSwap = getNodeAt(secondPosition);
           
           
           // need to create temporary variable 
           
           T firstData = firstToSwap.getData();
           
           T temp = firstData;

           T secondData = secondToSwap.getData();
           
           firstToSwap.setData(secondData);

           secondToSwap.setData(temp);

       }

   }

  

   public LList<T> getAllLessThan(Comparable<T> entry) {

       LList<T> isSmaller = new LList<T>();

       Node currentNode = firstNode;

       while(currentNode != null) {

           T currentData = currentNode.getData();

           if(entry.compareTo(currentData) > 0) {

               isSmaller.add(currentData);

           }

           currentNode = currentNode.getNextNode();

       }

       return isSmaller;

   }


   //getter
   public int getLength() {

       return numberOfEntries;

   } 

   public boolean isEmpty() {

       boolean result;

       if (numberOfEntries == 0) {

           assert firstNode == null;

           result = true;

       } else {

           assert firstNode != null;

           result = false;

       } // end if

       return result;

   } // end isEmpty

} // end LList