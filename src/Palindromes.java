import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Given a linked list, write a function to determine whether the list is a palindrome.
 *
 *  eg.
 * palindrome(1 -> 2 -> 3) = false
 * palindrome(1 -> 2 -> 1) = true
 */
public class Palindromes {

    public static boolean palindrome(LinkedList<Integer> list) {
        int[] arr = new int[list.size()];
        ListIterator<Integer> it = list.listIterator(0);
        int i = 0;
        while(it.hasNext()){
            arr[i] = it.next();
            i++;
        }
        for(int j = 0; j < list.size(); j++) {
            if(arr[j] != arr[list.size() - 1 - j])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList<Integer> ls = new LinkedList<>();
        ls.addAll(Arrays.asList(1,2,3));
        System.out.println(!palindrome(ls));
        ls.clear();
        ls.addAll(Arrays.asList(1,2,1));
        System.out.println(palindrome(ls));
        ls.clear();
        ls.addAll(Arrays.asList(10,20,30,40,50,40,30,20,1));
        System.out.println(!palindrome(ls));
    }

}
