/**
 * given a sorted array, write a function that returns true if a given value exists there
 *
 * isExists([1,3,5,8,9] , 3) = true
 */
public class IsNumberExists {

    public static boolean isExists(int[] arr, int value){
        return isExistsRec(arr,0,arr.length - 1,value);
    }

    /**
     * like binary search, always cut by 2
     * O(logN) solution
    */
    private static boolean isExistsRec(int[] arr, int l, int r, int value) {
        if( r == arr.length || l < 0)
            return false;
        if(l == r)
            return arr[r] == value;
        int m = (r+l)/2;
        if(arr[m] == value)
            return true;
        if(arr[m] > value)
            return isExistsRec(arr,l,m - 1,value);
        return isExistsRec(arr,m + 1,r,value);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println("4 should be found in [1,2,3,4,5,6,7,8,9] :" + isExists(arr,4)  );
    }
}
