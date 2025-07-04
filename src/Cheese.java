import java.time.LocalDate;

public class Cheese extends Product implements Expirable, Shippable{
    private LocalDate expiryDate;
    private double weight;

    public Cheese(String name, double price, int quantity, double weight, LocalDate expiryDate) {
        super(name, price, quantity);
        this.weight = weight;
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {

        LocalDate today = LocalDate.now();
        return expiryDate.isBefore(today);

    }

    @Override
    public String getExpirationDate() {
        return expiryDate.toString();
    }

    @Override
    public void setExpirationDate(String expiryDate) {
        this.expiryDate = LocalDate.parse(expiryDate);
    }

    @Override
    public double getWeight() {
        return this.weight;
    }
}
