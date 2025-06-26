package tracker.util;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import tracker.model.Category;

public class ReadInput {
    private final Scanner scanner = new Scanner(System.in);

    public String readTransactionType(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().toUpperCase();
            if (input.equals("INCOME") || input.equals("EXPENSE")) {
                return input;
            } else {
                System.out.println("Invalid input. Please enter 'income' or 'expense'");
            }
        }
    }

    public double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number");
            }
        }
    }

    public String readString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (!input.isEmpty()) {return input;}
            System.out.println("Please enter a string");
        }
    }

    public Category readCategory(String prompt) {
        System.out.println(prompt);
        for (Category c : Category.values()) {
            System.out.println(" > " + c.getCategoryName());
        }

        while (true) {
            String input = scanner.nextLine().trim().toUpperCase();
            try {
                return Category.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please enter a valid category");
            }
        }

    }

    public String readDate(String prompt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                LocalDate.parse(input, formatter);
                return input;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid input. Please use yyyy-MM-dd");
            }
        }
    }
}
