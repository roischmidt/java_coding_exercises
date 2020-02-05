/**
 * Given a dictionary of words & a miss-spelled input,
 * write a function which will find 3 words from the dictionary which are closest
 * (by difference of 1-character) to the given input.
 *
 * eg - dict = {vil, sit, flick, pat, pluck, sat, vat}, input = vit, ans = {sit, vil, vat}
 */

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import static java.util.stream.Collectors.toCollection;
public class DictionaryQuestion {

    static class Dictionary  {

        private static int compare(String a, String b)
        {
            if(a.length() > b.length() + 1 || a.length() < b.length())
                return -1;
            int match = 0;
            for(int i = 0; i < a.length(); i++) {
                if(a.charAt(i) == b.charAt(i)) {
                    match ++;
                    continue;
                }
            }
            return match;

        }

        public static Set<String> findSimillar(String a, Set<String> s) {
            Set<String> set = new TreeSet<>();
            for(String m : s) {
                int match = compare(a,m);
                if(match == a.length()) {
                    set.clear();
                    set.add(a);
                    return set;
                }
                if(match == a.length() - 1)
                    set.add(m);
            }
            if(set.size() > 0) {
                return set.stream()
                        .limit(3)
                        .collect(toCollection(LinkedHashSet::new));
            }
            return set;
        }
    }


    public static void main(String args[]) {
        Set<String> set = new HashSet<>();
        set.add("vil");set.add("sit");set.add("flick");set.add("pat");set.add("pluck");set.add("sat");set.add("vat");
        System.out.println(Dictionary.findSimillar("sot",set));
    }
}
