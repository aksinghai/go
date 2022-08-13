package all.company.com.GoogleAToZ;

import all.company.com.common.ListNode;


public class Q3_DeleteNodeWithGivenKey {
    public static void main(String[] args) {
        ListNode<Integer> node = new ListNode<>(1, new ListNode<>(2, new ListNode<>(3, new ListNode<>(4, null))));
        int key = 4;
        node = deleteNodeWithKey(node, key);
        while (node != null) {
            System.out.println(node.getItem());
            node = node.getNext();
        }
    }

    private static ListNode<Integer> deleteNodeWithKey(ListNode<Integer> head, final int key) {
        if(head == null){
            return null;
        }
        if(head.getItem() == key){
            return head.getNext();
        }

        ListNode<Integer> t = head;
        while (t.getNext() != null && t.getNext().getItem() != key){
            t = t.getNext();
        }
        if(t.getNext() != null){
            t.setNext(t.getNext().getNext());
        }

        return head;
    }
}
