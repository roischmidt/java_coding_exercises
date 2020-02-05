import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a binary tree, output the maximum EVEN sum along any path
 *       10
 *      /    \
 *     2      5
 *    /  \      \
 *   1   101    13
 * Maximum even sum = 101 +2 +10 + 5 = 118
 */
public class MaximumEvenSumOPAthInfBinaryTreeQuestion {

    static class Node{
        public int data;
        public Node left;
        public Node right;
        public Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main (String[] args) {
        Node n101 = new Node(101,null,null);
        Node n1 = new Node(1,null,null);
        Node n13 = new Node(13,null,null);
        Node n2 = new Node(2,n1,n101);
        Node n5 = new Node(5,null,n13);
        Node head = new Node(10,n2,n5);
        System.out.println(findMaxEvenPath(head));
    }

    public static int findMaxEvenPathRec(Node node, Map<Integer,Integer> parents, List<Integer> endsLeft,List<Integer> endsRight,boolean isLeft) {
        if(node == null){
            return 0;
        }
        int n = node.data;
        Node left = node.left;
        Node right = node.right;
        boolean isHead = parents.isEmpty();
        if(left != null)
            parents.put(node.left.data,n);
        if(right != null)
            parents.put(node.right.data,n);
        if(isHead) { //head
            return findMaxEvenPathRec(left,parents,endsLeft,endsRight,true) + n +  findMaxEvenPathRec(right,parents,endsLeft,endsRight,false);

        }
        if(left == null && right == null){
            if(isLeft)
                endsLeft.add(n);
            else
                endsRight.add(n);
        }
        return findMaxEvenPathRec(left,parents,endsLeft,endsRight,isLeft) + n +  findMaxEvenPathRec(right,parents,endsLeft,endsRight,isLeft);

    }

    public static int findMaxEvenPath(Node node) {
        Map<Integer,Integer> parents = new HashMap<>();
        List<Integer> endsLeft = new ArrayList<>();
        List<Integer> endsRight = new ArrayList<>();
        int ret = findMaxEvenPathRec(node,parents,endsLeft,endsRight,false);

        return ret;
    }

}
