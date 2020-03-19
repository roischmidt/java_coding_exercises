import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1,l2,false,new ArrayList<>());
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2, boolean hasRest, List<ListNode> res) {
        if(l1 == null && l2 == null)
            return  res.get(0);
        int leftOver =  hasRest ? 1 : 0;
        int sum = leftOver;
        ListNode l1Next = null;
        ListNode l2Next = null;
        if(l1 == null){
            sum += l2.val;
            l2Next = l2.next;
        }
        else if(l2 == null) {
            sum += l1.val;
            l1Next = l1.next;
        }
        else {
            sum += l1.val + l2.val ;
            l1Next = l1.next;
            l2Next = l2.next;
        }
        boolean rest = sum > 9;
        ListNode l = new ListNode(rest ? 0 : sum );
        if(res.size() >= 1)
            res.get(res.size() -1).next = l;
        res.add(l);
        return addTwoNumbers(l1Next,l2Next,rest,res);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode res = addTwoNumbers(l1,l2);
        System.out.println(res.val + " -> " + res.next.val + " -> " + res.next.next.val);
    }
}
