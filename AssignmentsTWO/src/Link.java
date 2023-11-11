public class Link {
    int coefficient; // katsayı
    int exponent; // üs
    Link next;

    public Link(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.next = null;
    }
}
