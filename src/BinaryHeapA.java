import java.util.Arrays;

/**
 * A class that implements BinaryHeap Data Structure
 * @author Moe Pwint Phyu
 *
 * @param <T>
 */

public class BinaryHeapA<T extends Comparable<T>> implements BinaryHeap {
    // array to hold the heap
    public T[] arr;

    // keep track of the heap size (different from the capacity) private int
    // heapSize;
    public int heapSize=0;

    public BinaryHeapA(T[] array) {
	arr = array;
	buildMinHeap();
    }

    //makes sure all of the value below the passed in index are less than the value of 
    //the index. Finds the largest side and recursively calls max heapify on that side
    // until the whole heap satisfies the requirements of a heap

    public void minHeapify(int index) {
	int left = index * 2+1;
	int right = left + 1;
	int smallest = index;

	if (left <= heapSize && arr[left].compareTo(arr[index]) < 0) {
	    smallest = left;
	}
	else{
	    smallest = index;
	}

	if (right < heapSize && arr[right].compareTo(arr[smallest]) < 0) {
	    smallest = right;
	}

	if (smallest != index) {
	    swap(index, smallest);
	    minHeapify(smallest);

	}
    }

    // Set the heap size to be the length of the array
    // max heapify the top half of the heap
    public void buildMinHeap() {
	if(arr[0] != null){
	    heapSize = arr.length;
	    for (int i = heapSize /2-1; i >= 0; i--) {
		minHeapify(i);
	    }
	}
    }

    //Swaps two items in the array
    public void swap(int index1, int index2) {
	T temp = arr[index1];
	arr[index1] = arr[index2];
	arr[index2] = temp;
    }



}