package problems.staticArrays;

import java.util.*;

public class TopKMostFrequentItems {

    static ArrayList<Integer> find_top_k_frequent_elements(ArrayList<Integer> arr, Integer k) {
        // Write your code here.
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> countNums = new HashMap<>();

        for(Integer num : arr) {
            countNums.put(num, countNums.getOrDefault(num, 0) + 1);
        }

        TreeMap<Integer, Set<Integer>> freq = new TreeMap<>();
        for(int num : arr) {
            int count = countNums.get(num);
            Set<Integer> items = freq.getOrDefault(count, new HashSet<>());
            items.add(num);
            freq.put(count, items);
        }
        for(int count : freq.descendingKeySet()) {
            if(k == 0) break;
            Set<Integer> items = freq.get(count);
            for(int num : items) {
                if(k == 0) break;
                result.add(num);
                k--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> results = find_top_k_frequent_elements(new ArrayList<>(Arrays.asList(4,4,3,5,5,1)), 2);
        System.out.println(results);
    }
}
