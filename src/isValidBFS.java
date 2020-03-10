/**
 * Given a binary tree, write a function to test if the tree is a binary search tree.
 *
 *      valid:
 *
 *               5
 *            2    7
 *          1  3 6  8
 *
 *      invalid::
 *
 *               5
 *            2    7
 *          1  3 6  4
 *
 *     invalid::
 *
 *               5
 *            2    8
 *          1  7 6  9
 */
public class isValidBFS {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isValidBFS(Node node) {
        if(node == null)
            return true;
        if(node.left != null && node.left.value > node.value)
            return false;
        if(node.right != null && node.right.value < node.value)
            return false;
       return isValidBFS(node.left,node.right);
    }

    private static boolean isValidBFS(Node l, Node r) {
        if(l == null || r == null)
            return true;
        if(l.value > r.value)
            return false;
        return isValidBFS(l.left,l.right) && isValidBFS(l.right,r.left) && isValidBFS(r.left,r.right);
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);

        two.left = one; two.right = three;
        seven.left = six; seven.right = eight;
        five.left = two; five.right = seven;
        boolean isValid = isValidBFS(five);
        System.out.println(isValid);
        seven.right = four;
        isValid = isValidBFS(five);
        System.out.println(isValid);
        Node nine = new Node(9);
        two.right = seven;
        seven.right = null;seven.left = null;
        five.right = eight;
        eight.left = six;
        eight.right = nine;
        isValid = isValidBFS(five);
        System.out.println(isValid);
    }
}
