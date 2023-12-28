class HuffmanNode {
    char symbol;
    int frequency;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(char symbol, int frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}