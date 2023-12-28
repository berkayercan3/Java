import java.util.*;

public class Huffman {
    private Map<Character, String> huffmanCodes;

    public Huffman() {
        huffmanCodes = new HashMap<>();
    }

    public String encode(String input) {
        LinkList frequencyTable = buildFrequencyTable(input);
        HuffmanNode root = buildHuffmanTree(frequencyTable.first);
        buildHuffmanCodes(root, "");
        StringBuilder encodedData = new StringBuilder();
        for (char c : input.toCharArray()) {
            encodedData.append(huffmanCodes.get(c)).append("");
        }
        return encodedData.toString().trim();
    }

    LinkList buildFrequencyTable(String input) {
        LinkList frequencyTable = new LinkList();
        int[] frequency = new int[256];
        for (char c : input.toCharArray()) {
            frequency[c]++;
        }
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                frequencyTable.insertOrdered(new HuffmanNode((char) i, frequency[i]));
            }
        }
        return frequencyTable;
    }

    private HuffmanNode buildHuffmanTree(Link node) {
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.frequency));
        while (node != null) {
            priorityQueue.add(node.data);
            node = node.next;
        }
        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.remove();
            HuffmanNode right = priorityQueue.remove();
            HuffmanNode newNode = new HuffmanNode('\0', left.frequency + right.frequency);
            newNode.left = left;
            newNode.right = right;
            priorityQueue.add(newNode);
        }
        return priorityQueue.remove();
    }

    private void buildHuffmanCodes(HuffmanNode node, String code) {
        if (node == null) {
            return;
        }
        if (node.isLeaf()) {
            huffmanCodes.put(node.symbol, code);
        }
        buildHuffmanCodes(node.left, code + "0");
        buildHuffmanCodes(node.right, code + "1");
    }

    public void displayFrequencyTable(LinkList frequencyTable) {
        System.out.println("Karakter -  Frekans");

        if (frequencyTable.first != null) {
            Link current = frequencyTable.first.next;

            while (current != null) {
                System.out.println(current.data.symbol +": " + current.data.frequency);
                current = current.next;
            }
        }
        System.out.println("\n -----------------------------");
    }

    public void displayHuffmanCoding() {
        System.out.println("Huffman Kodlama");
        List<Map.Entry<Character, String>> entryList = new ArrayList<>(huffmanCodes.entrySet());
        for (int i = 0; i < entryList.size() - 1; i++) {
            Map.Entry<Character, String> entry = entryList.get(i);
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("\n -----------------------------");
    }
}

