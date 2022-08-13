package test.junk.CashFree;


class TreeNode {
    int item;
    TreeNode left;
    TreeNode right;

    public TreeNode(int item, TreeNode left, TreeNode right){
        this.item = item;
        this.left = left;
        this.right = right;
    }
}

public class PathFromRootToLeafNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,null, null);
        root.left = new TreeNode(2, null, null);
        root.left.left = new TreeNode(4, null, null);
        root.left.right = new TreeNode(7, null, null);
        root.right = new TreeNode(3, null, null);
        root.right.left = new TreeNode(6, null, null);
        root.right.right = new TreeNode(7, null, null);
        int maxPathSum = findMaxPath(root);
        System.out.println("Max Path"+maxPathSum);
        printPathWithSum(root, maxPathSum, 0);
    }

    private static int findMaxPath(TreeNode root){
        if(root == null){
            return 0;
        }
        return Integer.max(findMaxPath(root.left), findMaxPath(root.right))+root.item;
    }


    private static boolean printPathWithSum(TreeNode root, int max, int sum){
        if(root == null){
            return sum == max;
        }

        boolean left = printPathWithSum(root.left, max, sum+root.item);
        boolean right = printPathWithSum(root.right, max, sum+root.item);
        if(left || right) {
            System.out.println(root.item);
        }
        return (left || right);
    }
}