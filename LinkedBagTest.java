import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * A class that tests the methods implemented in the LinkedBag class from the
 * BagInterface interface class.
 *
 * @group Wheat Farm
 * @author Logan Bailey
 * @author Janet Cho
 * @author Kelly Tsai
 */

class LinkedBagTest {

	/**
	 * Return the current size of the bag.
	 * 
	 * @return The current size of the bag which is currently 5.
	 */
	@Test
	void testGetCurrentSize() {
		// Arrange
		BagInterface<Integer> bag = new LinkedBag<>();

		bag.add(1);
		bag.add(2);
		bag.add(4);
		bag.add(5);
		bag.add(7);

		int num = bag.getCurrentSize();
		assertEquals(5, num);
	}

	/**
	 * Return the number of times a certain entry has appeared.
	 * 
	 * @return The number of times an entry (1) has appeared; in this case, 2 times.
	 */
	@Test
	void testGetFrequencyOf() {
		BagInterface<Integer> bag = new LinkedBag<>();
		bag.add(1);
		bag.add(2);
		bag.add(4);
		bag.add(1);
		bag.add(5);
		bag.add(7);

		int num = bag.getFrequencyOf(1);
		assertEquals(2, num);
	}

	/**
	 * Removes the last entry of the bag.
	 * 
	 * @return The last entry will be removed without any errors.
	 */
	@Test
	void testRemove() {
		BagInterface<Integer> bag = new LinkedBag<>();

		bag.add(1);
		bag.add(2);
		bag.add(5);

		bag.remove();

		assertTrue(bag.contains(2));
		assertFalse(bag.contains(5));
	}

	/**
	 * Removes a certain entry from the bag.
	 * 
	 * @return The specified entry will be removed without any errors.
	 */
	@Test
	void testRemoveEntry() {
		BagInterface<Integer> bag = new ResizableArrayBag<>();

		bag.add(1);
		bag.add(3);
		bag.add(5);
		bag.add(5);

		bag.remove(5);
		assertTrue(bag.contains(5));

		bag.remove(5);
		assertFalse(bag.contains(5));
		assertTrue(bag.contains(1));
	}

	/**
	 * Clears the bag of all entries.
	 * 
	 * @return Bag will be cleared of all entries without any errors.
	 */
	@Test
	void testClear() {
		BagInterface<Integer> bag = new ResizableArrayBag<>();

		bag.add(1);
		bag.add(5);
		bag.add(7);

		bag.clear();

		assertFalse(bag.contains(1));
		int num = bag.getCurrentSize();
		assertEquals(0, num);
	}

	/**
	 * Combines both bags into one bag.
	 * 
	 * @return The combined bag of the previous two bags.
	 */
	@Test
	void testUnion() {
		// Arrange
		BagInterface<String> bag1 = new LinkedBag<>();
		BagInterface<String> bag2 = new LinkedBag<>();

		bag1.add("1");
		bag1.add("2");
		bag1.add("3");

		bag2.add("4");
		bag2.add("hello");

		// Act
		BagInterface<String> addition = bag1.union(bag2);

		// Assert
		assertTrue(addition.contains("2"));
		assertFalse(addition.contains("bye"));
		assertTrue(addition.contains("3"));

	}

	/**
	 * Finds the entries found in both bags.
	 * 
	 * @return The entries located in both bags.
	 */
	@Test
	void testIntersection() {
		// Arrange
		BagInterface<Integer> bag1 = new LinkedBag<>();
		BagInterface<Integer> bag2 = new LinkedBag<>();

		bag1.add(1);
		bag1.add(2);
		bag1.add(3);

		bag2.add(3);
		bag2.add(4);

		// Act
		BagInterface<Integer> intersect = bag1.intersection(bag2);

		// Assert
		assertTrue(intersect.contains(3));
		assertFalse(intersect.contains(6));
		assertFalse(intersect.contains(2));
	}

	/**
	 * Finds the entries located in bag1 that are not found in bag2.
	 * 
	 * @return The entries found in only bag1.
	 */
	@Test
	void testDifference() {
		// Arrange
		BagInterface<Integer> bag1 = new LinkedBag<>();
		BagInterface<Integer> bag2 = new LinkedBag<>();

		bag1.add(3);
		bag1.add(6);
		bag1.add(9);

		bag2.add(6);
		bag2.add(12);
		bag2.add(18);
		bag2.add(24);

		// Act
		BagInterface<Integer> differ = bag1.difference(bag2);

		// Assert
		assertTrue(differ.contains(3));
		assertTrue(differ.contains(9));
		assertFalse(differ.contains(18));
	}
}
