import java.util.Arrays;

public class ResizableArrayBagTest
{
  public static void main(String[] args)
  { 
    //a bag who has a small initial capactiy
    BagInterface <String> bag1 = new ResizableArrayBag <>();
    BagInterface <String> bag2 = new ResizableArrayBag <>();
    
    bag1.add("A");
    bag1.add("B");
    bag1.add("C");
    bag1.add("B");
    
    bag2.add("B");
    bag2.add("A");
    bag2.add("B");
    bag2.add("D");
    
    System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
    System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));
    System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));
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

  //Tests the method getFrequencyOf
  private static void testFrequency(BagInterface<String> aBag, String[] tests) {
    System.out.println("\nTesting the method getFrequencyOf:"); 
    for (int index = 0; index < tests.length; index++) {
      System.out.println("In this bag, the count of " + tests[index] + " is " +aBag.getFrequencyOf(tests[index])); 
    } //end testFrequency
  }

}