import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class BinarySearch {

    /***
     * Divide and conquer: At each level the problem is divided into half the original range.
     */
    public static int binarySearch(int[] nums, int num) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l +((r-l) / 2);
            if(nums[mid] == num) return mid;
            if(nums[mid] < num) l = mid + 1;
            else r = mid - 1;
         }
        return -1;
    }

    private static int[] numberGenerator() {
        ArrayList<Integer> numbers = new ArrayList<>();
        int range = (int) (Math.random() * 100);

        for (int i = 0; i < range; i++) {
            numbers.add((int)(Math.random() * 100));
        }
        return numbers.stream().mapToInt(i-> i).toArray();
    }

    public static void main(String[] args) {
        //int[] nums = {87, 34, 5, 23, 93, 10, 77, 62};
        int [] nums = numberGenerator();
        Arrays.sort(nums);
        System.out.println("Sorted array :" + Arrays.toString(nums));
        for (int num: IntStream.range(0,100).toArray()) {
            System.out.println(" Number " + num + " can be found at index : " + binarySearch(nums, num));
        }
    }
}
