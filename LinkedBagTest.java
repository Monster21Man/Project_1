import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/*
 * A class that tests the methods implemented in the LinkedBag class from the BagInterface interface class.
 *
 * @group Wheat Farm
 * @author Logan Bailey
 * @author Janet Cho
 * @author Kelly Tsai
 */

class LinkedBagTest {

	/*
	 * The bag contains 5 items; [1, 2, 4, 5, 7]. Therefore, the current size should
	 * equal 5.
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

	/*
	 * The bag contains 6 items; [1, 2, 4, 1, 5, 7]. Therefore, the current
	 * frequency of 1 should be 2.
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

	/*
	 * The bag consists of [1, 2, 5]. After removing 2, the bag now only consists of
	 * [1, 5].
	 */
	@Test
	void testRemove() {
		BagInterface<Integer> bag = new LinkedBag<>();

		bag.add(1);
		bag.add(2);
		bag.add(5);

		bag.remove(5);

		assertTrue(bag.contains(2));
		assertFalse(bag.contains(5));
	}

	/*
	 * The bag consists of [1, 3, 5, 5]. After removing 5, the bag consists of [1,
	 * 3, 5]. After removing 5 again, the bag consists of [1, 3].
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

	/*
	 * The bag consists of [1, 5, 7]. However, after clearing the bag, the bag
	 * consists of 0 entries.
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

	/*
	 * Union is a collection of both bags. bag1: ["1", "2", "3"]. bag2:
	 * ["4","hello"]. The union is ["1", "2", "3", "4", "hello"].
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

	/*
	 * Intersection is a collection of items found in both bags. bag1: [1, 2, 3]
	 * bag2: [3, 4] The intersection is [3].
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

	/*
	 * Difference is a collection of items that differ between bag 1 and bag 2.
	 * bag1: [3, 6, 9] bag2: [6, 12, 18, 24] Difference: [3, 9]
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
