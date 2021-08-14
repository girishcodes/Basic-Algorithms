import java.util.Arrays;

public class SelectionSort {

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /***
     * At i select the index of ith smallest element in the array
     * by scanning from i+1 to array length and swap it with array[i].
     *
     * Performs (n-1)+(n-2)+(n-3)+ ..+1+0 comparisons = n^2/2.
     * And n exchanges or swaps.
     *
     * @param nums The input array of unsorted numbers.
     */
    public static void selectionSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[minIndex])
                    minIndex = j;
            }
            swap(nums, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int[] nums = {34, 12, 4, 98, 2, 24};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
