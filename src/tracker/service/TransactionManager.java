package tracker.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.stream.Collectors;

import tracker.model.Category;
import tracker.model.Transaction;
import tracker.util.ReadInput;
import tracker.util.FileHandler;

public class TransactionManager {
    private final List<Transaction> transactions = new ArrayList<>();
    private final ReadInput readInput = new ReadInput();

    private Transaction createTransaction() {
        String type = readInput.readTransactionType("Enter transaction type (income/expense): ");
        double amount = readInput.readDouble("Enter amount (£): ");
        String description = readInput.readString("Enter description: ");
        Category category = readInput.readCategory("Enter category: ");
        String date = readInput.readDate("Enter date (yyyy-MM-dd): ");

        Transaction t = new Transaction(type, amount, description, category, date);
        t.setId(generateNextId());
        return t;
    }

    public void addTransaction() {
        Transaction t = createTransaction();
        transactions.add(t);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void saveTransactions(String path) {
        FileHandler.writeToFile(transactions, path);
    }

    public void loadTransactions(String path) {
        List<Transaction> loadedTransactions = FileHandler.readFromFile(path);
        System.out.println("Transactions loaded from: " + path);
        if (loadedTransactions != null) {
            transactions.clear();
            transactions.addAll(loadedTransactions);
        }
    }

    public void deleteTransaction(int id) {
        Iterator<Transaction> iterator = transactions.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                System.out.printf("Transaction #%d deleted.%n", id);
                return;
            }
        }
        System.out.println("Transaction ID not found.");
    }

    private int generateNextId() {
        int maxId = 0;
        for (Transaction t : transactions) {
            if (t.getId() > maxId) {
                maxId = t.getId();
            }
        }
        return maxId + 1;
    }

    // Filtering
    public List<Transaction> filterByType(String type) {
        return transactions.stream().filter(t -> t.getType().equals(type)).collect(Collectors.toList());
    }

    public List<Transaction> filterByCategory(Category category) {
        return transactions.stream().filter(t -> t.getCategory().equals(category)).collect(Collectors.toList());
    }

    public List<Transaction> filterByDate(String start, String end) {
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);

        return transactions.stream().filter(t -> {
            LocalDate tDate = LocalDate.parse(t.getDate());
            return (tDate.isEqual(startDate) || tDate.isAfter(startDate)) && (tDate.isEqual(endDate) || tDate.isBefore(endDate));
        }).toList();
    }

    public List<Transaction> filterByTypeAndDate(String type, String start, String end) {
        return filterByDate(start, end).stream().filter(t -> t.getType().equals(type)).collect(Collectors.toList());
    }

}
