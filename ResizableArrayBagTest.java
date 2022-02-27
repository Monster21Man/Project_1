import java.util.Arrays;

public class ResizableArrayBagTest {
	public static void main(String[] args) {
		BagInterface<String> bag1 = new ResizableArrayBag<>();
		BagInterface<String> bag2 = new ResizableArrayBag<>();
		/*
		 * // Add 4 entries to bag 1 bag1.add("F"); bag1.add("B"); bag1.add("E");
		 * bag1.add("D");
		 * 
		 * // Add 4 entries to bag 2 bag2.add("D"); bag2.add("C"); bag2.add("B");
		 * bag2.add("A");
		 * 
		 * // Test three methods on the two bags
		 * System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
		 * System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));
		 * System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));
		 * 
		 * // Make a space between two results System.out.println();
		 * 
		 * // Clear both bags of all entries bag1.clear(); bag2.clear();
		 * 
		 * // Test Case: Bags of unequal size bag1.add("A"); bag1.add("C");
		 * 
		 * bag2.add("C"); bag2.add("D"); bag2.add("E");
		 * 
		 * // Test our three methods on the two bags
		 * System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
		 * System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));
		 * System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));
		 * 
		 * // Clear both bags of all entries bag1.clear(); bag2.clear();
		 * 
		 * // Make a space between two results System.out.println();
		 * 
		 * // Test Case: One bag is empty bag1.add(""); bag1.add(""); bag1.add("");
		 * 
		 * bag2.add("C"); bag2.add("D"); bag2.add("E");
		 * 
		 * // Test our three methods on the two bags
		 * System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
		 * System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));
		 * System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));
		 * 
		 * // Clear both bags of all entries bag1.clear(); bag2.clear();
		 * 
		 * // Make a space between two results System.out.println();
		 * 
		 * // Test Case: Both bags are empty bag1.add(""); bag1.add(""); bag1.add("");
		 * 
		 * bag2.add(""); bag2.add(""); bag2.add("");
		 * 
		 * // Test our three methods on the two bags
		 * System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
		 * System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));
		 * System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));
		 * 
		 * // Clear both bags of all entries bag1.clear(); bag2.clear();
		 * 
		 * // Make a space between two results System.out.println();
		 */
		// Test Case: Both bags are empty
		bag1.add("");
		bag1.add("");
		bag1.add("");

		bag2.add(null);
		bag2.add(null);
		bag2.add(null);

		// Test our three methods on the two bags
		System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
		// System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));
		System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));

		// Clear both bags of all entries
		bag1.clear();
		bag2.clear();

		// Make a space between two results
		System.out.println();
	}
}