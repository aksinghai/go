package all.company.com.common;

import java.util.List;


public class GraphNode {
    public int val;
    public List<GraphNode> neighbors;

    public GraphNode(final int val, final List<GraphNode> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}