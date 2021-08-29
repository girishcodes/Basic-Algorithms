package basics;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountingSort {
    private static void countingSortUnstableArrayLookup(int[] nums, int range) {
        int[] lookup = new int[range + 1];
        for (int num : nums) {
            lookup[num]++;
        }

        int index = 0;
        for (int i = 0; i < lookup.length; i++) {
            for (int j = 0; j < lookup[i]; j++) {
                nums[index++] = i;
            }
        }
    }

    private static void countingSortUnstableMapLookup(int[] nums) {
        Map<Integer, Integer> lookup = new HashMap<>();
        for (int num : nums) {
            lookup.put(num, lookup.getOrDefault(num, 0) + 1);
        }

        int index = 0;
        List<Integer> keys = lookup.keySet().stream().sorted().collect(Collectors.toList());
        for (Integer key : keys) {
            for (int j = 0; j < lookup.get(key); j++) {
                nums[index++] = key;
            }
        }
    }

    private static void countingSortStableArrayLookup(int[] nums, int range) {
        LinkedList<Integer>[] lookup = new LinkedList[range + 1];
        for (int num : nums) {
            if (lookup[num] == null) lookup[num] = new LinkedList<>();
            lookup[num].add(num);
        }

        int index = 0;
        for (int i = 0; i < lookup.length; i++) {
            if (lookup[i] != null) {
                for (int j = 0; j < lookup[i].size(); j++) {
                    nums[index++] = lookup[i].get(j);
                }
            }
        }
    }

    private static <T> void countingSortStableMapLookup(T[] items) {
        TreeMap<T, LinkedList<T>> lookup = new TreeMap<>();
        for (T item : items) {
            LinkedList<T> itemList = lookup.getOrDefault(item, new LinkedList<>());
            itemList.add(item);
            lookup.put(item, itemList);
        }

        int index = 0;
        for (Map.Entry<T, LinkedList<T>> entry : lookup.entrySet()) {
            for (int j = 0; j < entry.getValue().size(); j++) {
                items[index++] = entry.getValue().get(j);
            }
        }
    }

    public static void main(String[] args) {
        int rangeOfNumbers = 9;
        int[] nums1 = {4, 5, 2, 6, 9, 8, 3, 8, 2, 1, 7, 6, 1};
        int[] nums2 = Arrays.copyOf(nums1, nums1.length);
        int[] nums3 = Arrays.copyOf(nums1, nums1.length);
        int[] nums4 = Arrays.copyOf(nums1, nums1.length);

        countingSortStableArrayLookup(nums1, 9);
        System.out.println(Arrays.toString(nums1));
        countingSortUnstableArrayLookup(nums2, 9);
        System.out.println(Arrays.toString(nums2));
        countingSortStableMapLookup(IntStream.of(nums3).boxed().toArray(Integer[]::new));
        System.out.println(Arrays.toString(nums3));
        countingSortUnstableMapLookup(nums4);
        System.out.println(Arrays.toString(nums4));

        Student[] students = {new Student(5, "John"), new Student(3, "Zoe"),
                new Student(5, "Abe"), new Student(3, "Ria")};
        Student[] students1 = Arrays.copyOf(students, students.length);

        countingSortStableMapLookup(students1);
        System.out.println(Arrays.toString(students1));
    }

    public static class Student implements Comparable<Student> {
        private final Integer standard;
        private final String name;
        public Student(Integer standard, String name) {
            this.standard = standard;
            this.name = name;
        }

        @Override
        public int compareTo(Student o) {
            return this.standard.compareTo(o.standard);
        }

        @Override
        public String toString() {
            return "Student{" + "standard=" + standard + ", name='" + name + '\'' + '}';
        }
    }
}
