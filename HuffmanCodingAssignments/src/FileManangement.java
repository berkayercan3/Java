import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileManangement {
    private String directory;
    private String filename;
    private String fileContent;

    public FileManangement(String directory, String filename) {
        this.directory = directory;
        this.filename = filename;
        this.fileContent = readFile();
    }

    public String readFile() {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(directory, filename)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }

    public Map<Character, Integer> calculateCharacterFrequency() {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char character : fileContent.toCharArray()) {
            frequencyMap.put(character, frequencyMap.getOrDefault(character, 0) + 1);
        }

        return frequencyMap;
    }
}
