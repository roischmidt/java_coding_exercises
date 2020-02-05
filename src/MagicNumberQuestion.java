/**
 * Write a function that takes a magic number and a list of numbers.
 * It returns true if it can insert add or subtract operations in the list of numbers to get the magic number.
 * Otherwise, it returns false.
 */
public class MagicNumberQuestion {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2};
        System.out.println(isMagicNumber(arr, 0, -5));
        int[] arr2 = {1, 2, 3, 4};
        System.out.println(isMagicNumber(arr2, 0, 8));
        int[] arr3 = {9, 1, 10};
        System.out.println(isMagicNumber(arr3, 0, 11));
        System.out.println(isMagicNumber(arr3, 0, 12));
    }

    static boolean isMagicNumber(int[] arr, int i, int k) {
        if (i >= arr.length && k != 0)
            return false;

        if (k == 0)
            return true;

        return isMagicNumber(arr, i + 1, k)
                || isMagicNumber(arr, i + 1, k - arr[i])
                || isMagicNumber(arr, i + 1, k + arr[i]);
    }
}
