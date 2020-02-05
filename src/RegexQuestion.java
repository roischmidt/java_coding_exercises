/**
 * The wildcard regex can include the characters * and + .
 *
 * ‘+’ – matches any single character or empty character!
 *
 * ‘*’ – Matches any sequence of characters (including the empty sequence) For example,
 *
 * Text = "baaabab":
 *
 * regex = "ba*a++", output : true
 *
 * regex = "ba*a+", output : true
 *
 * regex = "a*ab", output : false
 *
 * //empty string
 *
 * Text=""
 *
 * Regex= "+" , output : true
 */
public class RegexQuestion {

    public static void main(String[] args){
        System.out.println(isRegexValid("baaabab", "ba*a++"));
        System.out.println(isRegexValid("baaabab", "ba*a+"));
        System.out.println(isRegexValid("baaabab", "a*ab"));
        System.out.println(isRegexValid("", "+"));
    }

    public static boolean isRegexValid(String text,String regex){
       if(regex == null)
           return false;
        char[] regexChars = regex.toCharArray();
        if(text == null || text.length() == 0){
            for(int i = 0; i < regexChars.length; i++)
                if(regexChars[i] != '*' && regexChars[i] != '+') return false;
            return true;
        }
        char[] seq = text.toCharArray();
        boolean isWildCardExists = false;
        for(int i = 0,j = 0; i < seq.length && j < regexChars.length; i++){
            if(seq[i] == regexChars[j]) {
                isWildCardExists = false;
                j++;
                continue;
            } else
            if(regexChars[j] == '+') {
                j++;
                continue;
            } else
            if(isWildCardExists) {
               continue;
            } else
            if(regexChars[j] == '*'){
                isWildCardExists = true;
                j++;
                continue;
            } else
                return false;
        }
        return true;
    }
}
