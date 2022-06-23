package all.company.com.experiment;

import java.util.Stack;
import all.company.com.common.LLUtils;
import all.company.com.common.ListNode;


public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode list = LLUtils.getLinkedList(5);
        LLUtils.printLinkedList(list);
        ListNode head = reverseLinkedListUsingIteration(list);
        LLUtils.printLinkedList(head);
    }

    private static ListNode reverseLinkedListUsingRecursion(final ListNode head) {
        if(head.next == null){
            return head;
        }
        ListNode node = reverseLinkedListUsingRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    private static ListNode reverseLinkedListUsingIteration(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode tail = null;
        while (!stack.isEmpty()){
            ListNode node = stack.pop();
            if(head == null){
                head = node;
                tail = head;
                tail.next = null;
            } else {
                tail.next = node;
                tail = tail.next;
                tail.next = null;
            }
        }
        return head;
    }
}
