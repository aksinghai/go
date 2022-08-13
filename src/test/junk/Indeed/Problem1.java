package test.junk.Indeed;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


class TNode {
    public int data;
    public TNode left;
    public TNode right;

    TNode(final int data, final TNode left, final TNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}


public class Problem1 {

    //Represent Binary Tree to Array
    public static void main(String[] args) {
        TNode treeNode = new TNode(1, null, new TNode(3,
                new TNode(6, null, null), new TNode(7, null, null)));

        representInArray(treeNode, 3);
        System.out.println(getLeft(1));
    }


    private static int[] treeArray;
    private static boolean[] notNull;

    private static void representInArray(final TNode treeNode, final int height) {
        if(treeNode == null || height == 0){
            return;
        }
        int n = (int)Math.pow(2, height) - 1;
        treeArray = new int[n];
        notNull = new boolean[n];
        Map<TNode, Integer> indexes = new HashMap<>();
        Queue<TNode> queue = new LinkedList<>();
        Queue<TNode> nextQueue = new LinkedList<>();
        queue.add(treeNode);
        indexes.put(treeNode, 0);
        treeArray[0] = treeNode.data;
        notNull[0] = true;
        while (!queue.isEmpty()){
            TNode node = queue.remove();
            int baseIndex = 2 * indexes.get(node);
            if(node.left != null){
                nextQueue.add(node.left);
                treeArray[baseIndex+1] = node.left.data;
                notNull[baseIndex+1] = true;
                indexes.put(node.left, baseIndex+1);
            }

            if(node.right != null){
                nextQueue.add(node.right);
                treeArray[baseIndex+2] = node.right.data;
                notNull[baseIndex+2] = true;
                indexes.put(node.right, baseIndex+2);
            }

            if(queue.isEmpty()){
                queue = nextQueue;
                nextQueue = new LinkedList<>();
            }
        }
        System.out.println(Arrays.toString(treeArray));
    }

    private static int getLeft(int index) {
        if(!notNull[index]){
            return -1;
        }

        return treeArray[2 * index + 1];
    }

}
