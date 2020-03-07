import java.util.ArrayList;
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

    public static Node balanceTree(Node tree) {
        List<Node> nodes = binaryTreeToList(tree,new ArrayList<>());
        List<Node> sortedNodeList = nodes.stream().sorted(Comparator.comparingInt(x -> x.value)).collect(Collectors.toList());
        return sortedListToBST(sortedNodeList, 0,nodes.size() - 1);
    }

    private static List<Node> binaryTreeToList(Node node, ArrayList<Node> ls) {
        if(node == null)
            return ls;
        ls.add(node);
        binaryTreeToList(node.left,ls);
        binaryTreeToList(node.right,ls);
        return ls;
    }

    private static Node sortedListToBST(List<Node> nodes,int start, int end) {
        if(start > end)
            return null;

        int mid = (start + end)/2;
        Node root = nodes.get(mid);

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
        System.out.println(balanceTree(root1));
    }
}
