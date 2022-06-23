package all.company.com.top;

import java.util.Stack;
import all.company.com.common.LLUtils;
import all.company.com.common.ListNode;


public class Q24_SwapNodesInPair {
    public static void main(String[] args) {
        ListNode listNode = LLUtils.getLinkedList(7);
        LLUtils.printLinkedList(listNode);
        int pairSize = 6;
        ListNode head = swapNodesInPair(listNode, pairSize);
        LLUtils.printLinkedList(head);
    }

    private static ListNode swapNodesInPair(ListNode head, Integer pairSize) {
        ListNode nHead = null;
        ListNode t = null;
        ListNode tail = null;
        int ctr = pairSize;
        while (head != null){
            Stack<ListNode> stack = new Stack<>();
            t = head;
            while(ctr-- > 0){
                if(head == null){
                    break;
                }
                stack.push(head);
                head = head.next;
            }

            if(stack.size() == pairSize){
                while(!stack.isEmpty()){
                    if(nHead == null){
                        nHead = stack.pop();
                        tail = nHead;
                    } else {
                        tail.next = stack.pop();
                        tail = tail.next;
                        tail.next = null;
                    }
                }
                ctr = pairSize;
            } else {
                if(nHead == null){
                    nHead = t;
                } else {
                    tail.next = t;
                }
            }
        }
        return nHead;
    }
}
