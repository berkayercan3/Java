//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String directory = "C:\\Users\\Berkay\\IdeaProjects\\Java\\HuffmanCodingAssignments\\src";
        String fileName1 = "Dataset-0.txt";
        String fileName2 = "EncodeDataset.txt";

        FileManangement file = new FileManangement(directory , fileName1);
        String dataset = file.readFile();

        System.out.println("Dosyadaki veri: " + dataset);

        Huffman huffman = new Huffman();
        String encodeDataset = huffman.encode(dataset);

        huffman.displayFrequencyTable(huffman.buildFrequencyTable(dataset));
        huffman.displayHuffmanCoding();
        System.out.println("Sıkıştırılmış veri: " + encodeDataset);


    }
}