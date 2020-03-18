import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Given a tree, write a function that prints out the nodes of the tree in level
 * order.
 *
 * e.g
 *
 *               5
 *            2    7
 *          1  3 6  8
 *
 *      5,2,7,1,3,6,8
 *
 *               5
 *            2    7
 *          1  3 6  4
 *
 *     5,2,7,1,3,6,4
 *
 *               5
 *            2    8
 *          1  7 6  9
 *
 *    5,2,8,1,7,6,9
 */
public class TreeLevelOrder {

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

    public static LinkedHashMap<Integer, List<Integer>> traverse(Node node, int depth, LinkedHashMap<Integer,List<Integer>> depthMap) {
        if(node == null)
            return depthMap;
        List<Integer> ls = depthMap.get(depth);
        if(ls == null) {
            ls = new ArrayList<>();
        }
        ls.add(node.value);
        depthMap.put(depth,ls);
        traverse(node.left,depth + 1,depthMap);
        return traverse(node.right,depth + 1,depthMap);
    }

    public static void printTree(LinkedHashMap<Integer, List<Integer>> tree) {
        for(int i = 0 ; i < tree.size(); i++){
            for(Integer n : tree.get(i))
                System.out.print(n + ",");
        }
        System.out.println();
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
        five.right = seven;
        printTree(traverse(five, 0, new LinkedHashMap<>()));
        seven.right = four;
        printTree(traverse(five, 0, new LinkedHashMap<>()));
        Node nine = new Node(9);
        two.right = seven;
        seven.right = null;
        seven.left = null;
        five.right = eight;
        eight.left = six;
        eight.right = nine;
        printTree(traverse(five, 0, new LinkedHashMap<>()));
    }
}
