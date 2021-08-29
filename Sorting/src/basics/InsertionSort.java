package basics;

import java.util.Arrays;

public class InsertionSort {
    private static void swap(int[] nums, int j, int i) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void insertionSortIterativeSwap(int[] nums) {
        int len = nums.length;
        if (len <= 0) return;

        for (int i = 1; i < len; i++) {
            int j = i - 1;
            while(j >= 0 && nums[j] > nums[i]) {
                swap(nums, j, i);
                i = j;
                j--;
            }
        }
    }

    public static void insertionSortIterativeMove(int[] nums) {
        int len = nums.length;
        if (len <= 0) return;

        for (int i = 1; i < len; i++) {
            int iTh = nums[i];
            int j = i - 1;
            while(j >= 0 && nums[j] > iTh) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = iTh;
        }
    }

    public static void insertionSort(int[] nums) {
        int len = nums.length;
        insertionSortMoveRecursive(nums, len);
    }

    private static void insertionSortMoveRecursive(int[] nums, int n) {
        if(n <= 0) return;
        insertionSortMoveRecursive(nums, n - 1);

        // assume all but the last item aka nums[n - 1] is sorted.
        // compare nums[n - 1] with all items to it's left and place it in the right place.
        int iTh = nums[n - 1];
        int j = n - 2;
        while(j >= 0 && nums[j] > iTh) {
            // keep moving nums[j] to the right until you find the right place for iTh item.
            nums[j + 1] = nums[j];
            j--;
        }
        nums[j + 1] = iTh;
    }

    private static void insertionSort2(int[] nums) {
        int len = nums.length;
        insertionSortSwapRecursive(nums, len);
    }

    private static void insertionSortSwapRecursive(int[] nums, int n) {
        if(n <= 0) return;
        insertionSortSwapRecursive(nums, n - 1);

        // assume all but the last item aka nums[n - 1] is sorted.
        // compare nums[n - 1] with all items to it's left and place it in the right place.
        int i = n - 1;
        int j = n - 2;
        while (j >= 0 && nums[j] > nums[i] ) {
            swap(nums, j, i);
            i = j;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {34, 12, 4, 98, 2, 24};
        insertionSortIterativeMove(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = {34, 12, 4, 98, 2, 24};
        insertionSortIterativeSwap(nums2);
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = {34, 12, 4, 98, 2, 24};
        insertionSort(nums3);
        System.out.println(Arrays.toString(nums3));

        int[] nums4 = {34, 12, 4, 98, 2, 24};
        insertionSort2(nums4);
        System.out.println(Arrays.toString(nums4));
    }
}
