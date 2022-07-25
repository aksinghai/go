package all.company.com.top;

import java.util.Stack;
import all.company.com.common.LLUtils;
import all.company.com.common.ListNode;


public class Q24_SwapNodesInPair {
    public static void main(String[] args) {
        ListNode<Integer> listNode = LLUtils.getLinkedList(7);
        LLUtils.printLinkedList(listNode);
        int pairSize = 6;
        ListNode<Integer> head = swapNodesInPair(listNode, pairSize);
        LLUtils.printLinkedList(head);
    }

    /*
    Hint :
     */
    private static ListNode<Integer> swapNodesInPair(ListNode<Integer> head, Integer pairSize) {
        ListNode<Integer> nHead = null;
        ListNode<Integer> t = null;
        ListNode<Integer> tail = null;
        int ctr = pairSize;
        while (head != null){
            Stack<ListNode<Integer>> stack = new Stack<>();
            t = head;
            while(ctr-- > 0){
                if(head == null){
                    break;
                }
                stack.push(head);
                head = head.getNext();
            }

            if(stack.size() == pairSize){
                while(!stack.isEmpty()){
                    if(nHead == null){
                        nHead = stack.pop();
                        tail = nHead;
                    } else {
                        tail.setNext(stack.pop());
                        tail = tail.getNext();
                        tail.setNext(null);
                    }
                }
                ctr = pairSize;
            } else {
                if(nHead == null){
                    nHead = t;
                } else {
                    tail.setNext(t);
                }
            }
        }
        return nHead;
    }
}
