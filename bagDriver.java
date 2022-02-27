import java.util.*;

public class BagDriver {
  public static void main (String[] args) {
    
    BagInterface <String> bag1 = new LinkedBag <>();
    BagInterface <String> bag2 = new LinkedBag <>();
    
    Scanner s = new Scanner(System.in); 
    System.out.println("Welcome to the Wheat Farm.");
    System.out.println("What kind of bread do you want in your first shopping cart?");
    String item = s.nextLine();
    bag1.add(item);
    while(true){ 
        
        System.out.println("Do you have more items? Type 0 for Yes and 1 for No.");
        int input = s.nextInt(); 
        
        if(input == 0){
          System.out.println("Please add the next item.");
          item = s.nextLine();
          item = s.nextLine();
          bag1.add(item);
        }
        else if (input == 1) {
          System.out.println("Please move on to the second shopping cart.");
          break; 
        }
        else {
          System.out.println("You have entered an invalid response.");
        }
    }
    
    
    System.out.println("What kind of bread do you want in your second shopping cart?");
    item = s.nextLine();
    item = s.nextLine();
    bag2.add(item);
    while(true){ 
        
        System.out.println("Do you have more items? Type 0 for Yes and 1 for No.");
        int input = s.nextInt(); 
        
        if(input == 0){
          System.out.println("Please add the next item.");
          item = s.nextLine();
          item = s.nextLine();
          bag2.add(item);
        }
        else if (input == 1) {
          System.out.println("Thank you for shopping at the Wheat Farm");
          break; 
        }
        else {
          System.out.println("You have entered an invalid response.");
        }

    }

    System.out.println("Your shopping cart has the following for the union method: ");
    System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
    System.out.println("Your shopping cart has the following for the intersection method: ");
    System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));
    System.out.println("Your shopping cart has the following for the difference method: "); 
    System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));
    
    s.close(); 
  }
}