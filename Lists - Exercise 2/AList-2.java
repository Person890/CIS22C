/*
 * Author
 * @Natalie Stepankevycova
 * 
 * CIS 22C - Data Structures
 *
 * AList.java
 * 
 * This program is testing the methods of an array
 * The program performs the following methods:
 * 		adds numbers to the array
 * 		checks if the array is empty 
 * 		outputs number of instances in the
 * 		clears the linked list
 * 		replaces data at different positions
 * 		removes instances
 * 		checks if there is given data at the array
 * 		gets position of an entry
 * */




import java.util.*;

public class AList<T> implements ListInterface<T> {

      private T[] list;
      
      private int numberOfEntries;

      private boolean initialized = false;

      private static final int DEFAULT_CAPACITY = 25;

      private static final int MAX_CAPACITY = 10000;

      //default constructor
      public AList() {

            this(DEFAULT_CAPACITY);

      }
      
      // AList constructor
      public AList(int initialCapacity) {

            // check if initialCapacity is valid #

            if (initialCapacity < DEFAULT_CAPACITY)

                  initialCapacity = DEFAULT_CAPACITY;

            else 
            	
                  checkCapacity(initialCapacity);


            T[] tempList = (T[]) new Object[initialCapacity + 1];

            initialized = true;
            list = tempList;
            numberOfEntries = 0;

      }

      // add method
      public void add(T newEntry) {

            add(numberOfEntries + 1, newEntry);

      } 

      // add entry to specific position
      public void add(int newPosition, T newEntry) {

            checkInitialization();
 
            if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) { 
         
                  if (newPosition <= numberOfEntries) 
                	  // if the new position isn't in the end of the list, it
                	  // needs to add room

                        makeRoom(newPosition);

                  list[newPosition] = newEntry;

                  numberOfEntries++;

                  ensureCapacity(); // make sure there is room for next entry

            } else

                  throw new IndexOutOfBoundsException(

                              "Given position of add's new entry is out of bounds.");

      } // end add

      public T remove(int givenPosition) {

            checkInitialization();

            if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) { 

                  assert !isEmpty(); 

                  T result = list[givenPosition]; // which position will be removed

                  if (givenPosition < numberOfEntries)

                        removeGap(givenPosition);

                  numberOfEntries--;

                  return result;

            } else

                  throw new IndexOutOfBoundsException(

                              "Illegal position given to remove operation.");

      } // end remove
      
      public T replace(int givenPosition, T newEntry) {

          checkInitialization();

          if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {

                assert !isEmpty();

                T originalEntry = list[givenPosition];

                list[givenPosition] = newEntry;

                return originalEntry;

          } else

                throw new IndexOutOfBoundsException(
              		  "Illegal position given to replace operation.");

    } // end replace


      public void clear() {

    	  checkInitialization();
    	  
    	  // loop to delete all entries
            for (int index = 1; index <= numberOfEntries; index++)

                list[index] = null;

            	numberOfEntries = 0;

      } // end clear

      
      public T getEntry(int givenPosition) {

            checkInitialization();

            if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {

                  assert !isEmpty();

                  return list[givenPosition];

            } else

                  throw new IndexOutOfBoundsException(

                              "Illegal position given to getEntry operation.");

      } // end getEntry

      public T[] toArray() {

            checkInitialization();
            
            // to avoid warning
            @SuppressWarnings("unchecked")

            T[] result = (T[]) new Object[numberOfEntries]; 

            for (int index = 0; index < numberOfEntries; index++) {

                  result[index] = list[index + 1];

            } 

            return result;

      } // end toArray

      
      // method to check if array contains element
      public boolean contains(T anEntry) {

            checkInitialization();

            boolean found = false;

            int index = 1;

            while (!found && (index <= numberOfEntries)) {

                  if (anEntry.equals(list[index]))

                        found = true;

                  index++;

            } 

            return found;

      } // end contains

      // getter
      public int getLength() {

            return numberOfEntries;
      } 

      // checks if array is empty
      public boolean isEmpty() {

            return numberOfEntries == 0;
      }

      
      public boolean moveToEnd() {
    	  
            if (numberOfEntries > 1) {

                  T entry = remove(1);

                  add(entry);

                  return true;

            } else {

                  return false;
            }
      }

      public boolean swap(int firstPosition, int secondPosition) {

            if (firstPosition >= 1 && firstPosition <= numberOfEntries

                  && secondPosition >= 1 && secondPosition <= numberOfEntries) {

                  T temp = list[firstPosition];

                  list[firstPosition] = list[secondPosition];

                  list[secondPosition] = temp;

                  return true;

            } else {

                  throw new IndexOutOfBoundsException(

                              "Illegal position given to swap operation.");

            }

      }

      public AList<T> getAllLessThen(Comparable entry) {

            AList<T> lessThanList = new AList<T>();

            for (int i = 1; i < numberOfEntries; i++) {

                  T currentItem = list[i];
                  // check if current item is smaller than entry
                  if (entry.compareTo(currentItem) > 0) { 
                	  
                        lessThanList.add(currentItem);

                  }
            }

            return lessThanList;
      }

    
      public void moveToBeginning() {

            if (!isEmpty()) {

                  // removing and storing last element
                  T lastElement = remove(numberOfEntries);

                  add(1, lastElement);
            }

      }

      // overridden methods
      public boolean equals(Object obj) {

            // make sure that obj is AList object

            if (obj instanceof AList) {

                  AList<T> other = (AList<T>) obj;

                  // check if # of elem match
                  if (this.numberOfEntries != other.numberOfEntries) {

                        return false;

                  }

                  // number of elements are equal, so now looping through each

                  // location

                  for (int i = 1; i <= numberOfEntries; i++) {

                        // if element at location i in this list is not equal to that in

                        // other list, returning false

                        if (!this.list[i].equals(other.list[i])) {

                              return false;

                        }

                  }

                  // at the end, if all values are same, returning true

                  return true;

            }

            // returning false if ob is not an AList

            return false;

      }

      // this method doubles capacity if the list is full
      private void ensureCapacity() {

            int capacity = list.length - 1;

            if (numberOfEntries >= capacity) {

                  int newCapacity = 2 * capacity;

                  checkCapacity(newCapacity); // Is capacity too big?

                  list = Arrays.copyOf(list, newCapacity + 1);

            } // end if

      } // end ensureCapacity

      // This method creates space for an entry that isn't in the end of an array
      private void makeRoom(int newPosition) {

            assert (newPosition >= 1) && (newPosition <= numberOfEntries + 1);

            int newIndex = newPosition;

            int lastIndex = numberOfEntries;

            // Move each entry to next higher index, starting at end of

            // list and continuing until the entry at newIndex is moved

            for (int index = lastIndex; index >= newIndex; index--)

                  list[index + 1] = list[index];

      } // end makeRoom

      // This method removes empty position after an entry is removed in 
      // the middle of an array
      private void removeGap(int givenPosition) {

            assert (givenPosition >= 1) && (givenPosition < numberOfEntries);

            int removedIndex = givenPosition;

            int lastIndex = numberOfEntries;

            for (int index = removedIndex; index < lastIndex; index++)

                  list[index] = list[index + 1];

      } // end removeGap

      // This method throws an exception of the object is not initialized
      private void checkInitialization() {

            if (!initialized)

                  throw new SecurityException ("AList object is not initialized properly.");

      } // end checkInitialization

      // this method checks if the capacity is valid
      private void checkCapacity(int capacity) {

            if (capacity > MAX_CAPACITY)

                  throw new IllegalStateException("Attempt to create a list "
                              + "whose capacity exceeds " + "allowed maximum.");

      } // end checkCapacity
      
      
      
      
      
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
  * 
  * 
  * */     
 
} 