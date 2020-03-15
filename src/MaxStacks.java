/**
 * Implement a LIFO stack that has a push(), pop(), and max() function,
 * where max() returns the maximum value in the stack. All of these functions should run in O(1) time.
 * eg.
 * push(1)
 * max() = 1
 * push(2)
 * max() = 2
 * push(1)
 * max() = 2
 * pop() = 1
 * max() = 2
 * pop() = 2
 * max() = 1
 */
public class MaxStacks {

    class Node {
        int value;
        public Node prev, next;

        public Node(int value) {
            this.value = value;
            prev = null;
            next = null;
        }
    }

    int maxValue, prevMaxValue = 0;
    Node last = null;

    public void push(int i) {
        if (i > maxValue) {
            prevMaxValue = maxValue;
            maxValue = i;
        }
        if (last == null) {
            last = new Node(i);
            return;
        }
        Node newNode = new Node(i);
        last.next = newNode;
        newNode.prev = last;
        last = newNode;
    }

    public Integer pop() {
        if (last == null)
            return null;
        if (last.value == maxValue)
            maxValue = prevMaxValue;
        Node newLast = last.prev;
        int res = last.value;
        last = newLast;
        last.next = null;
        return res;
    }

    public int max() {
        return maxValue;
    }

    public static void main(String[] args) {
        MaxStacks ms = new MaxStacks();
        ms.push(1);
        System.out.println(ms.max() == 1);
        ms.push(2);
        System.out.println(ms.max() == 2);
        ms.push(1);
        System.out.println(ms.max() == 2);
        System.out.println(ms.pop() == 1);
        System.out.println(ms.max() == 2);
        System.out.println(ms.pop() == 2);
        System.out.println(ms.max() == 1);
    }
}
