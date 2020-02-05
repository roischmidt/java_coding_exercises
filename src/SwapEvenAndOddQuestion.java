/**
 * Given two string check if they can be made equivalent by performing some operations on one or both string.
 *
 * swapEven:swap a character at an even-numbered index with a character at another even-numbered index
 *
 * swapOdd:swap a character at an odd-numbered index with a character at another odd-numbered index
 *
 * Given : s="cdab" , x="abcd"
 * s -> cdab ->swap a and c ->adcb (swapEven)-> swap b and d (swapOdd) -> s="abcd" = x="abcd"
 *
 * Given: s="dcba" , x="abcd"
 * no amount of operation will move character from an odd index to even index, so the two string will never be equals
 *
 * Given: s="abcd" ,x="abcdcd"
 * x length to big so will never be equals
 */
public class SwapEvenAndOddQuestion {

    public static String makeEqual(String a,String b) {
        if (a.length() != b.length())
            return null;
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        String res = b;
        for (int i = 0; i < ac.length; i++) {
            boolean bFound = false;
            for (int j = 0; j < bc.length; j++) {
                if (ac[i] == bc[j]) {
                    String s1 = swapEven(res.toCharArray(), i, j);
                    String s2 = swapOdd(res.toCharArray(), i, j);
                    if (s1 != null || s2 != null) {
                        bFound = true;
                        res = s1 == null ? s2 : s1;
                        break;
                    }
                }
            }
            if (!bFound) {
                return null;
            }

        }
        return res;
    }

    private static String swapEven(char[] arr, int from, int to) {
        if(from % 2 != 0 || to % 2 != 0)
            return null;
        if(from < 0 || from > arr.length || to < 0 || to > arr.length)
            return null;
        char tmp = arr[from];
        arr[from] = arr[to];
        arr[to] = tmp;
        return new String(arr);
    }

    private static String swapOdd(char[] arr, int from, int to) {
        if(from % 2 == 0 || to % 2 == 0)
            return null;
        if(from < 0 || from > arr.length || to < 0 || to > arr.length)
            return null;
        char tmp = arr[from];
        arr[from] = arr[to];
        arr[to] = tmp;
        return new String(arr);
    }

    public static void main(String[] args) {
        String s = makeEqual("aaabbb","ababba");
        System.out.println(s == null ? "NA" : s);
    }
}
