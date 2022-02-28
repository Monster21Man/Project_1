import java.util.Arrays;
import java.util.Scanner;

public class bagDriver {
	public static void main(String[] args) {

		BagInterface<String> bag1 = new LinkedBag<>();
		BagInterface<String> bag2 = new LinkedBag<>();

		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to the Wheat Farm.");
		System.out.println("You will be demoing a bakery simulator using LinkedBag."); 
		System.out.println("What kind of bread do you want in your first shopping cart?");
		String item = s.nextLine();
		bag1.add(item);
		while (true) {

			System.out.println("Do you have more items? Type 0 for Yes and 1 for No.");
			int input = s.nextInt();

			if (input == 0) {
				System.out.println("Please add the next item.");
				item = s.nextLine();
				item = s.nextLine(); 
				bag1.add(item);
			} else if (input == 1) {
				System.out.println("Please move on to the second shopping cart.");
				break;
			} else {
				System.out.println("You have entered an invalid response.");
			}
		}

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

		System.out.println("--Checkout--");
		System.out.print("Both carts have ");
		System.out.print(Arrays.toString(bag1.union(bag2).toArray()));
		System.out.println(" in total.");

		System.out.print("Both carts have ");
		System.out.print(Arrays.toString(bag1.intersection(bag2).toArray()));
		System.out.println(".");

		System.out.print("The first cart has ");
		System.out.print(Arrays.toString(bag1.difference(bag2).toArray()));
		System.out.println(" in comparison to the second cart.");

		


		BagInterface<String> bag3 = new ResizableArrayBag<>(); 
		BagInterface<String> bag4 = new ResizableArrayBag<>(); 

		System.out.println("You will be demoing a restaurant simulator using ResizableArrayBag."); 
		System.out.println("What kind of drink would you like?"); 
		
		String drink = s.nextLine();  
		drink = s.nextLine(); 
		bag3.add(drink);
		while(true) {
			System.out.println("Would you like to add another drink? Type in 0 for Yes and 1 for no."); 
			int input = s.nextInt(); 

			if(input == 0) {
				System.out.println("Please add your next drink."); 
				drink = s.nextLine(); 
				drink = s.nextLine(); 
				bag3.add(drink); 
			}
			else if (input == 1) {
				System.out.println("We will bring your drink shortly."); 
				break;
			}
			else {
				System.out.println("That is not a valid response."); 
			}
		}

		System.out.println("What kind of food would you like to order?"); 
		String food = s.nextLine(); 
		food = s.nextLine(); 
		bag4.add(food); 
		while(true) {
			System.out.println("Do you want to order any more food? Type in 0 for Yes and 1 for No."); 
			int input = s.nextInt();

			if(input == 0) {
				System.out.println("Please add your next item.");
				food = s.nextLine();
				food = s.nextLine();
				bag4.add(food); 
			}
			else if (input == 1) {
				System.out.println("We will bring your food shortly.");
				break;
			}
			else {
				System.out.println("That is not a valid response."); 
			}
		}

		System.out.println("The union of your entire order is: "); 
		System.out.print(Arrays.toString(bag3.union(bag4).toArray()));

		System.out.println("\nThe intersection of your entire order is: ");
		System.out.print(Arrays.toString(bag3.intersection(bag4).toArray()));

		System.out.println("\nThe difference of your entire order is: "); 
		System.out.print(Arrays.toString(bag3.difference(bag4).toArray()));

		
		
		
		boolean ask = true;
		while(ask) {
			System.out.println("You can now remove or add more items."); 
			System.out.println("Which bag would you like to change?");
			System.out.println("Enter 1 for bag3 and 2 for bag4. Enter 9 to quit."); 
			int choice = s.nextInt(); 
			if (choice == 1) {
				System.out.println("Press 1 to remove and 2 to add an item.");
				int answer = s.nextInt(); 
				if (answer == 1) {
					System.out.println("Choose an existing drink to remove.");
					String removeDrink = s.nextLine(); 
					removeDrink = s.nextLine(); 
					bag3.remove(removeDrink); 
					displayBag(bag3); 
					System.out.println("If you would like to quit, please enter 9. Press any number to continue.");
					int quit = s.nextInt();
					if(quit == 9) {
						break;
				}
			}
				
				if (answer == 2) {
					System.out.println("Type an item to add."); 
					String addDrink = s.nextLine(); 
					addDrink = s.nextLine(); 
					bag3.add(addDrink); 
					displayBag(bag3);
					System.out.println("If you would like to quit, please enter 9.");
					

				}
			
			else if (choice == 2) {
				System.out.println("Press 1 to remove and 2 to add an item. Press 9 to quit.");
				answer = s.nextInt(); 
				if (answer == 1) {
					System.out.println("Choose an existing food item to remove.");
					String removeFood = s.nextLine(); 
					removeFood = s.nextLine(); 
					bag4.remove(removeFood); 
					displayBag(bag4); 
					}

				
				if (answer == 2) {
					System.out.println("Type an item to add."); 
					String addFood = s.nextLine();
					addFood = s.nextLine();  
					bag4.add(addFood); 
					displayBag(bag4);
					System.out.println("If you would like to quit, please enter 9.");
					int quit = s.nextInt(); 
					if(quit == 9) {
						continue; 
					}
					else{

					}

				}
			}
				

				}
		System.out.print(Arrays.toString(bag3.union(bag4).toArray()));
		System.out.print(Arrays.toString(bag3.intersection(bag4).toArray()));
		System.out.print(Arrays.toString(bag3.difference(bag4).toArray()));
			}
		
		s.close();
		}
			

		
		


	private static void displayBag(BagInterface<String> aBag) {
		System.out.println("The bag contains " + aBag.getCurrentSize() + " string(s), as follows: ");
		Object[] bagArray = aBag.toArray(); 
		for(int index = 0; index < bagArray.length; index++) {
		  System.out.print(bagArray[index] + " "); 
		}//end for 
		System.out.println(); 
	  }//end displayBag

	
	


}