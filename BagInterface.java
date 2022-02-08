
public interface BagInterface <T>{
	public BagInterface <T> union (BagInterface<T> bag);
	public BagInterface <T> intersection(BagInterface<T> bag);
	public BagInterface <T> difference(BagInterface<T> bag);
	
	///*
	public int getSize();
	public boolean full();
	public void clear();

	//*/
}
