import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeMap;

public class BucketSort {
    private static int length(int num) {
        int len = (int) Math.log10(num) + 1;
        return len;
    }

    private static void bucketSort(int[] nums) {
        int len = nums.length;
        TreeMap<Integer, LinkedList<Integer>> bucket = new TreeMap();
        for (int num : nums) {
            int bucketIndex = length(num);
            LinkedList<Integer> list = bucket.getOrDefault(bucketIndex, new LinkedList<>());
            list.add(num);
            bucket.put(bucketIndex, list);
        }
        int index = 0;
        //List<Integer> numLengths = bucket.keySet().stream().sorted().collect(Collectors.toList());
        for (int numLength : bucket.keySet()) {
            LinkedList<Integer> list = bucket.get(numLength);
            Collections.sort(list);
            for (Integer num : list) {
                nums[index++] = num;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {34, 12, 4, 98, 2, 24};
        bucketSort(nums);
        System.out.println(Arrays.toString(nums));

        int[] items100 = Utility.generateRandomArrayOfN(100, 1000000);
        bucketSort(items100);
        Utility.isSortedAsc(items100);
        Utility.print(items100);
    }
}
