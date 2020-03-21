/**
 *  Given a string, write a function to compress it by shortening every sequence
 * of the same character to that character followed by the number of repetitions. If the
 * compressed string is longer than the original, you should return the original string.
 *
 * compress("a") = "a"
 * compress("aaa") = "a3"
 * compress("aaabbb") = "a3b3"
 * compress("aaabccc") = "a3b1c3"
 */
public class StringCompression {

    public static String compress(String str) {
        return compress(str,1,new StringBuffer(),1);
    }

    private static String compress(String str,int idx, StringBuffer sb,int lastLetterCount) {
        if(idx > str.length()) {
            String res = sb.toString();
            return res.length() > str.length() ? str : res;
        }
       if(idx < str.length() && str.charAt(idx) == str.charAt(idx-1)){
           return compress(str,idx+1,sb,lastLetterCount+1);
       }
       sb.append(str.charAt(idx-1)).append(lastLetterCount);
       return compress(str,idx+1,sb,1);
    }

    public static void main(String[] args) {
        System.out.println(compress("a"));
        System.out.println(compress("aaa"));
        System.out.println(compress("aaabbb"));
        System.out.println(compress("aaabccc"));
    }

}
