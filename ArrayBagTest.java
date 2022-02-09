import java.util.*;
import java.util.Arrays; 

//contains main method to test the three methods
public class ArrayBagTest {
	public static void main (String args[]) {
		BagInterface <String> bagA = new ResizableArrayBag<>();
		BagInterface <String>  bagB = new ResizableArrayBag<>(); 
		
		bagA.add("1"); 
		bagA.add("A"); 
		bagB.add("?");
		
		System.out.println("Hello");
		
	}
	
	
}

