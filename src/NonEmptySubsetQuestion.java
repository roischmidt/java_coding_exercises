import java.util.*;

/**
 * // For a given vector of integers and integer K, find the number of non-empty subsets S
 * such that min(S) + max(S) <= K
 * // For example, for K = 8 and vector [2, 4, 5, 7], the solution is 5 ([2], [4], [2, 4], [2, 4, 5], [2, 5])
 * The time complexity should be O(n2). Approach and code was asked
 */

public class NonEmptySubsetQuestion {

    static public Set<Set<Integer>> getSubsets(int[] arr,int k){
        Set<Set<Integer>> set = new HashSet<>();

        for(int i = 0; i < arr.length; i++) {
            TreeSet<Integer> s =new TreeSet<>();
            for(int j =0 ; j < arr.length; j++){
                if(arr[i] + arr[j] <= k){
                   TreeSet<Integer> s2 =new TreeSet<>();
                   s2.add(arr[i]);
                   s2.add(arr[j]);
                   set.add(s2);
                   s.add(arr[j]);
                }
            }
            for(int h = 0; h < s.size(); h++) {
                set.add(s.tailSet(h));
            }

        }
        return set;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 7};
        System.out.println(getSubsets(arr,8));
    }

}
