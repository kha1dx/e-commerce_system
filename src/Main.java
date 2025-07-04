public class Main {
    public static void main(String[] args) {
        // Create product objects
        Product cheese = new Product("Cheese", 2.50, 3);
        Product bread = new Product("Bread", 1.50, 2);

        // Create a cart and add products
        Cart cart = new Cart();
        cart.add(cheese, 1);
        cart.add(bread, 1);
        cart.add(cheese, 3);
        cart.display();

    }
}