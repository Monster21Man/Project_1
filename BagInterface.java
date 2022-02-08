
public interface BagInterface <Item>{
	public BagInterface <Item> union (BagInterface<Item> bag);
	public BagInterface <Item> intersection(BagInterface<Item> bag);
	public BagInterface <Item> difference(BagInterface<Item> bag);
}
