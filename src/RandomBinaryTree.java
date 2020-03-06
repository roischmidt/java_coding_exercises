import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Implement a binary tree with a method getRandomNode() that returns a
 * random node
 *
 * getRandomNode() = 5
 * getRandomNode() = 8
 * getRandomNode() = 1
 */
public class RandomBinaryTree {

    public static class Node {
        public int id;
        public Node left;
        public Node right;
        public Node(int id,Node left,Node right) {
            this.id = id;
            this.left = left;
            this.right = right;
        }
    }

    public static Node getRandomNode(Node root) {
        List<Node> tree = binaryTreeToList(root,new ArrayList<>());
        int rand = new Random().nextInt(tree.size());
        // filter nulls in tree list and get the random Node
        return tree.stream().filter(Objects::nonNull).collect(Collectors.toList()).get(rand);
    }

    private static List<Node> binaryTreeToList(Node node, ArrayList<Node> ls) {
        if(node == null)
            return ls;
        ls.add(node);
        binaryTreeToList(node.left,ls);
        binaryTreeToList(node.right,ls);
        return ls;
    }

    public static void main(String[] args) {
        Node one = new Node(1,null,null);
        Node four = new Node(4,null,null);
        Node three = new Node(3,one,four);
        Node seven = new Node(7,null,null);
        Node root1 = new Node(5,three,seven);

        Node one2 = new Node(1,null,null);
        Node three2 = new Node(3,null,null);
        Node second = new Node(2,one2,three2);
        Node five2 = new Node(5,null,null);
        Node root2 = new Node(4,second,five2);

        System.out.println(RandomBinaryTree.getRandomNode(root1).id);
        System.out.println(RandomBinaryTree.getRandomNode(root2).id);
    }

}
