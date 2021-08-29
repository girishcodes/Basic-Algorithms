import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Fibonnaci {

    /***
     *
     * Time Complexity : O(1.4^n) to O(2^n)
     */
    public static int fibN(int n) {
        if (n == 0 || n == 1) return n;
        return fibN(n - 1) + fibN(n - 2);
    }

    public static int fibNIter(int n) {
        int prev = 0, current = 1;
        if (n == 0 || n == 1) return n;
        for (int i = 1; i < n; i++) {
            int t = current;
            current = prev + current;
            prev = t;
        }
        return current;
    }

    public static int fibNMemo(int n) {
        if (n == 0 || n == 1) return n;
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        return fibNMemo(n, memo);
    }

    private static int fibNMemo(int n, int[] memo) {
        if (n == 0 || n == 1) return n;
        if (memo[n] != 0) return memo[n];
        else {
            memo[n] = fibNMemo(n - 1, memo) + fibNMemo(n - 2, memo);
            return memo[n];
        }

    }

    public static int addSeq(int n, int prev, int current) {
        if (n == 0) return prev;
        else {
            return Math.max(current, addSeq(n - 1, current, prev + current));
        }
    }

    public static void main(String[] args) {
        List<Integer> integers = IntStream.range(0, 46).boxed().collect(Collectors.toList());
        for (int num : integers) {
            //System.out.println("Fib of " + num + " : " + fibN(num));
            System.out.println("Fib of " + num + " : " + fibNIter(num));
            System.out.println("Fib of " + num + " : " + fibNMemo(num));
            System.out.println("Fib of " + num + " : " + addSeq(num, 0, 1));
        }

    }
}
