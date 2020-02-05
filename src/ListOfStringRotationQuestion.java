import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an array of strings. For example, ["AB", "BC", "FOO", "ZA", "BAZ"]
 * - Output strings where you can get from one to the other using any ROT transformation.
 *
 * ROT_1(AB) = BC
 * ROT_1(BC) = CD
 * ROT_25(AB) = ZA
 * AB,BC you can go from one to the other using ROT_1
 * Input: list of strings
 * Output: strings where you can get from one to the other using any ROT transformation.
 * Example:
 * Input : ["AB", "BC", "FOO", "ZA", "BAZ"]
 * Output: [ [ab, bc] , [ab, za] ]
 * AB,BC because you can go from one to the other using ROT_1
 * AB,ZA because you can go from one to the other using ROT_25
 * Do not return FOO, BAZ you can’t get from one to the other.
 */
public class ListOfStringRotationQuestion {

    public static void main(String[] args){
        System.out.println(getRotArrays(Arrays.asList("AB", "BC", "FOO", "ZA", "BAZ")));
    }


    public static List<List<String>> getRotArrays(List<String> words) {
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < words.size(); i ++){
            for(int j = i + 1; j < words.size(); j++){
                if(isRotOf(words.get(i),words.get(j)))
                    res.add(Arrays.asList(words.get(i),words.get(j)));
            }
        }
        return res;
    }

    private static boolean isRotOf(String aStr,String bStr) {

        if(aStr.length() != bStr.length() || aStr.equals(bStr))
            return false;
        if(aStr.length() == 1)
            return true;
        char[]  aArr = aStr.toLowerCase().toCharArray();
        char[]  bArr = bStr.toLowerCase().toCharArray();
        char a0 = aArr[0];
        char b0 = bArr[0];
        int deltaPlus = a0 < b0 ?  b0 - a0 : ('z' - a0) + (b0 - 'a' + 1);
        for(int i = 1; i < aArr.length; i ++) {
            char ai = aArr[i];
            char bi = bArr[i];
            int delta = ai < bi ?  bi - ai : ('z' - ai) + (bi - 'a' + 1);

            if(delta != deltaPlus )
                return false;
        }
        return true;
    }

}
