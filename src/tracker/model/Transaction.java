package tracker.model;

public class Transaction {
    private final int id;
    private final String type;
    private final String description;
    private final double amount;
    private final String category;
    private final String date;

    public Transaction(int id, String type, String description, double amount, String category, String date) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return String.format("Transaction ID #%d\nType: %s\nDescription: %s\nAmount: £%.2f\nCategory: %s\nDate: %s", id, type, description, amount, category, date);
    }
}