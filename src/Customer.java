public class Customer {
    private String name;
    private double balance;
    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
    public String getName() {
        return name;
    }
    public double getBalance() {
        return balance;
    }
    public void addBalance(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("Amount to add must be positive.");
        }
    }
    public void deductBalance(double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}
