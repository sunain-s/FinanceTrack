package tracker.model;

public class Transaction {
    private int id;
    private final String type;
    private final double amount;
    private final String description;
    private final String category;
    private final String date;

    public Transaction(String type, double amount, String description, String category, String date) {
        this.type = type;
        this.amount = amount;
        this.description = description;
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

    // Setters

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Transaction ID #%d\nType: %s\nAmount: £%.2f\nDescription: %s\nCategory: %s\nDate: %s", id, type, amount, description, category, date);
    }
}