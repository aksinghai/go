package all.company.com.common;

import java.util.ArrayList;
import java.util.List;


public class LLUtils<T> {

    public static <T> ListNode<T> getLinkedList(int n){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(i);
        }
        return getLinkedList(list);
    }

    public static <T> ListNode<T> getLinkedList(List<Integer> list) {
        ListNode<T> head = null;
        ListNode<T> tail = null;
        for (Integer integer : list) {
            ListNode<T> node = new ListNode<>();
            node.setItem((T) integer);

            if (head == null) {
                head = node;
                tail = head;
            } else {
                tail.setNext(node);
                tail = tail.getNext();
            }
        }
        return head;
    }

    public static <T> void printLinkedList(ListNode<T> head){
        System.out.println("LINKED LIST");
        while (head != null){
            if(head.getNext() != null){
                System.out.print(head.getItem() +"->");
            } else {
                System.out.print(head.getItem());
            }
            head = head.getNext();
        }
        System.out.println();
    }

}
