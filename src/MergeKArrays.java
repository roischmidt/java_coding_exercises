import java.util.Arrays;

/**
 * Given k sorted arrays, merge them into a single sorted array.
 * <p>
 * merge({{1, 4, 7},{2, 5, 8},{3, 6, 9}}) = {1, 2, 3, 4, 5, 6, 7, 8, 9}
 */
public class MergeKArrays {

    static int[] merge(int[][] arrays) {
        int mergedArraySize = 0;
        for (int[] arr : arrays)
            mergedArraySize += arr.length;
        int[] mergedArray = new int[mergedArraySize];
        int[] arrayIndexArr = new int[arrays.length];
        int arrNumWithSmallestValue = 0;
        for (int j = 0; j < mergedArray.length; j++) {
            int minVal = Integer.MAX_VALUE;
            for (int i = 0; i < arrays.length; i++) {
                int idx = arrayIndexArr[i];
                if (idx < arrays[i].length) {
                    if (arrays[i][idx] < minVal) {
                        minVal = arrays[i][idx];
                        arrNumWithSmallestValue = i;
                    }
                }
            }
            mergedArray[j] = minVal;
            arrayIndexArr[arrNumWithSmallestValue]++;
        }
        return mergedArray;
    }


    public static void main(String[] args) {
        int[][] arrays = {{1, 4, 7,20}, {2, 5, 8,11,19}, {3, 6, 9}};
        System.out.println(Arrays.toString(merge(arrays)));
    }
}
