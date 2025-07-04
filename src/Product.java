public class Product {
    private String name;
    private double price;
    private int quantity;



    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void updatePrice(double newPrice) {
        this.price = newPrice;
    }
    public void updateQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void display() {
        System.out.println("Product Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
    }




}
