package all.company.com.MachineCoding.LRU.entity;

public class DLLNode {

    private User user;
    private DLLNode next;
    private DLLNode previous;

    public DLLNode(final User user, final DLLNode next, final DLLNode previous) {
        this.user = user;
        this.next = next;
        this.previous = previous;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public DLLNode getNext() {
        return next;
    }

    public void setNext(final DLLNode next) {
        this.next = next;
    }

    public DLLNode getPrevious() {
        return previous;
    }

    public void setPrevious(final DLLNode previous) {
        this.previous = previous;
    }

    @Override public String toString() {
        return "DLLNode{" +
                "user=" + user +
                ", next=" + next +
                ", previous=" + previous +
                '}';
    }
}
