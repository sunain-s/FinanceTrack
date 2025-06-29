package tracker.app;

import java.util.Scanner;
import java.util.List;

import tracker.model.Category;
import tracker.model.Transaction;
import tracker.service.*;
import tracker.util.ReadInput;

public class FinanceTrackApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TransactionManager manager = new TransactionManager();

        System.out.println("===========================================================================================");
        System.out.println("                                       FINANCE TRACK                                       ");
        System.out.println("===========================================================================================");

        boolean flag = true;
        while (flag) {
            System.out.println("\n-----Select Action-----");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. Delete Transaction");
            System.out.println("4. Save To File");
            System.out.println("5. Load File");
            System.out.println("0. Exit");

            int select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1:
                    manager.addTransaction();
                    break;
                case 2:
                    viewTransactions(scanner, manager);
                    break;
                case 3:
                    System.out.print("Enter transaction ID to delete: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    manager.deleteTransaction(id);
                    break;
                case 4:
                    manager.saveTransactions("src/data/transactions.json");
                    break;
                case 5:
                    manager.loadTransactions("src/data/transactions.json");
                    break;
                case 0:
                    flag = false;
                    break;
            }
        }
    }

    private static void viewTransactions(Scanner scanner, TransactionManager manager) {
        ReadInput readInput = new ReadInput();
        List<Transaction> transactions;

        boolean flag = true;
        while (flag) {
            System.out.println("\n----- View Transactions -----");
            System.out.println("1. View all transactions");
            System.out.println("2. Filter by type (income/expense)");
            System.out.println("3. Filter by category");
            System.out.println("4. Filter by date range");
            System.out.println("5. Filter by type and date range");
            System.out.println("0. Exit");

            int select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1:
                    transactions = manager.getTransactions();
                    printTransactions(transactions);
                    break;
                case 2:
                    String type = readInput.readTransactionType("Enter type of transaction: ");
                    transactions = manager.filterByType(type);
                    printTransactions(transactions);
                    break;
                case 3:
                    Category category = readInput.readCategory("Enter category: ");
                    transactions = manager.filterByCategory(category);
                    printTransactions(transactions);
                    break;
                case 4:
                    String start = readInput.readDate("Enter start date (yyyy-MM-dd): ");
                    String end = readInput.readDate("Enter end date (yyyy-MM-dd): ");
                    transactions = manager.filterByDate(start, end);
                    printTransactions(transactions);
                    break;
                case 5:
                    String typeFilter = readInput.readTransactionType("Enter type of transaction: ");
                    String startFilter = readInput.readDate("Enter start date (yyyy-MM-dd): ");
                    String endFilter = readInput.readDate("Enter end date (yyyy-MM-dd): ");
                    transactions = manager.filterByTypeAndDate(typeFilter, startFilter, endFilter);
                    printTransactions(transactions);
                    break;
                case 0:
                    flag = false;
                    break;
            }
        }
    }

    private static void printTransactions(List<Transaction> transactions) {
        if (!transactions.isEmpty()) {
            for (Transaction t : transactions) {
                System.out.println(t + "\n");
            }
        } else {
            System.out.println("No transactions found");
        }
    }
}