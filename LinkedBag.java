public final class LinkedBag<T> implements BagInterface<T>
{
  private Node firstTerm;
  private int entryNum;
  
  public LinkedBag()
  {
    firstTerm = null;
    entryNum = 0;
  }
  
  public boolean isEmpty()
  {
    return entryNum == 0;
  }
  
  public int getCSize()
  {
    return entryNum;
  }
  
  public boolean add(T newEntry)
  {
    Node newTerm = new Node(newEntry);
    newTerm.next = firstTerm;
    firstTerm = newTerm;
    entryNum++;
    return true;
  }
  
  public T[] toArray()
  {
    T[] result = (T[]) new Object[entryNum];
    int i = 0;
    Node currentTerm = firstTerm;
    while ((i < entryNum) && (currentTerm != null))
    {
      result[i] = currentTerm.data;
      i++;
      currentTerm = currentTerm.next;
    }
    return result;
  }
  
  public int getFreq(T anEntry)
  {
    int freq = 0;
    int count = 0;
    Node currentTerm = firstTerm;
    while ((count < entryNum) && (currentTerm != null))
    {
      if(anEntry.equals(currentTerm.data))
      {
        freq++;
      }
      count++;
      currentTerm = currentTerm.next;
    }
    return freq;
  }
  
  public boolean contains(T anEntry)
  {
    boolean isHere = false;
    Node currentTerm = firstTerm;
    while(!isHere && (currentTerm != null))
    {
      if(anEntry.equals(currentTerm.data))
        isHere = true;
      else
        currentTerm = currentTerm.next;
    }
    return isHere;
  }
  
  private Node getRef(T anEntry)
  {
    boolean isHere = false;
    Node currentTerm = firstTerm;
    while(!isHere && (currentTerm != null))
    {
      if(anEntry.equals(currentTerm.data))
        isHere = true;
      else
        currentTerm = currentTerm.next;
    }
    return currentTerm;
  }
  
  public void clear()
  {
    while(!isEmpty())
      remove();
  }
  
  public T remove()
  {
    T result = null;
    if (firstTerm != null)
    {
      result = firstTerm.data;
      firstTerm = firstTerm.next;
      entryNum--;
    }
    return result;
  }
  
  public boolean remove(T anEntry)
  {
    boolean result = false;
    Node termN = getRef(anEntry);
    if(termN != null)
    {
      termN.data = firstTerm.data;
      firstTerm = firstTerm.next;
      entryNum--;
      result = true;
    }
    return result;
  }
  
  private class Node
  {
    private T data;
    private Node next;
    private Node(T dataPortion)
    {
      this(dataPortion, null);
    }
    
    private Node(T dataPortion, Node nextTerm)
    {
      data = dataPortion;
      next = nextTerm;
    }
  }
  
  @Override
  public BagInterface<T> union(BagInterface<T> newBag)
  {
    
  }
  
  @Override
  public BagInterface<T> intersection(BagInterface<T> newBag)
  {
    
  }
  
  @Override
  public BagInterface<T> difference(BagInterface<T> newBag)
  {
    
  }
}
