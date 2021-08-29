package problems.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MedianOfStream {

    /***
     *
     * In order to calculate median the array has to be sorted. With streaming data, the array keeps changing.
     *
     * Method1:
     * Insertion Sort: When new data comes in, insert it in the right location.
     *
     * Method2: To keep the array sorted on insertion we can partition the array into two halves.
     * minHeap stores the right half and returns the minimum on it's side.
     * maxHeap stores the left half and returns the maximum on it's side.
     * Time Complexity: O(logN)
     * Space Complexity: O(N)
     */

    public static List<Integer> onlineMedian(List<Integer> stream) {
        List<Integer> results = new ArrayList<>();
        // To keep the array sorted on insertion we can partition the array into two halves.
        // minHeap stores the right half and returns the minimum on it's side.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // maxHeap stores the left half and returns the maximum on it's side.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, Collections.reverseOrder());

        for(int num : stream) {
            addNum(num, maxHeap, minHeap);
            Integer median = calculateMedian(maxHeap, minHeap);
            results.add(median);
        }
        return results;
    }

    private static void addNum(Integer num, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if(minHeap.isEmpty() || num >= minHeap.peek()) minHeap.offer(num);
        else maxHeap.offer(num);

        if(minHeap.size() > maxHeap.size() + 1) maxHeap.offer(minHeap.poll());
        else if(maxHeap.size() > minHeap.size()) minHeap.offer(maxHeap.poll());
    }

    private static Integer calculateMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if(maxHeap.size() == minHeap.size()) return (maxHeap.peek() + minHeap.peek()) / 2;
        else if(maxHeap.size() > minHeap.size()) return maxHeap.peek() / 1;
        else return minHeap.peek() / 1;
    }
}
