package tracker.model;

public class Transaction {
    private int id;
    private String description;
    private double amount;
    private String category;
    private String datetime;

    public Transaction(int id, String description, double amount, String category, String datetime) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.datetime = datetime;
    }

    // Getters
    public int getId() {
        return id;
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

    public String getDatetime() {
        return datetime;
    }

    // Setters?, toString of Transaction?
}