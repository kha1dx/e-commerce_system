import java.time.LocalDate;

public class Biscuit extends Product implements Expirable, Shippable {
    private LocalDate expiryDate;
    private double weight;
    private double shippingCost;

    public Biscuit(String name, double price, int quantity, double weight, LocalDate expiryDate, double shippingCost) {
        super(name, price, quantity);
        this.weight = weight;
        this.expiryDate = expiryDate;
        this.shippingCost = shippingCost;
    }

    @Override
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
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
    public double getShippingCost() {
        return this.shippingCost;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }
}
