import java.util.*;

/**
 * Given a directed graph, find the shortest path between two nodes if one
 * exists.
 *
 *  1 -------->  2
 *  ^  |         |
 *  |   |>       |
 *  |     3      |      (1,4) both points to 3
 *  |   |>       |
 *  |  |         v
 *  4 <--------  5
 * shortestPath(2, 3) = 2 -> 5 -> 4 -> 3
 */
public class ShortestPath {

    static class Node{
        int id;
        List<Node> children;

        public Node(int id) {
            this.id = id;
        }
    }

    public static ArrayList<Integer> shortestPath(Node a, Node b) {
        return shortestPathRec(a,b,new LinkedHashSet<>(),new ArrayList<>());
    }

    public static ArrayList<Integer> shortestPathRec(Node a, Node b,LinkedHashSet<Integer> visited ,ArrayList<ArrayList<Integer>> paths) {
        ArrayList<Integer> path = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if(!visited.contains(a.id)) {
            queue.add(a);
        }
        while(!queue.isEmpty()){
            Node n = queue.remove();
            path.add(n.id);
            visited.add(n.id);
            if(n.id == b.id) {
                break;
            }
            if(n.children.size() == 1)
                queue.addAll(n.children);
            else {

                for (Node child : n.children) {
                    if(!visited.contains(child.id)) {
                        paths.add(shortestPathRec(child, b,visited,paths));
                    }
                }
            }
        }
        int minSize = Integer.MAX_VALUE;
        int minPathIdx = 0;
       for(int i = 0; i < paths.size(); i++)
           if(paths.get(i).size() < minSize) {
               minSize = paths.get(i).size();
               minPathIdx = i;
           }
        if(paths.size() > minPathIdx)
            path.addAll(paths.get(minPathIdx));
       return path;
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        one.children = Arrays.asList(two,three);
        two.children = Arrays.asList(five);
        five.children = Arrays.asList(four);
        four.children = Arrays.asList(one,three);
        three.children = new ArrayList<>();
        System.out.println(Arrays.deepToString(shortestPath(two,three).toArray()));
    }
}
