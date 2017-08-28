
public class PriorityQueueBH<T extends Comparable<T>> implements PriorityQueue {


	protected BinaryHeapA<T> heap;

	public PriorityQueueBH(T[] arr) {
		heap = new BinaryHeapA<T>(arr);

	}

	/*
	 * Swaps two elements in an array
	 */
	public void swap(int index1, int index2) {
		T temp = (T) heap.arr[index1];
		heap.arr[index1] = heap.arr[index2];
		heap.arr[index2] = temp;
	}

	/*
	 * Ineserts an item into a priority queue
	 * Calls increase key after inserting the element at the end of the array
	 * that the heap and priority queue are based off of
	 */
	public void insert(Comparable value) {
		if(heap.heapSize<heap.arr.length){
		heap.heapSize++;
		heap.arr[heap.heapSize - 1] = (T) value;
		decreaseKey(heap.heapSize - 1);
	}
	}

	/*
	 * Returns the minimum value
	 */
	public T minimum() {
		return (T) heap.arr[0];

	}

	/*
	 * Returns the minimum value and removes it from the priority queue
	 */
	public T extractMinimum() {
		if (heap.heapSize < 1) {
			System.out.println("There are no items in this heap");
			return null;
		} else {
			T minimum = minimum();
			heap.arr[0] = heap.arr[heap.heapSize - 1];
			heap.heapSize--;
			heap.minHeapify(0);
			return minimum;
		}
	}

	/*
	 * Helper method to return the parent element of the passed in child
	 */
	public int getParent(int el) {
		int parent = (int) Math.floor((el - 1) / 2);
		return parent;
	}

	/*
	 * Compares current element to its parent. If its parent has a greater key, the current element swaps with its
	 * parent element
	 */
	public void decreaseKey(int key) {
		if (key != 0) {
			int parent = getParent(key);
			if (heap.arr[key].compareTo(heap.arr[parent]) >= 0) {
				System.out.println("New key less than current" + heap.arr[key]);
			} else {
				while (key > 0) {
					parent = getParent(key);
					if (heap.arr[key].compareTo(heap.arr[parent]) < 0) {
						swap(key, parent);
						key = parent;
					} else {
						break;
					}
				}

			}
		}
	}



}

