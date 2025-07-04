import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Main {
    public static void main(String[] args) {

        // This whole Project is done entirely by me, only used AI for some little help
        // like line completion
        // but still purely my logic and my implementation

        // Test Cases are Done using some help of AI but the cases are purly thought of by me




        // --- TEST CASE 1: The "Everything" Order (Successful Complex Checkout) ---
        System.out.println("--- 1. Testing a successful complex order ---");
        Customer customer1 = new Customer("Khaled", 20000.0);
        Cart cart1 = new Cart();
        cart1.add(new TV("Sony Bravia 55\"", 18000, 5, 15.0), 1);
        cart1.add(new Cheese("Old Amsterdam", 350, 10, 0.5, LocalDate.now().plusMonths(3)), 2);
        cart1.add(new Biscuit("Oreo Box", 120, 30, 0.6, LocalDate.now().plusYears(1)), 3);
        cart1.add(new MobileScratchCard("Etisalat 50", 50, 100), 2);
        CheckoutService.checkout(customer1, cart1);
        System.out.println("----------------------------------------\n");

        // --- TEST CASE 2: Exact Balance (Edge Case) ---
        System.out.println("--- 2. Testing with exact balance ---");
        Product expensiveCheese = new Cheese("Parmigiano", 400, 5, 0.5, LocalDate.now().plusMonths(6));
        double cheesePrice = expensiveCheese.getPrice();
        double shippingFee = ((Shippable) expensiveCheese).getWeight() * 5.0; // Assuming 5.0 per kg
        double exactCost = cheesePrice + shippingFee;
        Customer customer2 = new Customer("Sara", exactCost); // Balance is EXACTLY enough
        Cart cart2 = new Cart();
        cart2.add(expensiveCheese, 1);
        CheckoutService.checkout(customer2, cart2);
        System.out.println("----------------------------------------\n");

        // --- TEST CASE 3: Insufficient Balance by a Penny (Edge Case) ---
        System.out.println("--- 3. Testing with balance just under the required amount ---");
        Customer customer3 = new Customer("Ahmed", exactCost - 0.01); // Just barely not enough
        Cart cart3 = new Cart();
        cart3.add(expensiveCheese, 1);
        CheckoutService.checkout(customer3, cart3);
        System.out.println("----------------------------------------\n");

        // --- TEST CASE 4: Item Expiring Today (Edge Case) ---
        System.out.println("--- 4. Testing an item that expires today ---");
        Customer customer4 = new Customer("Mona", 1000.0);
        Cart cart4 = new Cart();
        Product expiringToday = new Biscuit("Marie Biscuit", 20, 10, 0.1, LocalDate.now());
        cart4.add(expiringToday, 1); // Should SUCCEED, as isExpired() uses isBefore()
        CheckoutService.checkout(customer4, cart4);
        System.out.println("----------------------------------------\n");

        // --- TEST CASE 5: Order with No Shippable Items ---
        System.out.println("--- 5. Testing an order with zero shipping fees ---");
        Customer customer5 = new Customer("Omar", 500.0);
        Cart cart5 = new Cart();
        cart5.add(new MobileScratchCard("Orange 25", 25, 100), 4);
        CheckoutService.checkout(customer5, cart5); // Shipping should be 0.0
        System.out.println("----------------------------------------\n");

        // --- TEST CASE 6: Buying the Entire Stock ---
        System.out.println("--- 6. Testing buying the entire available stock ---");
        Customer customer6 = new Customer("Yara", 5000.0);
        Cart cart6 = new Cart();
        Product lastItems = new Biscuit("Chocolate Chip Cookies", 75, 5, 0.2, LocalDate.now().plusWeeks(2));
        cart6.add(lastItems, 5); // Add all 5 to cart
        CheckoutService.checkout(customer6, cart6);
        System.out.println("----------------------------------------\n");

        // --- TEST CASE 7: Standard Failure - Already Expired Item ---
        System.out.println("--- 7. Testing standard failure: Expired Item ---");
        Customer customer7 = new Customer("Youssef", 5000.0);
        Cart cart7 = new Cart();
        Product expiredBiscuit = new Biscuit("Choco Biscuit", 50, 10, 0.1, LocalDate.now().minusDays(1));
        cart7.add(expiredBiscuit, 1);
        CheckoutService.checkout(customer7, cart7);
        System.out.println("----------------------------------------\n");

        // --- TEST CASE 8: Standard Failure - Out of Stock ---
        System.out.println("--- 8. Testing standard failure: Out of Stock ---");
        System.out.println("Attempting to add 11 units when only 10 are in stock:");
        Cart cart8 = new Cart();
        Product limitedStockTV = new TV("Sharp TV", 8000, 10, 9.0);
        cart8.add(limitedStockTV, 11); // This will fail inside the cart.add() method
        System.out.println("--- Test complete for adding more than stock ---\n");

        // --- TEST CASE 9: Standard Failure - Empty Cart ---
        System.out.println("--- 9. Testing standard failure: Empty Cart ---");
        Customer customer9 = new Customer("Ali", 1000.0);
        Cart cart9 = new Cart();
        CheckoutService.checkout(customer9, cart9);
        System.out.println("----------------------------------------\n");

        // --- TEST CASE 10: Cart Modification Before Checkout ---
        System.out.println("--- 10. Testing cart modification before checkout ---");
        Customer customer10 = new Customer("Leila", 30000.0);
        Cart cart10 = new Cart();
        Product tvForCart10 = new TV("LG OLED", 25000, 3, 22.0);
        Product cheeseForCart10 = new Cheese("Gouda", 250, 10, 0.4, LocalDate.now().plusMonths(3));
        cart10.add(tvForCart10, 2);
        cart10.add(cheeseForCart10, 5);
        System.out.println("Customer changes their mind...");
        cart10.remove(tvForCart10, 1); // Removes one TV
        cart10.remove(cheeseForCart10, 5); // Removes all cheese
        CheckoutService.checkout(customer10, cart10); // Should checkout with only one TV
        System.out.println("----------------------------------------\n");

    }
}