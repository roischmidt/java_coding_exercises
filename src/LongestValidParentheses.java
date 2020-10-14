import java.util.LinkedList;
import java.util.List;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
 * <p>
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * Example 3:
 * <p>
 * Input: s = ""
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 3 * 104
 * s[i] is '(', or ')'.
 */
public class LongestValidParentheses {

    static class Counter {
        public int length = 0;
        public int count = 0;
        public int lastWellFormedLength = 0;
        public boolean isActive = true; // counter is acvtive until counter reaches -1
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()")); //2
        System.out.println(longestValidParentheses(")()())")); //4
        System.out.println(longestValidParentheses("")); //0
        System.out.println(longestValidParentheses("()")); //2
        System.out.println(longestValidParentheses("((((((((((((((((()")); //2
        System.out.println(longestValidParentheses("((((((((((((((((())))))))))))))))))))))))))")); //34
        System.out.println(longestValidParentheses(")))))))))))))((((((((((((((")); //0
        System.out.println(longestValidParentheses("()(()")); //2
        System.out.println(longestValidParentheses("()()()))((()))()")); //8
        System.out.println(longestValidParentheses("(()(((()")); // 2
        System.out.println(longestValidParentheses("(())("));// 4
    }

    public static int longestValidParentheses(String s) {
        if (s.length() <= 2)
            if (s.equals("()"))
                return 2;
            else return 0;
        List<Counter> counters = new LinkedList<>();
        for (char a : s.toCharArray()) {
            if (a == '(') {
                counters.add(new Counter());
                inc(counters);
            } else if (a == ')') {
                dec(counters);
            }
        }
        int maxCount = 0;
        // iterate all counters and check:
        // if not active - means it was finished so take it's length
        // if still active, check if it's count is 0 - means it's mailformed in it's current state
        for (Counter c : counters) {
            if (!c.isActive || c.count == 0) {
                if (c.length > maxCount)
                    maxCount = c.length;
            } else if(c.lastWellFormedLength > maxCount)
                maxCount = c.lastWellFormedLength;
        }
        return maxCount;
    }

    private static void inc(List<Counter> counters) {
        for (Counter c : counters) {
            if (c.isActive) {
                c.length++;
                c.count++;
            }
        }
    }

    private static void dec(List<Counter> counters) {
        for (Counter c : counters) {
            if (c.isActive) {
                c.length++;
                c.count--;
                if (c.count == -1) {
                    c.length--;
                    c.isActive = false;
                } else if(c.count == 0) c.lastWellFormedLength =  c.length;
            }
        }
    }

}
