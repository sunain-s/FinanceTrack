package tracker.service;

import java.util.ArrayList;
import java.util.List;
import tracker.model.Transaction;

public class TransactionManager {
    private List<Transaction> transactions = new ArrayList<>();

//    private Transaction createTransaction() {
//        // need to add input validation for field entries
//        Transaction t = new Transaction();
//        return t;
//    }

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
}
