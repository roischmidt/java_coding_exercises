import java.util.Stack;

/**
 *  Given a binary search tree, print out the elements of the tree in order without
 * using recursion
 *
 *               5
 *            2     7
 *          1  3   6  8
 *              4
 *    printTree(tree)
 *           1
 *           2
 *           3
 *           4
 *           5
 *           6
 *           7
 *           8
 */
public class InorderTraversal {

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

    /**
     * non recursive - solution
     */
    public static void printTree(Node node) {
        Stack<Node> nodes = new Stack<>();
        addLeftLeaf(nodes,node);
        while(nodes.size() != 0) {
            Node n = nodes.pop();
            System.out.println(n.value);
            if(n.right != null) {
                addLeftLeaf(nodes,n.right);
            }
        }
    }

    private static void addLeftLeaf(Stack<Node> stack, Node n) {
        while(n != null) {
            stack.push(n);
            n = n.left;
        }
    }

    /**
     * recursive solution - not relevant for the question
     */

    public static void printTreeRec(Node node) {
        if(node == null)
            return;
        printTreeRec(node.left);
        System.out.println(node.value);
        printTreeRec(node.right);
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

        two.left = one;
        two.right = three;
        seven.left = six;
        seven.right = eight;
        five.left = two;
        three.right = four;
        five.right = seven;
        printTree(five);
        System.out.println("*****************");
        printTreeRec(five);
    }

}
