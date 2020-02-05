import java.util.Arrays;

/**
 *  Find the median of two sorted arrays.
 *  arr1 = [1, 3, 5]
 *  arr2 = [2, 4, 6]
 *  median(arr1, arr2) = 3.5
 */
public class MedianOfArrays {

    public double median(int[] arr1,int[] arr2) {
        double[] arr = {median(toDoubleArray(arr1)),median(toDoubleArray(arr2))};
        return median(arr);
    }

    public double median(double[] arr) {
        return Arrays.stream(arr).sum() / arr.length;
    }

    private double[] toDoubleArray(int[] arr) {
        return Arrays.stream(arr).asDoubleStream().toArray();
    }


    public static void main(String[] args) {
        MedianOfArrays medianOfArrays = new MedianOfArrays();
        int[] arr1 = {1,3,5};
        int[] arr2 = {2,4,6};
        System.out.println("median(arr1, arr2) = " + medianOfArrays.median(arr1,arr2)); // 3.5
        int[] arr3 = {1,2,2,2,3,5,10};
        int[] arr4 = {2,4,6,7,8,11};
        System.out.println("median(arr3, arr4) = " + medianOfArrays.median(arr3,arr4)); // ~4.9
    }
}
