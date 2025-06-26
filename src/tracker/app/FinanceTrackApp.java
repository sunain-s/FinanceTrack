package tracker.app;

import java.util.Scanner;
import java.util.List;

import tracker.model.Transaction;
import tracker.service.*;

public class FinanceTrackApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TransactionManager manager = new TransactionManager();

        System.out.println("===========================================================================================");
        System.out.println("                                       FINANCE TRACK                                       ");
        System.out.println("===========================================================================================");

        boolean flag = true;
        while (flag) {
            System.out.println("-----Select Action-----");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. Delete Transaction");
            System.out.println("4. Save");
            System.out.println("5. Load");
            System.out.println("0. Exit");

            int select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1:
                    manager.addTransaction();
                    break;
                case 2:
                    List<Transaction> transactions = manager.getTransactions();
                    for (Transaction t : transactions) {
                        System.out.println(t + "\n");
                    }
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
}