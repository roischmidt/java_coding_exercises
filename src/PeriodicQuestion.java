import java.util.HashSet;
import java.util.Set;

/**
 * Find whether string S is periodic.  Periodic indicates S = nP. 
 *  e.g.  S = "ababab", then n = 3, and P = "ab" 
 *  S = "xxxxxx", then n = 1, and P = "x" 
 *  S = "aabbaaabba", then n = 2, and P = "aabba"   
 * Given string S, find out the P (repetitive pattern) of S.
 *
 *
 * Solution:
 * run on string from length to 0 and create substrings in size of length/i and add them to set
 * if set size is 1 means we have repeated substrings - good
 */
public class PeriodicQuestion {

    public static class Periodic {
        private int recurrences;
        private String pattern;
        public Periodic(int rec,String pt) {
            recurrences = rec;
            pattern = pt;
        }

        public String getPattern(){return pattern;}
        public int getRecurrences(){return recurrences;}
    }

    public static Periodic check(String s) {
        Set<String> mset = new HashSet<String>();
        for (int i = s.length(); i > 0; i--) {
            if(s.length() % i != 0)
                continue;
            int w = s.length() / i;
            int pt = w;
            for(int j = 0,h=0; j < i; j++,h+=w) {
                mset.add(s.substring(j*w, pt));
                pt+= w;
            }
            if(mset.size() == 1)
                return new Periodic(i,s.substring(0,w));
            mset.clear();
        }
        return null;
    }

    public static void main(String [ ] args){
        Periodic res = check("ababab");
        System.out.println(res);
    }
}
