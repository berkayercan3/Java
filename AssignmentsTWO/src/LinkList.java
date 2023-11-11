public class LinkList {
    private int polynomialID;
    private Link head;
    private Link tail;

    public LinkList(int polynomialID){
        this.polynomialID = polynomialID;
        head = null;
        tail = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void insertLast(int coeff, int exp){
        Link newLink = new Link(coeff,exp);
        if (isEmpty())
            head=newLink;
        else
            tail.next=newLink;
        tail=newLink;
    }


    public void sortPolynomialFunction() {
        if (head == null || head.next == null) {
            return;
        }
        Link newHead = null;
        while (head != null) {
            Link current = head;
            head = head.next;
            if (newHead == null || current.exponent > newHead.exponent) {
                current.next = newHead;
                newHead = current;
            } else {
                Link temp = newHead;
                while (temp.next != null && current.exponent <= temp.next.exponent) {
                    temp = temp.next;
                }
                current.next = temp.next;
                temp.next = current;
            }
        }
        head = newHead;
    }

    public void deleteParameter(int exp) {
        Link current = head;
        Link previous = null;
        while (current != null) {
            if (current.exponent == exp) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                if (current == tail) {
                    tail = previous;
                }
                current = null;
                current = head;
            } else {
                previous = current;
                current = current.next;
            }
        }
    }

    public Link findLinkWithExponent(int exp) {
        Link current = head;
        while (current != null) {
            if (current.exponent == exp) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public LinkList subtractPolynomials(LinkList pol) {
        LinkList result = new LinkList(0);
        Link current = head;
        while (current != null) {
            result.insertLast(current.coefficient, current.exponent);
            current = current.next;
        }
        current = pol.head;
        while (current != null) {
            Link existingLink = result.findLinkWithExponent(current.exponent);
            if (existingLink != null) {
                existingLink.coefficient -= current.coefficient;
            } else {
                result.insertLast(-current.coefficient, current.exponent);
            }
            current = current.next;
        }
        result.sortPolynomialFunction();
        this.head = result.head;
        this.tail = result.tail;
        return this;
    }

    public LinkList sumPolynomial(LinkList pol) {
        LinkList result = new LinkList(0);
        Link current = head;
        while (current != null) {
            result.insertLast(current.coefficient, current.exponent);
            current = current.next;
        }
        current = pol.head;
        while (current != null) {
            Link existingLink = result.findLinkWithExponent(current.exponent);
            if (existingLink != null) {
                existingLink.coefficient += current.coefficient;
            } else {
                result.insertLast(current.coefficient, current.exponent);
            }
            current = current.next;
        }
        result.sortPolynomialFunction();
        this.head = result.head;
        this.tail = result.tail;
        return this;
    }

    public void displayPolynomial() {
        System.out.print("Pol-" + polynomialID + " Polynomial equation (head-->tail): ");
        Link current = head;
        System.out.print("{ ");
        while (current != null) {
            if (current.coefficient != 0) {
                if (current.coefficient < 0) {
                    System.out.print("- ");
                } else if (current != head) {
                    System.out.print("+ ");
                }
                System.out.print(Math.abs(current.coefficient));
                if (current.exponent != 0) {
                    if (current.exponent == 1) {
                        System.out.print("x ");
                    } else {
                        System.out.print("x^" + current.exponent + " ");
                    }
                }
            }
            current = current.next;
        }
        System.out.print(" }");
        System.out.println();
    }
    public int calculatePolynomial(int x) {
        int result = 0;
        Link current = head;
        while (current != null) {
            result += current.coefficient * Math.pow(x, current.exponent);
            current = current.next;
        }
        System.out.println("POL1("+x+") = "+ result);
        return result;
    }

    public int calculateSumOfCoefficients() {
        int sum = 0;
        Link current = head;
        while (current != null) {
            sum += current.coefficient;
            current = current.next;
        }
        System.out.println("KATSAYILAR TOPLAMI POL1("+1+") = "+ sum);
        return sum;
    }
}
