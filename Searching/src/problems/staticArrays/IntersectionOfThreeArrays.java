package problems.staticArrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class IntersectionOfThreeArrays {
    /***
     * Since all the N arrays are sorted we can N pointers and move the index of one that has minimum value.
     * When items at all indexes are same we add to the output.
     *
     * Time Complexity: O(N+M+K)
     */
    public static List<Integer> findIntersection(List<Integer> arr1, List<Integer> arr2, List<Integer> arr3) {
        List<Integer> result = new LinkedList<>();
        int l1= arr1.size(), l2 = arr2.size(), l3 = arr3.size();
        int i1 = 0, i2 = 0, i3 = 0;

        while (i1 < l1 && i2 < l2 && i3 < l3) {
            int min1 = Math.min(arr1.get(i1), arr2.get(i2));
            int minAll = Math.min(min1,arr3.get(i3));

            if(arr1.get(i1) == minAll && arr2.get(i2) == minAll && arr3.get(i3) == minAll)
                result.add(minAll);

            if(minAll == arr1.get(i1)) i1++;
            if(minAll == arr2.get(i2)) i2++;
            if(minAll == arr3.get(i3)) i3++;
        }
        return result;
    }

    public static List<Integer> findIntersection2(List<Integer> arr1, List<Integer> arr2, List<Integer> arr3) {
        List<Integer> result12 = findIntersection(arr1, arr2);
        List<Integer> result1123 = findIntersection(result12, arr3);
        return result1123.size() > 0 ? result1123 : Arrays.asList(-1);
    }

    private static List<Integer> findIntersection(List<Integer> nums1, List<Integer> nums2) {
        List<Integer> result = new LinkedList<>();

        if (nums1 == null || nums1.size() == 0 || nums2 == null || nums2.size() == 0) {
            return result;
        }

        if (nums1.size() > nums2.size()) {
            return findIntersection(nums2, nums1);
        }

        int fromIndex = 0, indexFound = -1;
        for (int num : nums1) {
            int startIndex = (indexFound < 0) ? fromIndex : indexFound + 1;
            nums2 = nums2.subList(startIndex, nums2.size());
            indexFound = Collections.binarySearch(nums2, num);
            if (indexFound > -1) {
                result.add(num);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = findIntersection(
                Arrays.asList(30, 30, 30),
                Arrays.asList(10, 30, 30),
                Arrays.asList(10, 20, 30));
        System.out.println("The intersection of 3 lists is : " + result);
    }
}
