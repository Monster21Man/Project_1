import java.util.*;

public class bagDriver {
  public static void main (String[] args) {
    
    BagInterface <String> bag1 = new LinkedBag <>();
    BagInterface <String> bag2 = new LinkedBag <>();
    
    Scanner s = new Scanner(System.in); 
    System.out.println("Welcome to the Wheat Farm.");
    boolean cont = false;
    System.out.println("What kind of bread do you want in your first shopping cart?");
    while(true){ 
      String item = s.nextLine();
      bag1.add(item);
      
      System.out.println("Do you have more items? Type Y or N");
      int input = s.nextInt(); 
      
      if(input == 0){
        System.out.println("Please add the next item.");
      }
      else if (input == 1) {
        System.out.println("Please move on to the second shopping cart.");
        break; 
      }
      else {
        System.out.println("You have entered an invalid response.");
      }
    }
    
