import java.util.Arrays;

/**
 * Given an unsorted array, find the length of the longest sequence of
 * consecutive numbers in the array.
 * <p>
 * consecutive([4, 2, 1, 6, 5]) = 3, [4, 5, 6]
 * consecutive([5, 5, 3, 1]) = 1, [1], [3], or [5]
 */
public class ConsecutiveArray {

    public static int consecutive(int[] arr) {
        Arrays.sort(arr);
        int sum = arr.length > 0 ? 1 : 0;
        int max = sum;
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i+1] - arr[i] == 1) {
                sum += 1;
                max = Math.max(max,sum);
            } else {
                sum = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 6, 5};
        System.out.println("{4, 2, 1, 6, 5} = 3 : " + (ConsecutiveArray.consecutive(arr) == 3) );
        int[] arr2 = {5, 5, 3, 1};
        System.out.println("{5, 5, 3, 1} = 1 : " + (ConsecutiveArray.consecutive(arr2) == 1) );
    }
}
