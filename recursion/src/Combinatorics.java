public class Combinatorics {
    // Rule of Sum : Action of picking only ONE from EITHER X options OR Y options can be done in X+Y ways.
    // Rule of Product: Action of picking ONE from X options AND ONE from Y options can be done in  X*Y ways.

    // Permutation : Repetition not allowed.
    // Eg: Arrange 4 different characters A,B,C,D in a straight line.
    // - First place in 4 ways, Second in 3 ways,... = 4! ways.
    public static int permute(int n) {
        return (n == 0) ? 1 : n * permute(n - 1);
    }

    public static int permuteIter(int n) {
        int result = 1;
        for (int num = 1; num <= n; num++) {
            result = result * num;
        }

        return result;
    }


    // Arrangements: Repetitions are allowed.
    // Eg: 1) Number of 4 digit passcodes = 4^4.
    // 2) Binary strings of length n. = 2^n
    // 3) All subsets of a,b = {}, {a}, {b}, {a,b}, {b,a} = 2^n
    // 4) Subsets of a set of size n - a,b,c,d,e, subset of size 4.
    // at each position we have 2 choices - either to include the item (say) or not to include the item
    public static int arrangement(int n, int pow) {
        if (pow == 0) return 1;
        return n * arrangement(n, pow - 1);
    }

    public static int arrangementIter(int n, int pow) {
        int result = 1;
        for (int power = 1; power <= pow; power++) {
            result = result * n;
        }
        return result;
    }

    public static int subset(int size) {
        if (size == 0) return 1;
        else {
            return 2 * subset(size - 1);
        }
    }


}
