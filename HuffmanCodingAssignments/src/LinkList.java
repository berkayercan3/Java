class LinkList {
    Link first;

    public LinkList() {
        first = null;
    }

    public void insertFirst(HuffmanNode newNode) {
        Link newLink = new Link(newNode);
        newLink.next = first;
        first = newLink;
    }

    public void insertOrdered(HuffmanNode newNode) {
        if (first == null || newNode.frequency < first.data.frequency) {
            insertFirst(newNode);
        } else {
            Link current = first;
            while (current.next != null && newNode.frequency >= current.next.data.frequency) {
                current = current.next;
            }
            Link newLink = new Link(newNode);
            newLink.next = current.next;
            current.next = newLink;
        }
    }
}
