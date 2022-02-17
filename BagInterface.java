public interface BagInterface <T>{
 public int getCurrentSize();
 public int getFrequencyOf(T anEntry);
 public boolean isEmpty();
 public boolean add(T newEntry);
 public T remove();
 public boolean remove(T anEntry);
 public void clear();
 public boolean contains(T anEntry);
 public T[] toArray();
BagInterface<T> difference(BagInterface<T> bag);
BagInterface<T> intersection(BagInterface<T> bag);
BagInterface<T> union(BagInterface<T> bag);

}


