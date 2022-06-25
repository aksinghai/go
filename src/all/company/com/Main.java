package all.company.com;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import all.company.com.common.DListNode;


public class Main {

    private static Map<Integer, DListNode<Integer>> lookup;
    private static Integer K;
    private static DListNode<Integer> head;
    private static DListNode<Integer> tail;

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
            DListNode<Integer> node = new DListNode<>();
            node.setItem(i);
            if(head == null){
                head = node;
                tail = head;
            } else {
                if(lookup.size() == K){
                    lookup.remove(head.getItem());
                    head = head.getNext();
                    head.setPrev(null);
                }
                tail.setNext(node);
                node.setPrev(tail);
                tail = tail.getNext();
            }
            lookup.put(i, node);
        } else {
            DListNode<Integer> node = lookup.get(i);
            if(node.getPrev() != null && node.getNext() != null){ //Middle node
                node.getPrev().setNext(node.getNext());
                node.getNext().setPrev(node.getPrev());
            } else if (node.getPrev() == null) { //Head Node
                node.getNext().setPrev(null);
                head = head.getNext();
                node.setNext(null);
            } else { //Last Node
                return;
            }
            tail.setNext(node);
            node.setPrev(tail);
            tail = tail.getNext();
        }
    }

    private static Set<Integer> getLogs(){
        return lookup.keySet();
    }
}
