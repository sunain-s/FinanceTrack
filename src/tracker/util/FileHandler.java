package tracker.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import tracker.model.Transaction;

public class FileHandler {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void writeToFile(List<Transaction> transactions, String path) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), transactions);
            System.out.println("Transactions saved to: " + path);
        } catch (IOException e) {
            System.out.println("Error saving transactions to: " + path);
        }
    }

    public static List<Transaction> readFromFile(String path) {
        try {
            return mapper.readValue(new File(path), new TypeReference<List<Transaction>>() {});
        } catch  (IOException e) {
            System.out.println("Error reading transactions from: " + path);
            return null;
        }
    }
}
