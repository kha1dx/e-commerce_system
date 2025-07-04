public class Mobile extends Product implements Shippable{
    double weight;
    double shippingCost;

    public Mobile(String name, double price, int quantity, double weight, double shippingCost) {
        super(name, price, quantity);
        this.weight = weight;
        this.shippingCost = shippingCost;
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
