/**
 * An interface for BinaryHeapA
 * @author Moe Pwint Phyu
 *
 * @param <T>
 */

public interface BinaryHeap<T extends Comparable<T>>{


    public void minHeapify(int index);

    public void buildMinHeap();

    public void swap(int index1, int index2);



}