import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * balance a binary tree - make it binary search tree
 *
 *               1
 *            2    3
 *          4  5 6  7
 *
 *      to:
 *
 *               4
 *            2    6
 *          1  3 5  7
 */
public class BinaryTreeToBinarySearchTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static class ENodeComparator implements Comparator<Node> {

        @Override
        public int compare(Node node1, Node node2) {
            return node1.value - node2.value;
        }
    }

    public static Node balanceTree(Node node) {
        int treeSize = binaryTreeSize(node,new ArrayList<>());
        Node[] nodes = binaryTreeToArray(node,0,new Node[treeSize]);
        Arrays.sort(nodes,new ENodeComparator());
        return sortedListToBST(nodes, 0,nodes.length - 1);
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
    private static int binaryTreeSize(Node node,ArrayList<Node> tree) {
        if(node == null)
            return tree.size();
        tree.add(node);
        binaryTreeSize(node.left,tree);
        binaryTreeSize(node.right,tree);
        return tree.size();
    }

    private static Node sortedListToBST(Node[] nodes,int start, int end) {
        if(start > end)
            return null;

        int mid = (start + end)/2;
        Node root = nodes[mid];

        root.left  = sortedListToBST(nodes, start, mid-1);
        root.right = sortedListToBST(nodes, mid+1, end);

        return root;
    }


    public static void main(String[] args) {
        Node four = new Node(4, null, null);
        Node six = new Node(6, null, null);
        Node seven = new Node(7, null, null);
        Node three = new Node(3, six, seven);
        Node five = new Node(5, null, null);
        Node two = new Node(2, four, five);
        Node root1 = new Node(1, two, three);
        Node tree = balanceTree(root1);
        System.out.println(tree);
    }
}
