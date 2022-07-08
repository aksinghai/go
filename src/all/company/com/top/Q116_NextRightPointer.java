package all.company.com.top;

import java.util.LinkedList;
import java.util.Queue;
import all.company.com.common.TreeNode;


class Node extends TreeNode<Integer, Node> {
    public Node next;

    Node(final Integer val) {
        super(val);
    }

    Node(final Integer val, final Node left, final Node right) {
        super(val, left, right);
    }
}

public class Q116_NextRightPointer {
    public static void main(String[] args) {
        Node node = new Node(1,
                new Node(2, new Node(4), new Node(5)),
                new Node(3, new Node(6), new Node(7)));
        node = connect(node);
        System.out.println();
    }

    public static Node connect(Node root) {
        if(root  == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> nextQueue = new LinkedList<>();
        queue.add(root);
        Node prev = null;
        while(!queue.isEmpty()) {
            Node n = queue.remove();
            if(prev != null){
                prev.next = n;
            }
            prev = n;
            if(n.left != null){
                nextQueue.add(n.left);
            }
            if(n.right != null){
                nextQueue.add(n.right);
            }

            if(queue.isEmpty()){
                queue = nextQueue;
                nextQueue = new LinkedList<>();
                prev = null;
            }
        }
        return root;
    }
}
