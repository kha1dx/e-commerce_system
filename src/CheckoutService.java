import java.util.HashMap;
import java.util.Map;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        double totalCost = cart.getTotalPrice();
        double subtotal = totalCost;
        double customerBalance = customer.getBalance();
        double totalWeight = cart.getTotalWeight();
        double shippingCost ;
        double shippingFee = 5.0; // Base shipping fee
        Map<Product, Integer> items = cart.getItems();


        //empty cart case
        if (items.isEmpty()) {
            System.out.println("Error: Cart is empty.");
            return;
        }

        //check eligibility of products and expired products
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            // Check if the product is out of stock
            if (quantity > product.getQuantity()) {
                System.out.println("Error: Product " + product.getName() + " is out of stock.");
                return;
            }


            // Check if the product is expirable and has expired
            if (product instanceof Expirable && ((Expirable) product).isExpired()) {
                System.out.println("Error: Product " + product.getName() + " is expired.");
                return;
            }


        }

        //calculate shipping cost
        shippingCost = cart.getTotalWeight() * shippingFee;
        //updating total cost
        totalCost += shippingCost;

        //checking and deducting customers balance
        boolean flag = customer.deductBalance(totalCost);


        //exits if customer does not have enough balance
        if(!flag){
            return;
        }

        //updating the quantity of products in the stock

        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            int newQuantity = entry.getKey().getQuantity() - entry.getValue();
            entry.getKey().updateQuantity(newQuantity);
        }

        //calculating total weigh
        if (totalWeight > 0) {
            System.out.println("\n** Shipment notice **");
            for (Map.Entry<Product, Integer> entry : items.entrySet()) {
                Product product = entry.getKey();
                // Check if the product is an instance of Shippable
                if (product instanceof Shippable) {
                    int quantity = entry.getValue();
                    // Get the item's weight and convert to grams for display
                    double weightInGrams = ((Shippable) product).getWeight() * 1000;
                    System.out.println(quantity + "x " + product.getName() + " " + (weightInGrams * quantity) + "g");
                }
            }
            System.out.println("Total package weight " + totalWeight + "kg");
        }


        System.out.println("\n** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(quantity + "x " + product.getName() + " " + (product.getPrice() * quantity));
        }
        System.out.println("----------------------");
        System.out.println("Subtotal " + subtotal);
        System.out.println("Shipping " + shippingCost);
        System.out.println("Amount " + totalCost);

        cart.clear();

    }



}
