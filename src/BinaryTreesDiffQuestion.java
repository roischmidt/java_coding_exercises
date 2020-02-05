import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two binary trees, explain how you would create a diff
 * such that if you have that diff and either of the trees you should be able to generate the other binary tree.
 * Implement a function which takes Node tree1, Node tree2 and returns that diff.
 */
public class BinaryTreesDiffQuestion {

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

    public static int[] BstToArray(Node node,int[] arr,int idx){
        if(node == null)
            return arr;
        arr[idx] = node.data;
        arr = BstToArray(node.left,arr,idx*2 + 1);
        arr = BstToArray(node.right,arr,idx*2 + 2);
        return arr;
    }

    public static int[] getDiffFromBinaryTrees(int[] tree1,int[] tree2){
        int t1Len =  tree1.length ;
        int t2Len = tree2.length;
        int LargerTreeSize = Math.max(t1Len, t2Len);
        int[] merged = new int[LargerTreeSize];
        for(int i = 0; i < merged.length; i++){
            int a = t1Len > i ? tree1[i] : 0;
            int b = t2Len > i ? tree2[i] : 0;
            merged[i] = a + b;
        }
        return merged;
    }

    public static int[] getBstArrayFromDiffAndBst( int[] diff, int[] tree) {
        int res[] = new int[diff.length];
        for(int i = 0; i < diff.length; i ++){
            int a = tree.length > i ? tree[i] : 0;
            res[i] = diff[i] - a;
        }
        return res;
    }

    public static Node ArrToBst(int[] arr) {
        Map<Integer,Node> helperMap = new HashMap<>();
        for(int i = 0; i < arr.length; i ++){
            Node cur = new Node(arr[i],null,null);
            helperMap.put(arr[i],cur);
            if(i > 0) {

                if(i % 2 == 0){
                    int fatherIdx = arr[(i-2) / 2];
                    Node father = helperMap.get(fatherIdx);
                    father.right = cur;
                    helperMap.put(fatherIdx,father);
                } else {
                    int fatherIdx = arr[(i-1) / 2];
                    Node father = helperMap.get(fatherIdx);
                    father.left = cur;
                    helperMap.put(fatherIdx,father);
                }

            }
        }
        return helperMap.get(arr[0]);
    }

    public static void main(String[] args){
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

        int arr1[] = new int[100];
        int arr2[] = new int[100];
        arr1 = BstToArray(root1,arr1,0);
        arr2 = BstToArray(root2,arr2,0);
        int diff[] = getDiffFromBinaryTrees(arr1,arr2);

        System.out.println(Arrays.toString(getBstArrayFromDiffAndBst(diff, arr1)));
        System.out.println(Arrays.toString(getBstArrayFromDiffAndBst(diff, arr2)));
        Node r1 = ArrToBst(getBstArrayFromDiffAndBst(diff,arr1));

        System.out.println(r1);

    }

}
