package tracker.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import tracker.model.Transaction;
import tracker.model.Category;

public class ReportGenerator {
    public void generateSummary(List<Transaction> transactions) {
        double totalIncome = 0;
        double totalExpense = 0;
        for (Transaction t : transactions) {
            if (t.getType().equals("INCOME")) {
                totalIncome += t.getAmount();
            } else if (t.getType().equals("EXPENSE")) {
                totalExpense += t.getAmount();
            }
        }

        System.out.println("\n-----Summary Report-----");
        System.out.printf("Total Income:  £%.2f%n", totalIncome);
        System.out.printf("Total Expense: £%.2f%n", totalExpense);
        System.out.printf("Net Balance:   £%.2f%n", totalIncome - totalExpense);
    }

    public void generateSummaryByCategory(List<Transaction> transactions) {
        Map<Category, Double> categoryTotals = new HashMap<>();

        for (Transaction t : transactions) {
            categoryTotals.merge(t.getCategory(), t.getAmount(), Double::sum);
        }

        System.out.println("\nCategory Breakdown:");
        for (var entry : categoryTotals.entrySet()) {
            System.out.printf("%-15s: £%.2f%n", entry.getKey(), entry.getValue());
        }
    }
}
