import java.util.Arrays;

public class ResizableArrayBagTest
{
  public static void main(String[] args)
  { 
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
}