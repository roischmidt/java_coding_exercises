import java.util.LinkedList;
import java.util.Queue;

/**
 *  Implement a LIFO stack with basic functionality (push and pop) using FIFO
 * queues to store the data.
 */
public class StackFromQueues {

    static Queue<Integer> queueA = new LinkedList<>();
    static Queue<Integer> queueB = new LinkedList<>();

    public static void push(Integer  i) {
        if (queueA.size() > 0) {
            queueA.add(i);
        } else {
            queueB.add(i);
        }
    }

    public static Integer pop() {
        Queue<Integer> fullQueue = queueA.size() > 0 ? queueA : queueB;
        Queue<Integer> emptyQueue = queueA.size() > 0 ? queueB : queueA;
        int fullQueueSize = fullQueue.size();
        for(int i = 0; i < fullQueueSize - 1; i ++){
            emptyQueue.add(fullQueue.poll());
        }
        return fullQueue.poll();
    }

    public static void main(String[] args) {
        StackFromQueues.push(10);
        StackFromQueues.push(20);
        System.out.println(StackFromQueues.pop());
        StackFromQueues.push(30);
        StackFromQueues.push(40);
        System.out.println(StackFromQueues.pop());
        System.out.println(StackFromQueues.pop());
        System.out.println(StackFromQueues.pop());
        System.out.println(StackFromQueues.pop());
        StackFromQueues.push(15);
        StackFromQueues.push(30);
        StackFromQueues.push(40);
        System.out.println(StackFromQueues.pop());
        System.out.println(StackFromQueues.pop());
        System.out.println(StackFromQueues.pop());
    }

}
