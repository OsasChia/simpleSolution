package dpat.simple.solution;

public class Discount {
    private int discountId;
    private String discountType; // "percentage" or "fixed"
    private double discountValue;

    public Discount(int discountId, String discountType, double discountValue) {
        this.discountId = discountId;
        this.discountType = discountType;
        this.discountValue = discountValue;
    }

    public double calculateDiscountedPrice(double originalPrice) {
        if ("percentage".equals(discountType)) {
            return originalPrice - (originalPrice * discountValue / 100);
        } else if ("fixed".equals(discountType)) {
            return originalPrice - discountValue;
        }
        return originalPrice; // No discount applied
    }

    // Getters
    public int getDiscountId() {
        return discountId;
    }

    public String getDiscountType() {
        return discountType;
    }

    public double getDiscountValue() {
        return discountValue;
    }
}
