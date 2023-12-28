package BinaryTree;

import java.util.Stack;

public class Tree {
    private Node root;

    public Tree() {
        root=null;
    }

    public void insert(long data){
        Node newNode = new Node();
        newNode.data = data;

        if(root==null)
            root=newNode;
        else {
            Node current = root;
            Node parent; //ana, esas
            while(true){
                parent = current;
                if (data < current.data){
                    current = current.leftChild;
                    if (current == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else {
                    current = current.rightChild;
                    if (current == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Node find(long data){
        Node current = root;
        while(current.data != data){
            if (data < current.data)
                current = current.leftChild;
            else current = current.rightChild;
            if (current == null)
                return null;
        }
        return current;
    }

    public void traverse(int traverseType){
        switch (traverseType) {
            case 1 -> {
                System.out.print("\n Preorder:");
                preOrder(root);
            }
            case 2 -> {
                System.out.print("\n InOrder:");
                inOrder(root);
            }
            case 3 -> {
                System.out.print("\n PostOrder:");
                postOrder(root);
            }
            default -> {
                System.out.print("\n Yanlıs secım yaptınz!");
            }
        }
        System.out.println("");
    }
    public void preOrder(Node localRoot){ // kök sol sağ
        if (localRoot != null){
            System.out.print(localRoot.data + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    public void inOrder(Node localRoot){ // sol kök sağ
        if (localRoot != null){
            inOrder(localRoot.leftChild); // lef null olana dek en sola geldi, null ile karşılaşınca durdu ve
                                            // printledi sonra righta geçti
            System.out.print(localRoot.data + " ");
            inOrder(localRoot.rightChild);
        }
    }

    public void postOrder(Node localRoot){ // sol sağ kök
        if (localRoot != null){
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.data + " ");
        }
    }

    public Node minimum(){
        Node current = root;
        Node last = null;
        while(current != null){
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public boolean delete(long key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true; // silinecek değer sağ çocuk mu sol çocuk mu ?

        while (current.data != key) { // aradığım değer currentime eşit oludğunda buldu while den çık
            parent = current;
            if (key < current.data) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) // aranan değer ağaçta yok
                return false;
        }

        //-------durum1: Child Yoksa sadece sil--------------
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.leftChild = null;
            else
                parent.rightChild = null;
        }

        //-------durum 2: Sağ Child yok ------------------
        else if (current.rightChild == null)
            if (current == root)
                root = current.leftChild;
            else if (isLeftChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;
            //--------durum 2: Sol Child yok -----------------
        else if (current.leftChild == null)
            if (current == root)
                root = current.rightChild;
            else if (isLeftChild)
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;
            //------------durum 3 sağda solda var -----------------------------
        else {
            Node successor = getSuccessor(current);
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.leftChild = successor;
            else parent.rightChild = successor;
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    private Node getSuccessor(Node delNode){ // varis
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;

        while (current != null){ // sağ ağacın en küçük düğümüne gitmek için sağın en soluna gidilir
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    public void displayTree() {
        Stack<Node> globalStack = new Stack<Node>(); // LİFO
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<Node>();
            isRowEmpty = true;

            for (int j = 0; j < nBlanks; j++)
                System.out.print(' ');

            while (!globalStack.isEmpty()) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.data);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if (temp.leftChild != null || temp.rightChild != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            } // end while globalStack boş değil
            System.out.println();
            nBlanks /= 2;
            while (!localStack.isEmpty())
                globalStack.push(localStack.pop());
        } // end while isRowEmpty false
        System.out.println("......................................................");
    }
}
