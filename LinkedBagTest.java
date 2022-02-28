import java.util.Arrays;
public class LinkedBagTest
{
  public static void main(String[] args)
  {
	//Create two LinkedBag arrays with elements of type String
    BagInterface <String> bag1 = new LinkedBag <>();
    BagInterface <String> bag2 = new LinkedBag <>();
    BagInterface <String> bag3 = null; 
    int numberofEntries; 
    //Add 4 entries to bag 1
    bag1.add("F");
    bag1.add("B");
    bag1.add("E");
    bag1.add("D");
    
    //Add 4 entries to bag 2
    bag2.add("D");
    bag2.add("C");
    bag2.add("B");
    bag2.add("A");
    
    //Test three methods on the two bags
    System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
    System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));
    System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));
    
    //Make a space between two results
    System.out.println();
    
    //Clear both bags of all entries
    bag1.clear();
    bag2.clear();
    
    //Test Case: Bags of unequal size
    bag1.add("A");
    bag1.add("C");
    
    bag2.add("C");
    bag2.add("D");
    bag2.add("E");
    
    
    
    //Test our three methods on the two bags
    System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
    System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));
    System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));
    
    //Clear both bags of all entries
    bag1.clear();
    bag2.clear();
    
    //Make a space between two results
    System.out.println();
    
    //Test Case: One bag is empty
    bag1.add("");
    bag1.add("");
    bag1.add("");
    
    bag2.add("C");
    bag2.add("D");
    bag2.add("E");
    
    //Test our three methods on the two bags
    System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
    System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));
    System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));
    
    //Clear both bags of all entries
    bag1.clear();
    bag2.clear();
    
   // Make a space between two results
    System.out.println();
    
    //Test Case: Both bags are empty

    bag1.add("");
    bag1.add("");
    bag1.add("");
    
    bag2.add("");
    bag2.add("");
    bag2.add("");
    
    //Test our three methods on the two bags
    System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
    System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));
    System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));
    
    //Clear both bags of all entries
    bag1.clear();
    bag2.clear();
    
    //Make a space between two results
    System.out.println();
    
  //Test Case: Both bags are empty
    bag1.add("");
    bag1.add("");
    bag1.add("");
    
    bag2.add("");
    bag2.add("");
    bag2.add("");
    
    //Test our three methods on the two bags
    System.out.println(Arrays.toString(bag1.union(bag3).toArray()));
    System.out.println(Arrays.toString(bag1.intersection(bag3).toArray()));
    System.out.println(Arrays.toString(bag1.difference(bag3).toArray()));
    
    //Clear both bags of all entries
    bag1.clear();
    bag2.clear();
    
    //Make a space between two results
    System.out.println();
  
  }


  

  private static void testIsEmpty(BagInterface<String> bag, boolean empty)
   {
      System.out.print("\nTesting isEmpty with ");
      if (empty)
         System.out.println("an empty bag:");
      else
         System.out.println("a bag that is not empty:");
      
      System.out.print("isEmpty finds the bag ");
      if (empty && bag.isEmpty())
			System.out.println("empty: OK.");
		else if (empty)
			System.out.println("not empty, but it is: ERROR.");
		else if (!empty && bag.isEmpty())
			System.out.println("empty, but it is not empty: ERROR.");
		else
			System.out.println("not empty: OK.");      
	} // end testIsEmpty
   
   // Tests the method add.
   private static void testAdd(BagInterface<String> aBag, String[] content)
   {
      System.out.print("Adding the following strings to the bag: ");
      for (int index = 0; index < content.length; index++)
      {
         if (aBag.add(content[index]))
            System.out.print(content[index] + " ");
         else
            System.out.print("\nUnable to add " + content[index] +
                             " to the bag.");
      } // end for
      System.out.println();
      
      displayBag(aBag);
   } // end testAdd
   
   // Tests the method toArray while displaying the bag.
   private static void displayBag(BagInterface<String> aBag)
   {
      System.out.println("The bag contains the following string(s):");
      Object[] bagArray = aBag.toArray();
      for (int index = 0; index < bagArray.length; index++)
      {
         System.out.print(bagArray[index] + " ");
      } // end for
      
      System.out.println();
   } // end displayBag



}