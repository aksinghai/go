package all.company.com;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import all.company.com.common.DListNode;


public class Main {

    private static Map<Integer, DListNode> lookup;
    private static int K;
    private static DListNode head;
    private static DListNode tail;

    static {
        lookup = new HashMap<>(5);
        K = 5;
        head = null;
        tail = null;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 20; i++){
            addLog(i);
            if(i % 3 == 0){
                System.out.println(getLogs());
            }
        }

    }

    private static void addLog(int i){
        if(!lookup.containsKey(i)){
            DListNode node = new DListNode();
            node.item = i;
            if(head == null){
                head = node;
                tail = head;
            } else {
                if(lookup.size() == K){
                    lookup.remove(head.item);
                    head = head.next;
                    head.prev = null;
                }
                tail.next = node;
                node.prev = tail;
                tail = tail.next;
            }
            lookup.put(i, node);
        } else {
            DListNode node = lookup.get(i);
            if(node.prev != null && node.next != null){ //Middle node
                node.prev.next = node.next;
                node.next.prev = node.prev;
            } else if (node.prev == null) { //Head Node
                node.next.prev = null;
                head = head.next;
                node.next = null;
            } else { //Last Node
                return;
            }
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }
    }

    private static Set<Integer> getLogs(){
        return lookup.keySet();
    }
}
