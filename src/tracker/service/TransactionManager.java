package tracker.service;

import java.util.ArrayList;
import java.util.List;
import tracker.model.Transaction;
import tracker.util.ReadInput;

public class TransactionManager {
    private final List<Transaction> transactions = new ArrayList<>();
    private final ReadInput readInput = new ReadInput();

    private Transaction createTransaction() {
        String type = readInput.readTransactionType("Enter transaction type (income/expense): ");
        double amount = readInput.readDouble("Enter amount: ");
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

    public void deleteTransaction(Transaction t) {
        transactions.remove(t);
    }

    public List<Transaction> getTransactions() {
        return transactions;
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
