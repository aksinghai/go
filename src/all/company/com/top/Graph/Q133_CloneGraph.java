package all.company.com.top.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import all.company.com.common.GraphNode;


public class Q133_CloneGraph {

    public static void main(String[] args) {
        GraphNode node1 = new GraphNode(1, new ArrayList<>());
        GraphNode node2 = new GraphNode(2, new ArrayList<>());
        GraphNode node3 = new GraphNode(3, new ArrayList<>());
        GraphNode node4 = new GraphNode(4, new ArrayList<>());
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node1);
        node2.neighbors.add(node4);
        node3.neighbors.add(node1);
        node3.neighbors.add(node3);
        node4.neighbors.add(node2);
        node4.neighbors.add(node3);
        traverseGraph(node1);
        //GraphNode cloned = cloneGraph(node1);

    }


    public static GraphNode cloneGraph(GraphNode node) {
        if(node == null){
            return node;
        }

        if(node.neighbors.size() == 0){
            return new GraphNode(node.val, new ArrayList<>());
        }

        Map<GraphNode, GraphNode> oldNodeToNewNodeMap = new HashMap<>();
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {

        }
        return null;


    }

    public static void traverseGraph(GraphNode node){
        Set<GraphNode> visitedNodes = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            GraphNode graphNode = queue.remove();
            visitedNodes.add(graphNode);
            System.out.println("Node " + graphNode.val);
            for(GraphNode i : graphNode.neighbors){
                if(!visitedNodes.contains(i)){
                    queue.add(i);
                }
            }
        }
    }






}
