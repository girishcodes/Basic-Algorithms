import java.util.Arrays;
import java.util.Random;

public class Utility {
    static Random random = new Random();

    public static int [] generateRandomArrayOfN(int n, int bound) {
        int[] items = new int[n];
        for (int i = 0; i < n; i++) {
            items[i] = random.nextInt(bound + 1);
        }
        return items;
    }

    public static int [] generateRandomArrayOfN(int n) {
        return generateRandomArrayOfN(n,100);
    }

    public static void isSortedAsc(int[] items) {
        for (int i = 0; i < items.length - 1; i++) {
            if(items[i] > items[i+1]) {
                System.out.println("Array is not sorted.");
                return;
            }
        }
        System.out.println("Array is sorted.");
    }

    public static void print(int[] items) {
        System.out.println(Arrays.toString(items));
    }

    public static void main(String[] args) {
        generateRandomArrayOfN(100);
        System.out.println(Arrays.toString(generateRandomArrayOfN(30)));
    }

}
