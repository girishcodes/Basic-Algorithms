package basics;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeSortJava {
    public static void mergeSort(List<Integer> nums) {
        if(nums.size() != 1) {
            LinkedList<Integer> left = new LinkedList<>();
            LinkedList<Integer> right = new LinkedList<>();
            boolean toggle = true;

            while (!nums.isEmpty()){
                if (toggle) {
                    left.add(nums.get(0));
                    nums.remove(0);
                }
                else {
                    right.add(nums.get(0));
                    nums.remove(0);
                }
                toggle = !toggle;
            }
            mergeSort(left);
            mergeSort(right);
            nums.addAll(mergeList(left, right));
        }
    }

    private static Collection<Integer> mergeList(LinkedList<Integer> left, LinkedList<Integer> right) {
        ArrayList<Integer> result = new ArrayList<>();
        while (!left.isEmpty() && !right.isEmpty()){
            if (left.peek() <= right.peek()) {
                result.add(left.pop());
            } else {
                result.add(right.pop());
            }
        }
        result.addAll(left);
        result.addAll(right);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(IntStream
                .of(34, 12, 4, 98, 2, 24).boxed().collect(Collectors.toList()));
        mergeSort(nums);
        System.out.println(nums);
    }
}
