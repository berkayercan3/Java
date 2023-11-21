public class LinkedList {
    private Link head;
    public LinkedList() {
        head = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void insertFirst(char data) {
        Link newLink = new Link(data);
        newLink.next = head;
        head = newLink;
    }
    public char deleteFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        char temp = head.data;
        head = head.next;
        return temp;
    }
    public char peek() {
        return isEmpty() ? ' ' : head.data;
    }
    public void displayList() {
        Link current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
