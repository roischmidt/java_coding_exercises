public class Assertion {

    public static void assertion(boolean condition)
    {
        if(!condition)
            throw new AssertionError("Assertion failed");
    }
}
