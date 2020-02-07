import java.util.Arrays;

/**
 *  Find the median of two sorted arrays.
 *  arr1 = [1, 3, 5]
 *  arr2 = [2, 4, 6]
 *  median(arr1, arr2) = 3.5
 */
public class MedianOfArrays {

    public double median(int[] arr1,int[] arr2) {
        int[] arr = concatArrays(arr1,arr2);
        return median(arr);
    }

    private int[] concatArrays(int[] arr1,int[] arr2) {
        if(arr1.length == 0 || arr1.length != arr2.length)
            throw new IllegalArgumentException("array sizes not equal");
        int[] newArray = new int[arr1.length*2];
        boolean arr1End = false,arr2End = false;
        for(int i = 0,l = 0,r = 0; i < newArray.length; i++){
            if(!arr1End && arr1[l] < arr2[r]){
                newArray[i] = arr1[l];
                if(l < arr1.length - 1)
                    l++;
                else
                    arr1End = true;
            }else if(!arr2End){
                newArray[i] = arr2[r];
                if(r < arr2.length - 1)
                    r++;
                else
                    arr2End = true;
            }

        }
        return newArray;
    }

    private double median(int[] arr) {
        if(arr.length == 0)
            throw new IllegalArgumentException("array is empty");
        if(arr.length == 1) {
            return arr[0];
        }
        if(arr.length % 2 != 0) {
            return arr[arr.length/2];
        } else {
            return ((double)arr[(arr.length - 1)/2] + (double)arr[arr.length/2]) / 2;
        }
    }


    public static void main(String[] args) {
        MedianOfArrays medianOfArrays = new MedianOfArrays();
        int[] arr1 = {1,3,5};
        int[] arr2 = {2,4,6};
        int[] arr = medianOfArrays.concatArrays(arr1,arr2);
        System.out.println("median(arr1, arr2) = 3.5 " + (medianOfArrays.median(arr1,arr2) == 3.5)); // 3.5
        int[] arr3 = {11,34,122,344,555};
        int[] arr4 = {26,47,600,700,800};
        System.out.println("median(arr3, arr4) = 233.0 " + (medianOfArrays.median(arr3,arr4) == 233.0)); // 233.0
    }
}
