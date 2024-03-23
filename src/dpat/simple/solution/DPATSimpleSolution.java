package dpat.simple.solution;

public class DPATSimpleSolution {
    public static void main(String[] args) {       
        // Instantiate Inventory and associated managers
        Inventory inventory = new Inventory();
        CategoryManager categoryManager = new CategoryManager();
        PriceManager priceManager = inventory.getPriceManager();

        // Add categories to the CategoryManager
        categoryManager.addCategory("Electronics");
        categoryManager.addCategory("Books");

        // Add products to the Inventory
        Product laptop = new Product(1, "Laptop", "Electronics");
        Product book = new Product(2, "Book", "Books");
        inventory.addProduct(laptop);
        inventory.addProduct(book);

        // Set initial prices for the products
        priceManager.addProductPrice(laptop.getProductId(), 1000.0);
        priceManager.addProductPrice(book.getProductId(), 50.0);
        
        // Display inventory state
        System.out.println("Inventory initial price:");
        inventory.displayInventory();
        
        // Update product price
        priceManager.addProductPrice(book.getProductId(), 60.0); // Update price for Book
        
        // Display inventory state
        System.out.println("\nInventory after updating the book's price:");
        inventory.displayInventory();

        // Apply a fixed discount of $10 to all products and display
        Discount tenDollarsOff = new Discount(0, "fixed", 10.0); // $10 discount
        priceManager.applyDiscount(laptop.getProductId(), tenDollarsOff);
        priceManager.applyDiscount(book.getProductId(), tenDollarsOff);
        System.out.println("\nInventory with fixed discount 10$ applied:");
        inventory.displayInventory();

        // Apply an additional 50% percentage discount on top of the fixed discount and display
        Discount fiftyPercentOff = new Discount(1, "percentage", 50.0); // 50% discount
        priceManager.applyDiscount(laptop.getProductId(), fiftyPercentOff);
        priceManager.applyDiscount(book.getProductId(), fiftyPercentOff);
        System.out.println("\nInventory with both fixed and percentage discounts applied:");
        inventory.displayInventory();

        // Simulate payment transactions using the final prices after discount
        System.out.println("\nSimulating payments:");
        priceManager.payWithCreditCard(laptop.getProductId()); // Simulate paying for the laptop with Credit Card
        priceManager.payWithPayPal(book.getProductId()); // Simulate paying for the book with PayPal

        // Remove the Laptop from the inventory
        inventory.removeProduct(laptop);

        // Display final inventory state
        System.out.println("\nFinal Inventory State:");
        inventory.displayInventory();
    }
}
