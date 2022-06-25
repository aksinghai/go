package all.company.com.experiment;

import java.util.Stack;
import all.company.com.common.LLUtils;
import all.company.com.common.ListNode;


public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode<Integer> list = LLUtils.getLinkedList(5);
        LLUtils.printLinkedList(list);
        ListNode<Integer> head = reverseLinkedListUsingIteration(list);
        LLUtils.printLinkedList(head);
    }

    private static ListNode<Integer> reverseLinkedListUsingRecursion(final ListNode<Integer> head) {
        if(head.getNext() == null){
            return head;
        }
        ListNode<Integer> node = reverseLinkedListUsingRecursion(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return node;
    }

    private static ListNode<Integer> reverseLinkedListUsingIteration(ListNode<Integer> head) {
        if(head == null || head.getNext() == null){
            return head;
        }
        Stack<ListNode<Integer>> stack = new Stack<>();
        while(head != null){
            stack.push(head);
            head = head.getNext();
        }
        ListNode<Integer> tail = null;
        while (!stack.isEmpty()){
            ListNode<Integer> node = stack.pop();
            if(head == null){
                head = node;
                tail = head;
                tail.setNext(null);
            } else {
                tail.setNext(node);
                tail = tail.getNext();
                tail.setNext(null);
            }
        }
        return head;
    }
}
