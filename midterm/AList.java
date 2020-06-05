import java.util.Arrays;


public class AList<T> {

	private T[] list; 
	
	private int numberOfEntries;
	
	private boolean initialized = false;
	
	private static final int DEFAULT_CAPACITY = 25;
	
	private static final int MAXIMUM_CAPACITY = 10000;

	
	
	//creating custom arrayList
	public AList() {
		
		this(DEFAULT_CAPACITY);
	}

	
	// constructor
	public AList(int initialCapacity) {
		
		// check if initial capacity is okay
		if (initialCapacity < DEFAULT_CAPACITY)
			
			initialCapacity = DEFAULT_CAPACITY;
		
		else 
			
			checkCapacity(initialCapacity);
		
		
		@SuppressWarnings("unchecked")
		T[] temporaryAList = (T[]) new Object[initialCapacity + 1];
		
		list = temporaryAList;
		
		numberOfEntries = 0;
		
		initialized = true;
	} 
	
	
	// This method doubles the capacity of AList if it's full
	private void ensureCapacity() {
		
		int capacity = list.length - 1;
		
		if (numberOfEntries >= capacity) {
			
			int newCapacity = 2 * capacity;
			
			checkCapacity(newCapacity); 
			
			list = Arrays.copyOf(list, newCapacity + 1);
		}
	} 

	// This method makes room for new entry in AList
	// Passing: new position where to make space
	// returning: nothing
	// checkInitialization is called
	private void makeRoom(int newPosition) {
		
		assert (newPosition >= 1) && (newPosition <= numberOfEntries + 1);

		int newIndex = newPosition;
		
		int lastIndex = numberOfEntries;

		// moving every entry higher
		for (int index = lastIndex; index >= newIndex; index--) {
			
			list[index + 1] = list[index];
			
		}
		
	} // end makeRoom

	// Remove gap if there is any
	// Passing: position which is empty
	// checkInitialization is called
	private void removeGap(int givenPosition) {
		
		assert (givenPosition >= 1) && (givenPosition < numberOfEntries);

		int remove = givenPosition;
		
		int lastItem = numberOfEntries;

		for (int index = remove; index < lastItem; index++) {
			
			list[index] = list[index + 1];
		} 
		
	} // end removeGap

	// check if object is initialized
	private void checkInitialization() {
		
		if (!initialized)
			
			throw new SecurityException("AList object is not initialized properly.");
		
	} // end checkInitialization

	// validate if capacity is within range
	private void checkCapacity(int capacity) {
		
		if (capacity > MAXIMUM_CAPACITY) {
			
			throw new IllegalStateException(
					
					"Attempt to create a list " + "whose capacity exceeds " + "allowed maximum.");
		}
	} // end checkCapacity

	public void add(T newEntry) {
		
		checkInitialization();
		
		list[numberOfEntries + 1] = newEntry;
		
		numberOfEntries++;
		
		ensureCapacity();
	
	} // end add

	//add new profile 
	//passing: index of new profile and new profile
	public void add(int newPosition, T newEntry) {
		
		checkInitialization();
		
		//validations
		if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
			
			if (newPosition <= numberOfEntries)
				
				makeRoom(newPosition);
				
				list[newPosition] = newEntry;
				
				numberOfEntries++;
				
				ensureCapacity();
		} else
			
			throw new IndexOutOfBoundsException("Given position of add's new entry is out of bounds.");
	
	}

	// remove a profile
	// passing: index of profile to be removed
	public T remove(int givenPosition) {
		
		checkInitialization();
		
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
		
			assert !isEmpty();
			
			T result = list[givenPosition]; 
		
			if (givenPosition < numberOfEntries) {
				
				removeGap(givenPosition);
			}

			numberOfEntries--;
			
			return result;
			
		} else
			
			throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
	}

	//this method removes all profiles
	public void clear() {
		
		checkInitialization();

		for (int i = 1; i <= numberOfEntries; i++) {
			
			list[i] = null;
		}

		numberOfEntries = 0;
	}

	// replace profile with new data
	// passing: position of profile, data
	public T replace(int givenPosition, T newEntry) {
		
		checkInitialization();
		
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
		
			assert !isEmpty();
		
			T original = list[givenPosition];
			
			list[givenPosition] = newEntry;
			
			return original;
		
		} else
			
			throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
	}

	
	//get profile at specific index
	public T getEntry(int givenPosition) {
		
		checkInitialization();
		
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			
			assert !isEmpty();
			
			return list[givenPosition];
		
		} else
		
			throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
	}

	
	//check at what index is an entry
	//passing: the entry
	// returning: index of entry
	public int contains(T anEntry) {
		
		checkInitialization();

		int found = -1;
		
		int index = 1;
		
		while (found == -1 && (index <= numberOfEntries)) {
		
			if (anEntry.equals(list[index])) {
			
				found = index;
			}
			
			index++;
		}
		return found;
	}

	// check if AList is empty
	public boolean isEmpty() {
		
		return numberOfEntries == 0;
	}

	// getter
	public int getLength() {
		
		return numberOfEntries;
	}
	

	// returning all profiles in AList as an array
	public T[] toArray() {

		checkInitialization();

		@SuppressWarnings("unchecked")
		T[] allEntries = (T[]) new Object[numberOfEntries];
		
		for (int i = 0; i < numberOfEntries; i++) {
			
			allEntries[i] = list[i + 1];
		}
		return allEntries;
	}
}