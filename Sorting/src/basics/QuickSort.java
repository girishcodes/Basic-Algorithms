package basics;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    private static void quickSort(int[] items) {
        quickSortHelper(items, 0, items.length - 1);
    }

    private static int lomutoPartitioning(int[] items, int start, int end) {
        // Divide using Lomuto partitioning.
        int randomPivot = start + (int) (Math.random() * (end - start + 1));
        swap(items, randomPivot, start);
        int pivot = items[start];
        int smallerIdx = start;
        for (int biggerIdx = start + 1; biggerIdx <= end; biggerIdx++) {
            if (items[biggerIdx] < pivot) {
                smallerIdx++;
                swap(items, biggerIdx, smallerIdx);
            }
        }
        swap(items, smallerIdx, start);
        return smallerIdx;
    }

    private static int hoarePartitioning(int[] items, int start, int end) {
        // Divide using Hoare partitioning.
        int randomPivot = start + (int) (Math.random() * (end - start + 1));
        swap(items, randomPivot, start);
        int pivot = items[start];
        int smallerIdx = start - 1;
        int biggerIdx = end + 1;
        while (true) {
            do {
                smallerIdx++;
            } while (items[smallerIdx] < pivot);
            do {
                biggerIdx--;
            } while (items[biggerIdx] > pivot);
            if (smallerIdx >= biggerIdx) return biggerIdx;
            swap(items, smallerIdx, biggerIdx);
        }

    }

    private static void quickSortHelper(int[] items, int start, int end) {
        if (start >= end) return;

        // Divide
        //int pivotIdx = hoarePartitioning(items, start, end);
        int pivotIdx = lomutoPartitioning(items, start, end);

        // Solve
        quickSortHelper(items, start, pivotIdx);
        quickSortHelper(items, pivotIdx + 1, end);

    }

    private static void swap(int[] items, int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public static void main(String[] args) {
        /*int[] nums = {34, 12, 4, 98, 2, 24};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
        int[] num2 = {85, 61, 44, 47};
        quickSort(num2);
        Utility.isSortedAsc(num2);
        Utility.print(num2);*/
        int[] items100 = Utility.generateRandomArrayOfN(1000);
        quickSort(items100);
        Utility.isSortedAsc(items100);
        Utility.print(items100);
    }

}
