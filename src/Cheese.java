import java.time.LocalDate;

public class Cheese extends Product implements Expirable, Shippable{
    private LocalDate expiryDate;
    private double weight;
    private double shippingCost;

    public Cheese(String name, double price, int quantity, double weight, LocalDate expiryDate) {
        super(name, price, quantity);
        this.weight = weight;
        this.expiryDate = expiryDate;
        this.shippingCost = 30;
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
