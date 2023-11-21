package LinkedListRecursive;

public class LinkList {

    private Link head;

    public LinkList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void recursiveTraverse(Link current) {
        if (current != null) {
            System.out.println(current.data);
            recursiveTraverse(current.next);
        }
    }

    public int recursiveSize(Link current) {
        if (current == null) {
            return 0;
        }
        return 1 + recursiveSize(current.next);
    }

    public Link recursiveInsertLast(Link current, long d) {
        if (isEmpty()) {
            return new Link(d);
        } else {
            if (current.next == null) {
                current.next = new Link(d);
            } else {
                recursiveInsertLast(current.next, d);
            }
            return current;
        }
    }

    public Link getHead() {
        return this.head;
    }
}
