import java.util.Collections;
import java.util.PriorityQueue;

public class MedianStream {

    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());;
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();;

    public static void insertHeap(int x)
    {
        // add your code here
        if(maxHeap.isEmpty()||maxHeap.peek()>x)
            maxHeap.add(x);
        else
            minHeap.add(x);
        balanceHeaps();
    }

    // Function to balance Heaps
    public static void balanceHeaps()
    {
        // add your code here
        if(maxHeap.size()>minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }else if(minHeap.size()>maxHeap.size()+1)
            maxHeap.add(minHeap.poll());

    }

    // function to getMedian
    public static double getMedian()
    {
        // add your code here
        if(maxHeap.size()<minHeap.size()){
            return minHeap.peek();
        }else if(maxHeap.size()>minHeap.size()){
            return maxHeap.peek();
        }else {
            return (double)(minHeap.peek()+maxHeap.peek())/2;
        }
    }

}
