import java.time.LocalDate;

public class Cheese extends Product implements Expirable, Shippable{
    private String expiryDate;
    private double weight;

    public Cheese(String name, double price, int quantity, double weight, String expiryDate) {
        super(name, price, quantity);
        this.weight = weight;
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {

        LocalDate today = LocalDate.now();
        LocalDate expiry = LocalDate.parse(expiryDate);
        return expiry.isBefore(today);

    }

    @Override
    public String getExpirationDate() {
        return expiryDate.toString();
    }

    @Override
    public void setExpirationDate(String expiryDate) {

        this.expiryDate = LocalDate.parse(expiryDate).toString();
    }

    @Override
    public double getWeight() {
        return this.weight;
    }
}
