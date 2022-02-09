
public interface BagInterface <T>{
 public BagInterface <T> union (BagInterface<T> newBag);
 public BagInterface <T> intersection(BagInterface<T> newBag);
 public BagInterface <T> difference(BagInterface<T> newBag);
 public int getCSize();
 public int getFreq(T anEntry);
 public boolean isEmpty();
 public boolean add(T newEntry);
 public T remove();
 public boolean remove(T anEntry);
 public void clear();
 public boolean contains(T anEntry);
 public T[] toArray();
 
  
}
