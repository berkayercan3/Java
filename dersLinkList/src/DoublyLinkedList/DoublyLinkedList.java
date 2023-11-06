package DoublyLinkedList;

public class DoublyLinkedList {
    private Link head;
    private Link tail;

    public DoublyLinkedList(){
        head=null;
        tail=null;
    }
    public boolean isEmpty() {return head==null;}

    public void insertFirst(long d){
        Link newLink = new Link(d);

        if(isEmpty())
            tail=newLink;
        else
            head.previous=newLink;
        newLink.next = head;
        head = newLink;
    }

    public void insertToTail(long d){
        Link newLink=new Link(d);

        if (isEmpty())
            head=newLink;
        else {
            tail.next = newLink;
            newLink.previous = tail;
        }
        tail = newLink;
    }

    public Link deleteFirst(){
        Link temp  =head;

        if (head.next==null)
            tail=null;
        else
            head.next.previous=null;
        head=head.next;
        return temp;
    }

    public Link deletedFromTail(){
        Link temp = tail;

        if (head.next==null)
            head = null;
        else
            tail.previous.next = null;
        tail=tail.previous;
        return temp;
    }

    public Link find(long key) {
        Link current = head;

        while (current.data != key) {
            current = current.next;
            if (current == null)
                return null;
        }
        return current;
    }

    public void delete(long d){
        Link current = find(d);
        if (current != null){
            if (current ==head){
                head=current.next;
                head.previous=null;
            }
            else if (current==tail){
                tail = current.previous;
                tail.next = null;
            }
            else{
                current.previous.next=current.next;
                current.next.previous = current.previous;
            }
        }
    }

    public void displayForward(){
        System.out.print("Liste: (head-->tail): ");
        Link current = head;

        while (current != null){
            current.displayLink();
            current=current.next;
        }
        System.out.println(" ");
    }

    public void displayBackward(){
        System.out.print("Liste: (tail-->head): ");
        Link current= tail;

        while (current != null){
            current.displayLink();
            current=current.previous;
        }
        System.out.print(" ");
    }
}
