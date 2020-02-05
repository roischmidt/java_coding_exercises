import java.util.*;

/**
 * Given an array of Integers, find out how many combinations in the array, satisfy the equation x+y+z=w,
 * where x,y,z and w belong to the array and idx(x)<idx(y)<idx(z)<idx(w). Elements are unique.
 */
public class SumCombinationsQuestions {

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,10,11,34,14,4,4,15};
        int [] set = {1,2,3,4,5,6,10,9,7,7};
        Set<Set<Integer>> res = getAllSumCombinations(set,new LinkedList<>(),set.length,4,new HashSet<>());
        System.out.println(res.size());
    }

    static Set<Set<Integer>>  getAllSumCombinations(int[] set,
                                   List<Integer> kList,
                                   int n, int k,Set<Set<Integer>> masterSet)
    {

        // Base case: k is 0,
        // print prefix
        if (k == 0)
        {
            // now get list of integers, make a sorted set from them (reduce duplicates) and make sure
            // they follow w<x<y<z uniques
            SortedSet<Integer> s = new TreeSet<>();
            s.addAll(kList);
            if(s.size() == kList.size()){
                int sum = s.stream().limit(kList.size() - 1).mapToInt(Integer::intValue).sum();
                if(sum == s.last())
                    masterSet.add(s); // master set to reduce duplicate lists (1,2,3,6) : (1,3,2,6)

            }
            return masterSet;
        }
        // One by one add all integers
        // from set and recursively
        // call for k equals to k-1
        for (int i = 0; i < n; ++i)
        {

            // Next integer of input added
            kList.add(set[i]);

            // k is decreased, because
            // we have added a new integer
            masterSet = getAllSumCombinations(set, kList,
                    n, k - 1,masterSet);
            kList.remove(kList.size()-1);
        }
        return masterSet;
    }
}
