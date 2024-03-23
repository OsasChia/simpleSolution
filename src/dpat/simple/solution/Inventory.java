package dpat.simple.solution;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products = new ArrayList<>();
    private PriceManager priceManager = new PriceManager();
    
    public PriceManager getPriceManager() {
        return priceManager;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updatePrice(int productId, double newPrice) {
        priceManager.addProductPrice(productId, newPrice);
    }

    public void applyDiscount(int productId, Discount discount) {
        priceManager.applyDiscount(productId, discount);
    }

    public void displayInventory() {
        for (Product product : products) {
            double price = priceManager.getPrice(product.getProductId());
            System.out.println(product.getProductDetails() + " - Price: " + price);
        }
    }
    
    public void removeProduct(Product product) {
        products.remove(product);
    }
}
