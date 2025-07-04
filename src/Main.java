import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Create product objects
        Cheese cheese = new Cheese("parmesan", 2.5, 10, 0.5, "12/12/2026", 1.0);

        // Create a cart and add products
        Cart cart = new Cart();
        cart.add(cheese, 1);
        cart.add(cheese, 3);
        cart.display();

    }
}