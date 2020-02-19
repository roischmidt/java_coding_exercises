import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Find Duplicates
 * Given an array of integers where each value 1 <= x <= len(array), write a
 * function that finds all the duplicates in the array.
 *
 * dups([1, 2, 3]) = []
 * dups([1, 2, 2]) = [2]
 * dups([3, 3, 3]) = [3]
 * dups([2, 1, 2, 1]) = [1, 2]
 */
public class FindDuplicates {

    public static int[] dups(int[] arr) {
        int[] dupArr = new int[arr.length + 1];
        List<Integer> resList = new LinkedList<>();
        for(int i = 0; i < arr.length; i++) {
            if(dupArr[arr[i]] == 1) {
                resList.add(arr[i]);
                dupArr[arr[i]] = -1;
            }
            else if(dupArr[arr[i]] != -1 && dupArr[arr[i]] < 2)
                dupArr[arr[i]] += 1;

        }
        return resList.stream().mapToInt(i->i).sorted().toArray();
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 1};
        System.out.println(Arrays.toString(dups(arr)));
    }
}
