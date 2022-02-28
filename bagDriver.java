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

		s.close(); 

	}

	
	


}