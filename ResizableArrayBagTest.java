import java.util.Arrays;
import java.util.*;

public class ResizableArrayBagTest
{
  public static void main(String[] args)
  { 
    //a bag who has a small initial capactiy
    BagInterface <String> bag1 = new ResizableArrayBag <>();
    BagInterface <String> bag2 = new ResizableArrayBag <>();

    testIsMax(bag1, false); 
    String[] bag1Info = {"A", "B", "C", "A", "A", "A", "B", "A"};
    testAdd(bag1, bag1Info); 

    testIsMax(bag2, false); 
    String[] bag2Info = {"A", "A", "C", "D", "A"}; 
    testAdd(bag2, bag2Info); 

    BagInterface<String> unions = bag1.union(bag2);
    System.out.println("The union of this bag is: "); 
    displayBag(unions); 

    BagInterface<String> intersections = bag1.intersection(bag2); 
    System.out.println("The intersection of this bag is: ");
    displayBag(intersections); 

    BagInterface<String> differences = bag1.difference(bag2);
    System.out.println("The difference of bag 1 minus bag 2 is: ");
    displayBag(differences); 


    testRemove(bag1, bag1Info);
    
    BagInterface<String> removed = bag1.union(bag2);
    System.out.println("Removing the first bag will give us: ");
    displayBag(removed); 

    // testIsEmpty(bag1)

    

  }



  
  private static void testAdd(BagInterface<String> aBag, String[] content) {
    System.out.print("Adding to the bag: "); 
    for (int index = 0; index < content.length; index++) {
      aBag.add(content[index]); 
      System.out.print(content[index] + " "); 
    }//end for
    System.out.println(); 
    displayBag(aBag); 
  }//end testAdd method



  private static void displayBag(BagInterface<String> aBag) {
    System.out.println("The bag contains " + aBag.getCurrentSize() + " string(s), as follows: ");
    Object[] bagArray = aBag.toArray(); 
    for(int index = 0; index < bagArray.length; index++) {
      System.out.print(bagArray[index] + " "); 
    }//end for 
    System.out.println(); 
  }//end displayBag

  private static void testRemove(BagInterface<String> aBag, String[] tests) {
    for (int index = 0; index < tests.length; index++) {
      String aString = tests[index]; 
      if (aString.equals("") || (aString == null)) {
        //Test remove()
        System.out.println("\nRemoving a string from the bag: "); 
        String removedString = aBag.remove(); 
        System.out.println("remove() returns " + removedString); 
      }
      else {
        //Test remove(aString) 
        System.out.println("\nRemoving \"" + aString + "\" from the bag: ");
        boolean result = aBag.remove(aString);
        System.out.println("remove(\"" + aString + "\") returns " + result); 
      }//end if 
      displayBag(aBag); 
    }//end for
  }//end testRemove

  //Tests the method isEmpty.
  //correctResult indicates what isEmpty should return.


  private static void testIsEmpty(BagInterface<String> aBag, boolean correctResult) {
    System.out.print("Testing isEmpty with ");
    if(correctResult) {
      System.out.print("an empty bag:");
    }
    else {
      System.out.print("a bag that is not empty:"); 
    }
    System.out.println("isEmpty finds the bag ");
    if (correctResult && aBag.isEmpty()) {
      System.out.println("empty: OK."); 
    }
    else if (correctResult) {
      System.out.println("not empty, but it is empty: ERROR."); 
    }
    else if (!correctResult && aBag.isEmpty()) {
      System.out.print("empty, but it is not empty: ERROR."); 
    }
    else {
      System.out.println("not empty: OK."); 
    }//end testIsEmpty
  }

  private static void testIsMax(BagInterface<String> aBag, boolean correctResult) {
    System.out.print("Testing isMax with ");
    if(correctResult) {
      System.out.print("a max bag:");
    }
    else {
      System.out.print("a bag that is not max:"); 
    }
    System.out.println("isMax finds the bag ");
    if (correctResult && aBag.isEmpty()) {
      System.out.println("max: OK."); 
    }
    else if (correctResult) {
      System.out.println("not max, but it is max: ERROR."); 
    }
    else if (!correctResult && aBag.isEmpty()) {
      System.out.print("max, but it is not max: ERROR."); 
    }
    else {
      System.out.println("not max: OK."); 
    }//end testIsEmpty
  }


  

  //Tests the method getFrequencyOf
  private static void testFrequency(BagInterface<String> aBag, String[] tests) {
    System.out.println("\nTesting the method getFrequencyOf:"); 
    for (int index = 0; index < tests.length; index++) {
      System.out.println("In this bag, the count of " + tests[index] + " is " +aBag.getFrequencyOf(tests[index])); 
    } //end testFrequency
  }

}