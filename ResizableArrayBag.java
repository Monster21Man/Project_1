import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * A class that implements a bag of objects by using an array. The bag is never
 * full.
 * 
 * @author Frank M. Carrano, Timothy M. Henry
 * @version 5.0
 * 
 * @group Wheat Farm
 * @author Logan Bailey
 * @author Janet Cho
 * @author Kelly Tsai
 */

public final class ResizableArrayBag<T> implements BagInterface<T> {
	private T[] bag; // Cannot be final due to doubling
	private int numberOfEntries;
	private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 25; // Initial capacity of bag
	private static final int MAX_CAPACITY = 10000;

	/** Creates an empty bag whose initial capacity is 25. */
	public ResizableArrayBag() {
		this(DEFAULT_CAPACITY);
	} // end default constructor

	/**
	 * Creates an empty bag having a given initial capacity.
	 * 
	 * @param initialCapacity The integer capacity desired.
	 */
	public ResizableArrayBag(int initialCapacity) {
		checkCapacity(initialCapacity);

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[]) new Object[initialCapacity]; // Unchecked cast
		bag = tempBag;
		numberOfEntries = 0;
		integrityOK = true;
	} // end constructor

	/**
	 * Creates a bag containing given entries.
	 * 
	 * @param contents An array of objects.
	 */
	public ResizableArrayBag(T[] contents) {
		checkCapacity(contents.length);
		bag = Arrays.copyOf(contents, contents.length);
		numberOfEntries = contents.length;
		integrityOK = true;
	} // end constructor

	/**
	 * Gets the current number of entries in this bag.
	 * 
	 * @return The integer number of entries currently in this bag.
	 */
	public int getCurrentSize() {
		return numberOfEntries;
	} // end getCurrentSize

	/**
	 * Counts the number of times a given entry appears in this bag.
	 * 
	 * @param anEntry The entry to be counted.
	 * @return The number of times anEntry appears in this bag.
	 */
	public int getFrequencyOf(T anEntry) {
		checkintegrity();
		int counter = 0;

		for (int index = 0; index < numberOfEntries; index++) {
			if (anEntry.equals(bag[index])) {
				counter++;
			} // end if
		} // end for

		return counter;
	} // end getFrequencyOf

	/**
	 * Sees whether this bag is empty.
	 * 
	 * @return True if this bag is empty, or false if not.
	 */
	public boolean isEmpty() {
		return numberOfEntries == 0;
	} // end isEmpty

	/**
	 * Adds a new entry to this bag.
	 * 
	 * @param newEntry The object to be added as a new entry.
	 * @return True.
	 */
	public boolean add(T newEntry) {
		checkintegrity();
		if (isArrayFull()) {
			doubleCapacity();
		} // end if

		bag[numberOfEntries] = newEntry;
		numberOfEntries++;

		return true;

	} // end add

	/**
	 * Removes one unspecified entry from this bag, if possible.
	 * 
	 * @return Either the removed entry, if the removal was successful, or null.
	 */
	public T remove() {
		checkintegrity();
		T result = removeEntry(numberOfEntries - 1);
		return result;
	} // end remove

	/**
	 * Removes one occurrence of a given entry from this bag.
	 * 
	 * @param anEntry The entry to be removed.
	 * @return True if the removal was successful, or false if not.
	 */
	public boolean remove(T anEntry) {
		checkintegrity();
		int index = getIndexOf(anEntry);
		T result = removeEntry(index);
		return anEntry.equals(result);
	} // end remove

	// Removes and returns the entry at a given index within the array.
	// If no such entry exists, returns null.
	// Precondition: 0 <= givenIndex < numberOfEntries.
	// Precondition: checkintegrity has been called.
	private T removeEntry(int givenIndex) {
		T result = null;

		if (!isEmpty() && (givenIndex >= 0)) {
			result = bag[givenIndex]; // Entry to remove
			int lastIndex = numberOfEntries - 1;
			bag[givenIndex] = bag[lastIndex]; // Replace entry to remove with last entry
			bag[lastIndex] = null; // Remove reference to last entry
			numberOfEntries--;
		} // end if

		return result;
	} // end removeEntry

	/** Removes all entries from this bag. */
	public void clear() {
		while (!isEmpty())
			remove();
	} // end clear

	/**
	 * Tests whether this bag contains a given entry.
	 * 
	 * @param anEntry The entry to locate.
	 * @return True if this bag contains anEntry, or false otherwise.
	 */
	public boolean contains(T anEntry) {
		checkintegrity();
		return getIndexOf(anEntry) > -1; // or >= 0
	} // end contains

	/**
	 * Retrieves all entries that are in this bag.
	 * 
	 * @return A newly allocated array of all the entries in this bag.
	 */
	public T[] toArray() {
		checkintegrity();

		// The cast is safe because the new array contains null entries.
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries]; // Unchecked cast
		for (int index = 0; index < numberOfEntries; index++) {
			result[index] = bag[index];
		} // end for

		return result;
	} // end toArray

	// Locates a given entry within the array bag.
	// Returns the index of the entry, if located,
	// or -1 otherwise.
	// Precondition: checkintegrity has been called.
	private int getIndexOf(T anEntry) {
		int where = -1;
		boolean found = false;
		int index = 0;

		while (!found && (index < numberOfEntries)) {
			if (anEntry.equals(bag[index])) {
				found = true;
				where = index;
			} // end if
			index++;
		} // end while

		// Assertion: If where > -1, anEntry is in the array bag, and it
		// equals bag[where]; otherwise, anEntry is not in the array.

		return where;
	} // end getIndexOf

	// Returns true if the array bag is full, or false if not.
	private boolean isArrayFull() {
		return numberOfEntries >= bag.length;
	} // end isArrayFull

	// Doubles the size of the array bag.
	// Precondition: checkInitialization has been called.
	private void doubleCapacity() {
		int newLength = 2 * bag.length;
		checkCapacity(newLength);
		bag = Arrays.copyOf(bag, newLength);
	} // end doubleCapacity

	// Throws an exception if the client requests a capacity that is too large.
	private void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY)
			throw new IllegalStateException(
					"Attempt to create a bag whose capacity exceeds " + "allowed maximum of " + MAX_CAPACITY);
	} // end checkCapacity

	// Throws an exception if receiving object is not initialized.
	private void checkintegrity() {
		if (!integrityOK)
			throw new SecurityException("ArrayBag object is corrupt.");
	} // end checkintegrity

	public static <T> void copy(T[] original, T[] duplicate) {
		for (int i = 0; i < original.length; i++) {
			duplicate[i] = original[i];
		} // copying each element of the original onto the 2nd
	} // end copy

	/**
	 * Combines two bags into one, new collection.
	 * 
	 * @param bag The bag to be added.
	 * @return The combined bags of two bags.
	 */
	@Override
	public BagInterface<T> union(BagInterface<T> bag) {
		BagInterface<T> everything = new ResizableArrayBag<>();
		T[] bag0 = this.toArray(); // first bag originally calling the method
		// System.out.println("bag0: " + Arrays.toString(bag0));
		T[] bag1 = bag0; // new bag pointing to the 1st bag
		copy(bag0, bag1); // copying the old elements

		T[] bag2 = bag.toArray(); // second bag that is being placed in the parameter
		// System.out.println("bag2: " + Arrays.toString(bag2));
		T[] bag3 = bag2; // new bag to pointing to the 2nd bag
		copy(bag2, bag3); // copying the old elements

		for (T var : bag1) { // for(T var; var < bag; var++)
			everything.add(var);
		} // adding all of bag 1 into the new bag first
		for (T var : bag3) {
			everything.add(var);
		} // adding all of bag 2 into the bag afterwards

		return everything;
		// since only 2 separate for-each loops, O(n)
	} // end union

	/**
	 * Finds the entries in both bags and returns them in a new bag.
	 * 
	 * @param bag The bag to be compared.
	 * @return The new bag that contains entries from the new bags.
	 */
	@Override
	public BagInterface<T> intersection(BagInterface<T> bag) {
		checkintegrity();

		BagInterface<T> newBag = new ResizableArrayBag<>();
		BagInterface<T> finalBag = new ResizableArrayBag<>();
		T[] tempBag = this.toArray();
		T[] tempBag2 = bag.toArray();
		for (T elem : tempBag) {
			newBag.add(elem);
		}
		for (T elem : tempBag2) {
			if (newBag.contains(elem)) {
				finalBag.add(elem);
			}
		}
		return finalBag;
	}

	/**
	 * Finds the entries that remain after removing those from the bag.
	 * 
	 * @param bag The bag to be removed.
	 * @return The new bag that no longer has entries from the parameter.
	 */
	@Override
	public BagInterface<T> difference(BagInterface<T> bag) {
		checkintegrity();

		BagInterface<T> theBag = new ResizableArrayBag<>();
		T[] other = this.toArray(); // setting other to the array (initializes bag)
		for (int i = 0; i < numberOfEntries; i++) { // making sure there is something in the array
			T conclusion = other[i]; // i is in the index of array; we set it as the variable conclusion
			if (!theBag.contains(conclusion)) { // if the bag does not contain conclusion
				int difference = getFrequencyOf(conclusion) - bag.getFrequencyOf(conclusion); // we take the first bag
																								// and subtract the
																								// second bag

				for (int end = 0; end < difference; end++) {
					theBag.add(conclusion);// if there is a difference from before, we add it to the leftover bag with
											// the add method
				}
			}

		}
		return theBag;
	}

	public BagInterface<T> differences(BagInterface<T> bag) {
		BagInterface<T> theBag = new ResizableArrayBag<>();
		T[] other = this.toArray(); // the first bag
		T[] otherBag = bag.toArray(); // the second bag
		Map<T, Integer> mapFrequency = new HashMap<>(); // using the hashmap method
		for (int i = 0; i < numberOfEntries; i++) {
			T conclusion = other[i];
			if (!mapFrequency.containsKey(conclusion)) {
				mapFrequency.put(conclusion, getFrequencyOf(conclusion));
			}
		}
		for (int i = 0; i < otherBag.length; i++) {
			if (mapFrequency.containsKey(otherBag[i])) {
				mapFrequency.put(otherBag[i], mapFrequency.get(otherBag[i]) - bag.getFrequencyOf(otherBag[i]));
			}
		}
		for (T key : mapFrequency.keySet()) {
			int freq = mapFrequency.get(key);
			if (freq > 0) {
				for (int i = 0; i < freq; i++) {
					theBag.add(key);
				}
			}
		}
		return theBag;
	}
} // end ResizableArrayBag
