package all.company.com.MachineCoding.LRU.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import all.company.com.MachineCoding.LRU.LRUCache;
import all.company.com.MachineCoding.LRU.entity.DataNode;
import all.company.com.MachineCoding.LRU.entity.User;


public class LRUCacheService {

    static int capacity = 5;
    static int allocation = 0;
    static Map<User, DataNode<User>> lookup = new HashMap<>(capacity);
    static DataNode<User> head = null;
    static DataNode<User> tail = null;

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
            DataNode node = new DataNode(user, null, null);
            addNode(node, user);
        }
    }

    public List<User> getUser(){
        List<User> users = new ArrayList<>();
        DataNode head = LRUCacheService.head;
        while(head != null){
            //users.add(head.getUser());
            head = head.getNext();
        }
        return users;
    }

    private void removeNode(DataNode node, User user) {
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
        allocation--;
    }

    private void addNode(DataNode node, User user) {
        if(head == null){
            head = node;
            tail = node;
        } else {
            if(allocation == capacity){
                removeNode(head, user);
                lookup.remove(user);
            }
            tail.setNext(node);
            node.setPrevious(tail);
            tail = tail.getNext();
        }
        lookup.put(user, node);
        allocation++;
    }

}
