package all.company.com.common;

public class ListNode<T> {
    private T item;
    private ListNode<T> next;

    public ListNode() {
    }

    public ListNode(final T item, final ListNode<T> next) {
        this.item = item;
        this.next = next;
    }

    public T getItem() {
        return item;
    }

    public void setItem(final T item) {
        this.item = item;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(final ListNode<T> next) {
        this.next = next;
    }
}
