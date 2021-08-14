import java.util.Arrays;

public class BubbleSort {

    private static void swap(int[] nums, int j, int i) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /***
     * Repeat n times the following.
     * From right to left of the array swap the smaller element to the left.
     *
     * Performs (n-1)+(n-2)+(n-3)+ ..+1+0 comparisons = n^2/2.
     * And (n-1)+(n-2)+(n-3)+ ..+1+0 swaps when array is reverse sorted.
     *
     * @param nums The input array of unsorted numbers.
     */
    public static void bubbleSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) swap(nums, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {34, 12, 4, 98, 2, 24};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
