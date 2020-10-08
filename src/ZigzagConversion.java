import java.util.HashMap;
import java.util.Map;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 *
 * Input: s = "A", numRows = 1
 * Output: "A"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 */
public class ZigzagConversion {

    public static void main(String[] args) {
        ZigzagConversion zigzagConversion = new ZigzagConversion();
        String res = zigzagConversion.convert("PAYPALISHIRING", 4);
        assert (res.equals("PINALSIGYAHRPI"));
        System.out.println(res);
        res = zigzagConversion.convert("ABC", 2);
        assert (res.equals("ACB"));
        System.out.println(res);
        System.out.println(zigzagConversion.romanToInt("MDCCCLXXXIV"));
    }

    private Map<String,Integer> rep  = new HashMap<String, Integer>() {{
        put("0",0);
        put("I", 1);
        put("IV", 4);
        put("V", 5);
        put("IX", 9);
        put("X", 10);
        put("XL", 40);
        put("L", 50);
        put("XC", 90);
        put("C", 100);
        put("CD", 400);
        put("D", 500);
        put("CM", 900);
        put("M", 1000);
    }};
    public int romanToInt(String s) {
        int res = 0;
        for(int i = 0; i < s.length();){
            char l = s.charAt(i);
            i++;
            char r = i == s.length() || (!isPrefix(l) && isPrefix(s.charAt(i))) ? '0' : s.charAt(i);
            res += translatePair(l,r);
            if(r != '0') i++;
        }
        return res;
    }

    public int translatePair(char l, char r){
        char pair[] = {l,r};
        String pairStr = new String(pair);
        Integer res = rep.get(pairStr);
        if(res == null){
            res = rep.get(Character.toString(l)) + rep.get(Character.toString(r));
        }
        return res;
    }

    public boolean isPrefix(char c){
        return (c == 'I' || c == 'X' || c == 'C');
    }

    public String convert(String s, int numRows) {
        if(s.length() < 3)
            return s;
        int numOfCols = ((s.length()/numRows) * 2) + 1;
        char[][] rep = new char[numRows][numOfCols];
        int strIdx = 0;
        for(int colIdx = 0; colIdx < numOfCols ; colIdx++){
            if(colIdx % 2 == 0) {
                for(int rowIdx = 0; rowIdx < numRows && strIdx < s.length(); rowIdx++){
                  rep[rowIdx][colIdx] = s.charAt(strIdx);
                  strIdx++;
                }
            } else {
                for(int rowIdx = numRows - 2; rowIdx > 0 && strIdx < s.length(); rowIdx--){
                    rep[rowIdx][colIdx] = s.charAt(strIdx);
                    strIdx++;
                }
            }

        }
        return matrixToStr(rep);
    }


    public String matrixToStr(char[][] matrix) {
        char[] str = new char[matrix.length * matrix[0].length];
        int strIdx = 0;
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if(isValidChar(matrix[i][j])) {
                    str[strIdx] = matrix[i][j];
                    strIdx++;
                }
            }
        }
        return new String(str).trim();
    }

    public boolean isValidChar(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ',' || c == '.';
    }
}
