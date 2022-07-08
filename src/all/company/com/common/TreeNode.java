package all.company.com.common;

public class TreeNode<T, S> {
    public T val;
    public S left;
    public S right;

    public TreeNode(final T val) {
        this.val = val;
    }

    public TreeNode(final T val, final S left, final S right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
