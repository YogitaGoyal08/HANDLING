import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class FileOperationsDemo {

    // File name used for demonstration
    private static final String FILE_NAME = "example.txt";

    public static void main(String[] args) {
        writeToFile();
        readFromFile();
        modifyFile();
        readFromFile();
    }

  
    public static void writeToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("Hello, this is a sample text file.");
            writer.newLine();
            writer.write("This file demonstrates basic file operations in Java.");
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    
    public static void readFromFile() {
        try {
            Path path = Path.of(FILE_NAME);
            List<String> lines = Files.readAllLines(path);

            System.out.println("\n--- File Contents ---");
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void modifyFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.newLine();
            writer.write("This line was added later to modify the file.");
            System.out.println("\nFile modified successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }
}
