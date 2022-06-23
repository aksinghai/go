package all.company.com.common;

import java.util.ArrayList;
import java.util.List;


public class LLUtils {

    public static ListNode getLinkedList(int n){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(i+1);
        }
        return getLinkedList(list);
    }

    public static ListNode getLinkedList(List<Integer> list) {
        ListNode head = null;
        ListNode tail = null;
        for (Integer integer : list) {
            ListNode node = new ListNode();
            node.val = integer;
            if (head == null) {
                head = node;
                tail = head;
            } else {
                tail.next = node;
                tail = tail.next;
            }
        }
        return head;
    }

    public static void printLinkedList(ListNode head){
        System.out.println("LINKED LIST");
        while (head != null){
            if(head.next != null){
                System.out.print(head.val+"->");
            } else {
                System.out.print(head.val);
            }
            head = head.next;
        }
        System.out.println();
    }

}
