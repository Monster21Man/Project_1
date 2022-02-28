/**
 * An interface that describes the operations of a bag of objects.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * @course CS2400; Project 1
 * @group Wheat Farm
 * @author Logan Bailey
 * @author Janet Cho
 * @author Kelly Tsai
 */
public interface BagInterface<T> {
	/**
	 * Gets the current number of entries in this bag.
	 * 
	 * @return The integer number of entries currently in the bag.
	 */
	public int getCurrentSize();

	/**
	 * Sees whether this bag is empty.
	 * 
	 * @return True if the bag is empty, or false if not.
	 */
	public boolean isEmpty();

	/**
	 * Adds a new entry to this bag.
	 * 
	 * @param newEntry The object to be added as a new entry.
	 * @return True if the addition is successful, or false if not.
	 */
	public boolean add(T newEntry);

	/**
	 * Removes one unspecified entry from this bag, if possible.
	 * 
	 * @return Either the removed entry, if the removal. was successful, or null.
	 */
	public T remove();

	/**
	 * Removes one occurrence of a given entry from this bag, if possible.
	 * 
	 * @param anEntry The entry to be removed.
	 * @return True if the removal was successful, or false if not.
	 */
	public boolean remove(T anEntry);

	/** Removes all entries from this bag. */
	public void clear();

	/**
	 * Counts the number of times a given entry appears in this bag.
	 * 
	 * @param anEntry The entry to be counted.
	 * @return The number of times anEntry appears in the bag.
	 */
	public int getFrequencyOf(T anEntry);

	/**
	 * Tests whether this bag contains a given entry.
	 * 
	 * @param anEntry The entry to find.
	 * @return True if the bag contains anEntry, or false if not.
	 */
	public boolean contains(T anEntry);

	/**
	 * Retrieves all entries that are in this bag.
	 * 
	 * @return A newly allocated array of all the entries in the bag. Note: If the
	 *         bag is empty, the returned array is empty.
	 */
	public T[] toArray();

	/**
	 * Combines two bags into one, new collection.
	 * 
	 * @param bag The bag to be added.
	 * @return The combined bags of two bags.
	 */
	public BagInterface<T> union(BagInterface<T> bag);

	/**
	 * Finds the entries in both bags and returns them in a new bag.
	 * 
	 * @param bag The bag to be compared.
	 * @return The new bag that contains entries from the new bags.
	 */
	public BagInterface<T> intersection(BagInterface<T> bag);

	/**
	 * Finds the entries that remain after removing those from the bag.
	 * 
	 * @param bag The bag to be removed.
	 * @return The new bag that no longer has entries from the parameter.
	 */
	public BagInterface<T> difference(BagInterface<T> bag);
} // end BagInterface
