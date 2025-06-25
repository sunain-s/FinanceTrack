package tracker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

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
        String category = readInput.readString("Enter category: ");
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
        if (loadedTransactions != null) {
            transactions.addAll(loadedTransactions);
        }
    }

    public void deleteTransaction(Transaction t) {
        transactions.remove(t);
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
}
