import java.util.ArrayList;
import java.util.List;

/**
 * Given two strings s1 and s2, combine the characters in the strings and maintain the sequence of characters
 * Follow-up: If s1 has a length of m and s2 has a length of n,
 * how many ways the strings could be merged. Figure out the formula F(m, n) = ?
 */
public class DoubleStringSequenceQuestion {
    public static void main(String[] args) {
        String s1 = "main"; //"abc";
        String s2 = "view"; //"de";

        List<String> res = new ArrayList<>();
        mergeStrings(s1, s2, 0, 0, "", res);

        System.out.println("Number of combinations: " + res.size());
        for (String s : res) {
            System.out.println(s);
        }
    }

    private static void mergeStrings(String s1, String s2, int pos1, int pos2, String curr, List<String> res) {
        if (pos1 == s1.length()) {
            res.add(curr + s2.substring(pos2));
            return;
        }

        if (pos2 == s2.length()) {
            res.add(curr + s1.substring(pos1));
            return;
        }
        mergeStrings(s1, s2, pos1 + 1, pos2, curr + s1.charAt(pos1), res);
        mergeStrings(s1, s2, pos1, pos2+1, curr + s2.charAt(pos2), res);
    }

}
