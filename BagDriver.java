import java.util.Arrays;
import java.util.Scanner;

/**
 * A driver class that demos as a bakery and restaurant simulator. Input:
 * multiple food entries, options to continue or exit. Output: The list of food
 * entries.
 * 
 * @course CS2400; Project 1
 * 
 * @group Wheat Farm
 * @author Logan Bailey
 * @author Janet Cho
 * @author Kelly Tsai
 *
 */
public class BagDriver {
	public static void main(String[] args) {

		// client program for LinkedBag
		BagInterface<String> bag1 = new LinkedBag<>();
		BagInterface<String> bag2 = new LinkedBag<>();

		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to the Wheat Farm.");
		// for this example, we're using a bakery simulator that adds bread to two
		// different shoppings carts (represents the bags)
		System.out.println("You will be demoing a bakery simulator using LinkedBag.");
		System.out.println("What kind of bread do you want in your first shopping cart?");
		String item = s.nextLine(); // takes user input of what kind of bread they want and strings it
		bag1.add(item);// adds item to the first bag

		// using while loop to constantly allow user to add what kind of bread they want
		// and allow them to stop the loop when they are done
		while (true) {

			System.out.println("Do you have more items? Type 0 for Yes and 1 for No.");
			int input = s.nextInt(); // reads the digits and converts into an int type (in this case, yes or no)

			// if/elseif/else statement to ask user if they want to continue adding, to
			// stop, or to tell them of an invalid response
			if (input == 0) { // adds item to bag as long as user enters 0 when prompted if they want to add
								// more
				System.out.println("Please add the next item.");
				item = s.nextLine();
				item = s.nextLine();
				bag1.add(item);
			} else if (input == 1) { // directs user to add more items to the second shopping cart
				System.out.println("Please move on to the second shopping cart.");
				break;
			} else {
				System.out.println("You have entered an invalid response."); // if user enters anything but 0 or 1, they
																				// will receive this response
			}
		}

		// same thing as in the above block of code but with the second shopping cart
		System.out.println("What kind of bread do you want in your second shopping cart?");
		item = s.nextLine();
		item = s.nextLine();
		bag2.add(item);
		while (true) {

			System.out.println("Do you have more items? Type 0 for Yes and 1 for No.");
			int input = s.nextInt();

			if (input == 0) {
				System.out.println("Please add the next item.");
				item = s.nextLine();
				item = s.nextLine();
				bag2.add(item);
			} else if (input == 1) {
				System.out.println("Thank you for shopping at the Wheat Farm");
				break;
			} else {
				System.out.println("You have entered an invalid response.");
			}
		}

		System.out.println("--Checkout--"); // header to make everything clear and spaced out
		System.out.print("\nBoth carts have ");
		System.out.print(Arrays.toString(bag1.union(bag2).toArray())); // prints out the union of bag1 and bag2
		System.out.println(" in total.");

		System.out.print("\nBoth carts have ");
		System.out.print(Arrays.toString(bag1.intersection(bag2).toArray())); // prints out the intersection of bag1 and
																				// bag2
		System.out.println(".");

		System.out.print("\nThe first cart has ");
		System.out.print(Arrays.toString(bag1.difference(bag2).toArray()));// prints out the difference of bag1 and bag2
		System.out.println(" in comparison to the second cart.");

		// client program for ResizableArrayBag
		BagInterface<String> bag3 = new ResizableArrayBag<>();
		BagInterface<String> bag4 = new ResizableArrayBag<>();

		// we will be doing something similar to the bakery simulator, but using a
		// restaurant setting with drinks and food instead of bread
		System.out.println("You will be demoing a restaurant simulator using ResizableArrayBag.");
		System.out.println("What kind of drink would you like?");

		String drink = s.nextLine();
		drink = s.nextLine();
		bag3.add(drink); // adds drink to bag3

		// while loop to allow user to add strings of drinks until they are done
		while (true) {
			System.out.println("Would you like to add another drink? Type in 0 for Yes and 1 for no.");
			int input = s.nextInt();

			if (input == 0) {
				System.out.println("Please add your next drink.");
				drink = s.nextLine();
				drink = s.nextLine();
				bag3.add(drink); // adds drink items to bag3 with the add method
			} else if (input == 1) {
				System.out.println("We will bring your drink shortly.");
				break;
			} else {
				System.out.println("That is not a valid response.");
			}
		}

		// another while loop to allow user to add strings of food until they are done
		System.out.println("What kind of food would you like to order?");
		String food = s.nextLine();
		food = s.nextLine();
		bag4.add(food);
		while (true) {
			System.out.println("Do you want to order any more food? Type in 0 for Yes and 1 for No.");
			int input = s.nextInt();

			if (input == 0) {
				System.out.println("Please add your next item.");
				food = s.nextLine();
				food = s.nextLine();
				bag4.add(food); // adds food items to bag 4 with the add method
			} else if (input == 1) {
				System.out.println("We will bring your food shortly.");
				break;
			} else {
				System.out.println("That is not a valid response.");
			}
		}

		System.out.println("The union of your entire order is: ");
		System.out.print(Arrays.toString(bag3.union(bag4).toArray())); // prints out union of bag3 and bag4

		System.out.println("\nThe intersection of your entire order is: ");
		System.out.print(Arrays.toString(bag3.intersection(bag4).toArray())); // prints out intersection of bag3 and
																				// bag4

		System.out.println("\nThe difference of your entire order is: ");
		System.out.print(Arrays.toString(bag3.difference(bag4).toArray())); // prints out difference of bag3 and bag4

		// this block of code allows the user to add or remove items in either bag3 or
		// bag4 for the resizablearraybag
		boolean ask = true; // set to true to allow user to loop through

		while (ask) {
			System.out.println("You can now remove or add more items.");
			// asking user if they would want to remove/add and in which bag
			System.out.println("Which bag would you like to change?");
			System.out.println("Enter 1 for bag3 and 2 for bag4. Enter 9 to quit.");

			int choice = s.nextInt(); // choice allows user to choose which bag (bag3 or bag4) they would like to
										// add/remove items in
			if (choice == 1) { // boolean response for ==; choice is either true or false
				System.out.println("Press 1 to remove and 2 to add an item.");
				int answer = s.nextInt(); // answer allows user to choose between adding or removing an item in the bag
											// they chose previously
				if (answer == 1) {
					System.out.println("Choose an existing drink to remove.");
					String removeDrink = s.nextLine(); // strings user input
					removeDrink = s.nextLine();
					bag3.remove(removeDrink); // removes the drink from user input from the respective bag they chose
					displayBag(bag3); // uses displayBag method to print out what the new bag is for bag3 (without it,
										// it would print out the memory address)
				} // end if

				// same as the remove block of code above but uses the add method instead
				if (answer == 2) {
					System.out.println("Type an item to add.");
					String addDrink = s.nextLine();
					addDrink = s.nextLine();
					bag3.add(addDrink);
					displayBag(bag3);
					System.out.println("If you would like to quit, please enter 9.");
				} // end if
			}

			// bag4 is the bag of interest in this block of code
			else if (choice == 2) {
				System.out.println("Press 1 to remove and 2 to add an item. Press 9 to quit.");
				int answer = s.nextInt();
				if (answer == 1) {
					System.out.println("Choose an existing food item to remove.");
					String removeFood = s.nextLine();
					removeFood = s.nextLine();
					bag4.remove(removeFood);
					displayBag(bag4);
				} // end if

				if (answer == 2) {
					System.out.println("Type an item to add.");
					String addFood = s.nextLine();
					addFood = s.nextLine();
					bag4.add(addFood);
					displayBag(bag4);
					System.out.println("If you would like to quit, please enter 9.");
					int quit = s.nextInt();
					if (quit == 9) {
						continue;
					}
				} // end if
			} else if (choice == 9) { // if user enters 9, then they will stop the loop
				ask = false; // set to false to stop the while loop from continuously looping
			}
		}
		System.out.println("The union for your new bag is: ");
		System.out.print(Arrays.toString(bag3.union(bag4).toArray()));
		System.out.println("\nThe intersection for your new bag is: ");
		System.out.print(Arrays.toString(bag3.intersection(bag4).toArray()));
		System.out.println("\nThe difference for your new bag is: ");
		System.out.print(Arrays.toString(bag3.difference(bag4).toArray()));

		s.close(); // closes scanner to ensure there isn't any input/output stream
	}

	// displayBag to print out the union, intersection, and difference methods
	private static void displayBag(BagInterface<String> aBag) {
		System.out.println("The bag contains " + aBag.getCurrentSize() + " string(s), as follows: ");
		Object[] bagArray = aBag.toArray();
		for (int index = 0; index < bagArray.length; index++) {
			System.out.print(bagArray[index] + " ");
		} // end for
		System.out.println();
	}// end displayBag

}