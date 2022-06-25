package all.company.com.common;

public class DListNode<T> {
    private T item;
    private DListNode<T> next;
    private DListNode<T> prev;

    public DListNode() {
    }

    public DListNode(final T item, final DListNode<T> next, final DListNode<T> prev) {
        this.item = item;
        this.next = next;
        this.prev = prev;
    }

    public T getItem() {
        return item;
    }

    public void setItem(final T item) {
        this.item = item;
    }

    public DListNode<T> getNext() {
        return next;
    }

    public void setNext(final DListNode<T> next) {
        this.next = next;
    }

    public DListNode<T> getPrev() {
        return prev;
    }

    public void setPrev(final DListNode<T> prev) {
        this.prev = prev;
    }

    @Override public String toString() {
        return "DListNode{" +
                "item=" + item +
                ", next=" + next +
                ", prev=" + prev +
                '}';
    }
}
