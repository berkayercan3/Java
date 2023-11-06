package DoublyLinkedList;

public class DoublyLinkedListApp {
    public static void main(String[] args){
        DoublyLinkedList theList = new DoublyLinkedList();

        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertToTail(11);
        theList.insertToTail(33);
        theList.insertToTail(55);

        theList.displayForward();
        theList.displayBackward();

        theList.deleteFirst();
        System.out.println("\nBaştan Silindi...");
        theList.displayForward();
        theList.deletedFromTail();
        System.out.println("Sondan Silindi... ");
        theList.displayForward();
        theList.delete(11);
        System.out.println("11 Silindi...");
        theList.displayForward();

    }
}
