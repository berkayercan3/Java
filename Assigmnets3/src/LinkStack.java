public class LinkStack {
    private LinkedList theList;
    public LinkStack() {
        theList = new LinkedList();
    }
    public void push(char data) {
        theList.insertFirst(data);
    }
    public char pop() {
        return theList.deleteFirst();
    }
    public char peek() {
        return theList.peek();
    }
    public boolean isEmpty() {
        return theList.isEmpty();
    }
    public void displayStack() {
        System.out.print("Stack (top to bottom): ");
        theList.displayList();
    }
}
