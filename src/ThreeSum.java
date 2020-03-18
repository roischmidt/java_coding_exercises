import java.util.*;
import java.util.stream.Collectors;

/**
 *  Given a list of integers, write a function that returns all sets of 3 numbers in
 * the list, a, b, and c, so that a + b + c == 0.
 *
 * threeSum({-1, 0, 1, 2, -1, -4})
 * [-1, -1, 2]
 * [-1, 0, 1]
 */
public class ThreeSum {

    public static Set<List<Integer>> threeSum(List<Integer> ls, int x, int y, int z, Set<List<Integer>> res) {
        if(x >= ls.size())
            return res;
        if(y >= ls.size() || z >= ls.size())
            return threeSum(ls,x+1,x+2,x+3,res);
        if(ls.get(x) + ls.get(y) + ls.get(z) == 0) {
            List<Integer> threeList = Arrays.asList(ls.get(x), ls.get(y), ls.get(z)).stream().sorted().collect(Collectors.toList());
            res.add(threeList);

        }
        threeSum(ls,x,y+1,z+1,res);
        return res;
    }

    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(-1, 0, 1, 2, -1, -4);
        Set<List<Integer>> ret = threeSum(ls,0,1,2, new HashSet<>());
        System.out.println(ret);
    }

}
