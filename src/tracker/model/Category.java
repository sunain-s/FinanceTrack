package tracker.model;

public enum Category {
    SALARY("Salary"),
    FOOD("Food"),
    BILLS("Bills"),
    ENTERTAINMENT("Entertainment"),
    PLEASURE("Pleasure"),
    GIFTS("Gifts"),
    TRANSPORT("Transport"),
    INVESTMENT("Investment"),
    OTHER("Other");

    private final String categoryName;

    Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public String toString() {
        return categoryName;
    }
}