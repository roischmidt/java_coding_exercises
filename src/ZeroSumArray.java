import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array, write a function to find any subarray that sums to zero, if one
 * exists.
 * <p>
 * zeroSum({1, 2, -5, 1, 2, -1}) = [2, -5, 1, 2]
 */
public class ZeroSumArray {

    static int[] zeroSum(int[] arr) {
        return zeroSumRec(arr, 0, 0);
    }

    static int[] zeroSumRec(int[] arr, int startIdx, int endIdx) {
        if (endIdx == arr.length)
            return new int[0];
        if (startIdx > endIdx)
            return zeroSumRec(arr, 0, endIdx + 1);
        else {
            int sum = 0;
            int[] ret = new int[endIdx - startIdx + 1];
            for (int i = startIdx, j = 0; i <= endIdx; i++, j++) {
                sum += arr[i];
                ret[j] = arr[i];
            }
            if (sum == 0)
                return ret;
            return zeroSumRec(arr, startIdx + 1, endIdx);
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 2, -5, 1, 2, -1};
        System.out.println(Arrays.toString(zeroSum(input)));
    }
}
