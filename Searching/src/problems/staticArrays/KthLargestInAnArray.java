package problems.staticArrays;

import java.util.*;

public class KthLargestInAnArray {
    private static final Random rand = new Random();

    /***
     * Solution 1:
     * Quick Select is a version of Quick Sort which exits when Kth item is sorted.
     *
     * If array is {1, 2, 3, 5, 10} 2nd largest will be at 3.
     * => 5 - 3 == 2 => nums.size() - partitionIdx == k
     *
     * Time Complexity : O(n).
     * Space Complexity: O(1).
     */
    public static int kthLargestInAnArray(List<Integer> nums, int k) {
        int left = 0, right = nums.size() - 1;

        while (left <= right) {
            int partitionIdx = partition(nums, left, right);
            // if array is {1, 2, 3, 5, 10} 2nd largest will be at 3.
            // => 5 - 3 == 2
            if (nums.size() - partitionIdx == k) {
                return nums.get(partitionIdx);
            } else if (nums.size() - partitionIdx > k) {
                left = partitionIdx + 1;
            } else {
                right = partitionIdx - 1;
            }
        }

        return -1;
    }

    private static int partition(List<Integer> nums, int l, int r) {
        int pivotIdx = l + rand.nextInt(r - l + 1);
        int pivotNum = nums.get(pivotIdx);
        Collections.swap(nums, pivotIdx, r);

        int smallerPartitionIdx = l;
        for (int iter = l; iter < r; iter++) {
            if (nums.get(iter) < pivotNum) {
                Collections.swap(nums, iter, smallerPartitionIdx);
                smallerPartitionIdx++;
            }
        }
        // smallerPartitionIdx is the final position for pivotNum when array is completely sorted.
        Collections.swap(nums, smallerPartitionIdx, r);

        return smallerPartitionIdx;
    }

    /***
     * Solution 2: Using minHeap when k is small and using maxHeap when k is nearly equal to nums.size()
     * Time Complexity: O(N logK)
     * Space Complexity: O(K)
     */
    public static int kthLargestInAnArray2(List<Integer> nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            while (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        for (int s = 5; s > 0; s--) {
            int kthLargest = kthLargestInAnArray(Arrays.asList(5, 1, 10, 3, 2), s);
            int kthLargest2 = kthLargestInAnArray2(Arrays.asList(5, 1, 10, 3, 2), s);
            System.out.println(s + " : " + kthLargest + " - " + kthLargest2);
        }
    }
}
