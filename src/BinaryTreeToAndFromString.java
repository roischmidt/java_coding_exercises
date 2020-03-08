import java.util.ArrayList;
import java.util.Arrays;

/**
 * represent binary tree as string. construct binary tree from string
 */
public class BinaryTreeToAndFromString {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }

    private static Node[] binaryTreeToArray(Node node,int idx, Node[] tree) {
        if(idx >= tree.length)
            return tree;
        tree[idx] = node;
        if(node != null) {
            binaryTreeToArray(node.left,idx*2 + 1, tree);
            binaryTreeToArray(node.right, idx*2 + 2,tree);
        }
        return tree;
    }

    private static int binaryTreeSize(Node node, ArrayList<Node> tree) {
        if(node == null)
            return tree.size();
        tree.add(node);
        binaryTreeSize(node.left,tree);
        binaryTreeSize(node.right,tree);
        return tree.size();
    }

    private static Node arrayToBinaryTree(Node[] tree,int idx){
        if(idx*2 + 2 >= tree.length)
            return tree[idx];
        Node node = tree[idx];
        node.left = arrayToBinaryTree(tree,idx*2 + 1);
        node.right = arrayToBinaryTree(tree,idx*2 + 2);
        return node;
    }

    private static String arrayToString(Node[] nodes) {
        return Arrays.toString(nodes);
    }

    private static Node[] stringToArray(String tree) {
        // [1, 2, 3, 4, 5, 6, 7] -> 1,2,3,4,5,6,7
        String formatted = tree.substring(1,tree.length() - 1).replaceAll("\\s+","");
        return Arrays.stream(formatted.split(","))
                .map(valueStr -> new Node(Integer.parseInt(valueStr), null, null)).toArray(Node[]::new);
    }

    public static void main(String[] args) {
        Node four = new Node(4, null, null);
        Node six = new Node(6, null, null);
        Node seven = new Node(7, null, null);
        Node three = new Node(3, six, seven);
        Node five = new Node(5, null, null);
        Node two = new Node(2, four, five);
        Node root1 = new Node(1, two, three);
        int treeSize = binaryTreeSize(root1,new ArrayList<>());
        Node[] arr = binaryTreeToArray(root1,0,new Node[treeSize]);
        String arrStr = arrayToString(arr);
        System.out.println(arrStr);
        Node[] newTree = stringToArray(arrStr);
        Node newTreeRoot = arrayToBinaryTree(newTree,0);
        System.out.println(newTreeRoot.value);
    }
}
