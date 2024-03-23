package dpat.simple.solution;
import java.util.HashMap;
import java.util.Map;

public class PriceManager {
    private Map<Integer, Double> priceList = new HashMap<>();

    public void addProductPrice(int productId, double price) {
        priceList.put(productId, price);
    }

    public double getPrice(int productId) {
        return priceList.getOrDefault(productId, 0.0);
    }

    public void applyDiscount(int productId, Discount discount) {
        if (priceList.containsKey(productId)) {
            double originalPrice = priceList.get(productId);
            double discountedPrice = discount.calculateDiscountedPrice(originalPrice);
            priceList.put(productId, discountedPrice);
        }
    }
    
    public void payWithCreditCard(int productId) {
        if (priceList.containsKey(productId)) {
            System.out.println("Paying for Product ID: " + productId + " with Credit Card. Total: $" + getPrice(productId));
        } else {
            System.out.println("Product ID: " + productId + " not found.");
        }
    }

    // Method to simulate payment with PayPal
    public void payWithPayPal(int productId) {
        if (priceList.containsKey(productId)) {
            System.out.println("Paying for Product ID: " + productId + " with PayPal. Total: $" + getPrice(productId));
        } else {
            System.out.println("Product ID: " + productId + " not found.");
        }
    }
}
