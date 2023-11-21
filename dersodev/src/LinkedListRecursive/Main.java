package LinkedListRecursive;

public class Main {

    public static void main(String[] args) {
        LinkList linkedList = new LinkList();

        Link newLink = new Link(0);
        linkedList.getHead().next = newLink;

        linkedList.recursiveInsertLast(linkedList.getHead(), 1);
        linkedList.recursiveInsertLast(newLink, 2);
        linkedList.recursiveInsertLast(newLink, 14);
        linkedList.recursiveInsertLast(newLink, 14);

        System.out.println("Linked List Elements:");
        linkedList.recursiveTraverse(linkedList.getHead());

        System.out.println("Linked List Size: " + linkedList.recursiveSize(linkedList.getHead()));
    }
}
