import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items;

    public Cart(){
        this.items = new HashMap<>();
    }
    public void add(Product product, int addedQuantity) {
        //edge case to handle if the user wants
        //to add more than the available quantity

        if (addedQuantity > product.getQuantity()) {
            System.out.println("Cannot add " + addedQuantity + " of " + product.getName() + ". Only " + product.getQuantity() + " available.");
            return;
        }
        // update quantity if the product already exist in cart
        // or create new item in the cart

        int currentQuantity = items.getOrDefault(product, 0);

        int newQuantity = currentQuantity + addedQuantity;

        if (newQuantity > product.getQuantity()) {
            System.out.println("Cannot add " + addedQuantity + " of " + product.getName() + ". Only " + (product.getQuantity() - currentQuantity) + " available.");
            return;

        }

        // add the new quantity and update the map.

        items.put(product, newQuantity);

        System.out.println(addedQuantity + "x " + product.getName() + " added to cart.");
    }

    public void remove(Product product, int removedQuantity) {
        if (!items.containsKey(product)) {
            System.out.println("Product not found in cart.");
            return;
        }

        int currentQuantity = items.get(product);
        if (removedQuantity >= currentQuantity) {
            items.remove(product);
            System.out.println("Removed all " + product.getName() + " from cart.");
        } else {
            items.put(product, currentQuantity - removedQuantity);
            System.out.println(removedQuantity + "x " + product.getName() + " removed from cart.");
        }
    }

    public void display() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("Items in Cart:");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(quantity + "x " + product.getName() + " - $" + product.getPrice() * quantity);
        }
    }



}






