package all.company.com.MachineCoding.LRU.entity;

public class DataNode<T> {

    private T data;
    private DataNode<T> next;
    private DataNode<T> previous;

    public DataNode(final T data, final DataNode<T> next, final DataNode<T> previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    public T getData() {
        return data;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public DataNode<T> getNext() {
        return next;
    }

    public void setNext(final DataNode<T> next) {
        this.next = next;
    }

    public DataNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(final DataNode<T> previous) {
        this.previous = previous;
    }

    @Override public String toString() {
        return "DataNode{" +
                "data=" + data +
                ", next=" + next +
                ", previous=" + previous +
                '}';
    }
}
