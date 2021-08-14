import java.util.Arrays;

public class MergeSort {
    private static void mergeList(int[] nums, int start, int mid, int end) {
        int[] left = Arrays.copyOfRange(nums, start, mid + 1);
        int[] right = Arrays.copyOfRange(nums, mid + 1, end + 1);
        int lLen = left.length;
        int rLen = right.length;
        int l = 0, r = 0;

        int i = start;
        while (l < lLen && r < rLen) {
            if (left[l] <= right[r]) nums[i++] = left[l++];
            else nums[i++] = right[r++];
        }
        while (l < lLen) nums[i++] = left[l++];
        while (r < rLen) nums[i++] = right[r++];
    }

    private static void mergeSortHelper(int[] nums, int start, int end) {
        if (start >= end) return;

        int mid = start + (end - start) / 2;
        mergeSortHelper(nums, start, mid);
        mergeSortHelper(nums, mid + 1, end);

        mergeList(nums, start, mid, end);
    }

    private static void mergeSort(int[] nums) {
        mergeSortHelper(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {34, 12, 4, 98, 2, 24};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
