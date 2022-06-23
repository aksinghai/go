package all.company.com.MachineCoding.LRU.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import all.company.com.MachineCoding.LRU.LRUCache;
import all.company.com.MachineCoding.LRU.entity.DLLNode;
import all.company.com.MachineCoding.LRU.entity.User;


public class LRUService {

    static int K = 5;
    static int k = 0;
    static Map<User, DLLNode> lookup = new HashMap<>(K);
    static DLLNode head = null;
    static DLLNode tail = null;

    public void addLog(Integer userId){
        User user = LRUCache.userService.getUser(userId);
        if(user == null){
            System.out.println("Something went wrong");
            return;
        }
        if(lookup.containsKey(user)){
            removeNode(lookup.get(user), user);
            addNode(lookup.get(user), user);
        } else {
            DLLNode node = new DLLNode(user, null, null);
            addNode(node, user);
        }
    }

    public List<User> getUser(){
        List<User> users = new ArrayList<>();
        DLLNode head = LRUService.head;
        while(head != null){
            users.add(head.getUser());
            head = head.getNext();
        }
        return users;
    }

    private void removeNode(DLLNode node, User user) {
        if(node == null){
            return;
        }
        if(node.getPrevious() != null && node.getNext() != null) { // Single Node
            node.getPrevious().setNext(node.getNext());
            node.getNext().setPrevious(node.getPrevious());
            node.setPrevious(null);
            node.setNext(null);
        } else if(node.getPrevious() != null){ // Last Node
            tail = node.getPrevious();
            node.getPrevious().setNext(null);
            node.setPrevious(null);
        } else { // First Node
            head = node.getNext();
            node.getNext().setPrevious(null);
            node.setNext(null);
        }
        lookup.remove(user);
        k--;
    }

    private void addNode(DLLNode node, User user) {
        if(head == null){
            head = node;
            tail = node;
        } else {
            if(k == K){
                removeNode(head, user);
                lookup.remove(user);
            }
            tail.setNext(node);
            node.setPrevious(tail);
            tail = tail.getNext();
        }
        lookup.put(user, node);
        k++;
    }

}
