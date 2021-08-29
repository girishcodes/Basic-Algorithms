import java.util.Arrays;
import java.util.LinkedList;

public class CombinatorialEnumerationBinaryStrings {

    private static LinkedList<String> allPossibleBinaryStringofLen3() {
        LinkedList<String> result = new LinkedList<>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    String binaryStr = Integer.toString(i) + j + k;
                    result.add(binaryStr);
                }
            }
        }
        return result;
    }

    private static LinkedList<String> allPossibleBinaryStringWithRepOfLenN(int n) {
        if (n == 1) return new LinkedList<>(Arrays.asList("0", "1"));
        LinkedList<String> result = new LinkedList<>();
        LinkedList<String> prevResult = allPossibleBinaryStringWithRepOfLenN(n - 1);
        for (String binaryString : prevResult) {
            result.add(binaryString + "0");
            result.add(binaryString + "1");
        }
        return result;
    }

    private static LinkedList<String> allPossibleBinaryStringWithRepOfLenNIter(int n) {
        LinkedList<String> result = new LinkedList<>(Arrays.asList("0", "1"));
        for (int i = 2; i <= n; i++) {
            LinkedList<String> newResult = new LinkedList<>();
            for (String binaryString : result) {
                newResult.add(binaryString + "0");
                newResult.add(binaryString + "1");
            }
            result = newResult;
        }

        return result;
    }

    private static void binaryStringWithRepDFS(int n) {
        bsHelper(n, "");
    }

    private static void bsHelper(int n, String s) {
        if (n == 0) System.out.println(s);
        else {
            bsHelper(n - 1, s + "0");
            bsHelper(n - 1, s + "1");
        }
    }

    private static void decimalStringWithRepDFS(int n) {
        dsHelper(n, "");
    }

    private static void dsHelper(int n, String s) {
        if (n == 0) System.out.println(s);
        else {
            for (int i = 0; i < 10; i++)
                dsHelper(n - 1, s + i);
        }
    }

    private static void permutationsDFS(String s) {
        pHelper("", s);
    }

    private static void pHelper(String slate, String s) {
        if (s.isEmpty()) {
            System.out.println(slate);
        } else {
            for (int i = 0; i < s.length(); i++) {
                pHelper(slate + s.charAt(i), s.substring(0, i) + s.substring(i + 1));
            }
        }
    }

    private static void combinationsDFS(String s) {
        cHelper("", s);
    }

    private static void cHelper(String slate, String s) {
        if (s.isEmpty()) {
            System.out.println("{" + slate + "}");
        } else {
            char ch = s.charAt(0);
            cHelper(slate + ch, s.substring(1));
            cHelper(slate, s.substring(1));
        }
    }

    public static void main(String[] args) {
        //System.out.println(allPossibleBinaryStringofLen3());
        System.out.println(allPossibleBinaryStringWithRepOfLenN(3));
        System.out.println(allPossibleBinaryStringWithRepOfLenNIter(3));
        binaryStringWithRepDFS(3);
        decimalStringWithRepDFS(3);
        permutationsDFS("ABC");
        combinationsDFS("1234");
    }
}
