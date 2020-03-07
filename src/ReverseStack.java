import java.util.Stack;

/**
 * Given a stack, reverse the items without creating any additional data
 * structures.
 *
 * reverse(1->2->3) = 3->2->1
 */
public class ReverseStack {

    public static Stack<Integer> reverse(Stack<Integer> stack,int idx) {
        if(idx == 0) {
            stack.clear();
            return stack;
        };
        Integer n = stack.elementAt(stack.size() - idx);
        stack = reverse(stack,idx - 1);
        stack.push(n);
        return stack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println(stack + " ---> ");
        System.out.println(reverse(stack,stack.size()));
    }
}
