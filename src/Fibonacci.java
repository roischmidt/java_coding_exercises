import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer n, write a function to compute the nth Fibonacci number.
 *
 * fibonacci(1) = 1
 * fibonacci(5) = 5
 * fibonacci(10) = 55
 */
public class Fibonacci {

    static Map<Integer,Integer> mem = new HashMap<>();

    public static int fibonacci(int num) {
        if(mem.get(num) != null)
            return mem.get(num);
        if(num <= 1)
            return num;
        int ret = fibonacci(num - 2) + fibonacci(num - 1);
        mem.put(num,ret);
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(10));
    }
}
