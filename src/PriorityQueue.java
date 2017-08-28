
public interface PriorityQueue<T extends Comparable<T>>  {

	
	public T minimum();
	
	public T extractMinimum();
	
	public void decreaseKey(int key);

	public void swap(int index1, int index2);

	public int getParent(int el);

	public void insert(Comparable value);

}
