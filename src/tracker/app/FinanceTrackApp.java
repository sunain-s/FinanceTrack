package tracker.app;

import java.util.Scanner;
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
                    System.out.println(manager.getTransactions());
                    break;
                case 3:
                    // manager.deleteTransaction();
                    break;
                case 4:
                    // save updates
                    break;
                case 5:
                    // load from file
                    break;
                case 0:
                    flag = false;
                    break;
            }
        }
    }
}