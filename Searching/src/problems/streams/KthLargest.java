package problems.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargest {
    public static List<Integer> kthLargest(int k, List<Integer> initial_stream,
                                            List<Integer> append_stream) {
        List<Integer> results = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);

        for (int num : initial_stream) pq.offer(num);

        if (append_stream == null || append_stream.size() == 0) {
            while (pq.size() > k) {
                pq.poll();
            }
            if(pq.size() == k) {
                results.add(pq.peek());
            }
        }


        for (int num : append_stream) {
            // add the item. If there are more than k items in pq remove.
            pq.offer(num);
            while (pq.size() > k) {
                pq.poll();
            }
            if(pq.size() == k) {
                results.add(pq.peek());
            }
        }
        return results;
    }

    public static void main(String[] args) {
        List<Integer> result = kthLargest(2, Arrays.asList(4, 6), Arrays.asList(5, 2, 20));
        System.out.println(result.toString());

        System.out.println(kthLargest(3, Arrays.asList(4, 6), Arrays.asList()));
    }
}
