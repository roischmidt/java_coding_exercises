import java.util.*;

/**
 * Suppose you have a list of tasks which need to be executed.
 * Some of these tasks have dependencies which must be executed before they are.
 * Please provide a method which, when given a list of tasks, will provide a valid ordering in return.
 *
 * Example:
 * Input: [ A, B, C, D ]
 * A <- B, C
 * B <- C, D
 * D <- C
 * Return: [ C, D, B, A ]
 */
public class TaskListQuestion {

    public static void main(String[] args){
        ArrayList<Character> tasks = new ArrayList<>();
        tasks.add('a');
        tasks.add('b');
        tasks.add('c');
        tasks.add('d');
        tasks.add('e');
        tasks.add('f');
        tasks.add('g');
        Map<Character, List<Character>> p = new HashMap<>();
        p.put('a',Arrays.asList('b','c'));
        p.put('b',Arrays.asList('c','d'));
        p.put('d',Arrays.asList('c'));
        p.put('g',Arrays.asList('f','b'));
        System.out.println(getTaskByPriorities(tasks,tasks.get(0),0,new LinkedList<>(),p,new HashMap<>()));
    }

    public static List<Character> getTaskByPriorities(ArrayList<Character> tasks,
                                                      Character cur,
                                                      int idx,
                                                      List<Character> res,
                                                      Map<Character, List<Character>> priorityMap,
                                                      Map<Character,Boolean> visited) {
        if(visited.get(cur) != null)
            return res;
        if(idx >= tasks.size()) {
            res.add(cur);
            visited.put(cur,true);
            return res;
        }
        List<Character> priorities = priorityMap.get(cur);
        if(priorities == null || priorities.size() == 0){
            res.add(cur);
            visited.put(cur,true);
            return res;
        }
        for(char cc : priorities) {
            getTaskByPriorities(tasks,cc,res.size(),res,priorityMap,visited);
        }
        if(visited.get(cur) == null) {
            res.add(cur);
            visited.put(cur, true);
        }
        int last = res.size();
        while(last < tasks.size()) {
            getTaskByPriorities(tasks, tasks.get(last), last, res, priorityMap, visited);
            last++;
        }
        return  res;
    }

}
