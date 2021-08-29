package basics;

public class HeapSort {


    public static class BinaryMaxHeap {
        // KISS - using int array of size 10
        final static int size = 10;
        int[] nums = new int[size + 1];
        int index = 0;

        boolean checkFull() {
            if (index == nums.length - 1) {
                System.out.println("Full..");
                return true;
            }
            return false;
        }

        public void insert(int num) {
            if (checkFull()) return;
            nums[++index] = num;
            swim(index);
        }

        private void swap(int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        private void swim(int idx) {
            while (idx > 1 && nums[idx] > nums[idx / 2]) {
                swap(idx, idx / 2);
                idx = idx / 2;
            }
        }

        public boolean isEmpty() {
            if (index == 0) {
                System.out.println("Empty..");
                return true;
            }
            return false;
        }

        public int deleteMax() {
            // KISS - returning -1
            if (isEmpty()) return -1;
            int max = nums[1];
            nums[1] = nums[index];
            sink(1);
            index--;
            return max;
        }

        private void sink(int idx) {
            while (2 * idx <= index) {
                int childIdx = 2 * idx; // left child
                // if item at left child is smaller than item at right child, use right
                if (childIdx + 1 <= index && nums[childIdx] < nums[childIdx + 1]) childIdx++;
                // item at parent has higher value than it's children.
                if (nums[idx] > nums[childIdx]) break;
                swap(idx, childIdx);
                idx = childIdx;
            }
        }

        public void heapify(int[] arr) {
            // KISS
            nums = arr;
            index = arr.length - 1;
            for (int idx = index; idx > 1; idx--) {
                swim(idx);
            }

            int idx = index;
            while (idx > 1) {
                swap(1, idx);
                sink(1);
                idx--;
            }
        }
    }

    public static void main(String[] args) {
        BinaryMaxHeap maxHeap = new BinaryMaxHeap();
        int[] nums = {5, 10, 4, 8, 6, 3, 7, 2, 9, 1, 11};
        for (int num : nums) {
            maxHeap.insert(num);
        }
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.deleteMax() + " ");
        }
        System.out.println("\n");

        BinaryMaxHeap maxHeap2 = new BinaryMaxHeap();
        int[] nums2 = {0, 5, 10, 4, 8, 1, 6, 3, 7, 2, 9};
        maxHeap2.heapify(nums2);
        while (!maxHeap2.isEmpty()) {
            System.out.print(maxHeap2.deleteMax() + " ");
        }
    }
}
