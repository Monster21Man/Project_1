
public class LinkedBag<T> implements BagInterface<T> {
	
	private final T[] bag;
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 25;
	
	public LinkedBag() {
		numberOfEntries = 0;
		
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[])new Object[DEFAULT_CAPACITY];
		bag = tempBag;
	}
	
	@Override
	public int getCurrentSize() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		if(numberOfEntries == 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean add(T newEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BagInterface<T> union(BagInterface<T> bag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BagInterface<T> intersection(BagInterface<T> bag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BagInterface<T> difference(BagInterface<T> bag) {
		// TODO Auto-generated method stub
		return null;
	}
}
