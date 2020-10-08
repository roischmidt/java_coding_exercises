/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Note:
 * Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: x = -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: x = 120
 * Output: 21
 * Example 4:
 * <p>
 * Input: x = 0
 * Output: 0
 */
public class ReverseInteger {
    // max int = 2,147,483,647
    static int[] mulArr = {1000000000, 100000000, 10000000, 1000000, 100000, 10000, 1000, 100, 10,1};

    public static void main(String[] args) {
        System.out.println(reverse(-2143847412));
    }

    public static int reverse(int x) {
        int[] resArr = new int[10];
        int resIdx = 0;
        int modified = x;
        boolean isNumberStarted = false;
        for (int i = 0; i < mulArr.length; i++) {
            int lo = modified % mulArr[i] ;
            if (lo == modified) {
                if(isNumberStarted){
                    resArr[resIdx] = 0;
                    resIdx++;
                }
                continue;
            }
            isNumberStarted = true;
            int div = modified / mulArr[i];
            modified = lo;
            resArr[resIdx] = div;
            resIdx++;
        }
        int res = resArr[0];
        for(int j = 1; j < resArr.length; j++){
            if(j == resArr.length-1 && resArr[j]!=0){
                if(res < 0){
                    if (resArr[j] < -2 || Integer.MIN_VALUE - res > mulArr[mulArr.length - 1 - j] * resArr[j])
                        return 0;
                } else {
                    if (resArr[j] > 2 || Integer.MAX_VALUE - res < mulArr[mulArr.length - 1 - j] * resArr[j]) // max int
                        return 0;
                }
            }
            res += mulArr[mulArr.length -1 - j] * resArr[j];
        }
        return res;
    }
}
