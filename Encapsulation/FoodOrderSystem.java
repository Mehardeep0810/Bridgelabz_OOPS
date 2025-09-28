package Assigned10;

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemDetails() {
        return "Item: " + itemName + ", Price: ₹" + price + ", Quantity: " + quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract double calculateTotalPrice();
}

interface Discountable {
    void applyDiscount(double percent);
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    private double discount = 0;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        double total = getPrice() * getQuantity();
        return total - (total * discount / 100);
    }

    public void applyDiscount(double percent) {
        discount = percent;
    }

    public String getDiscountDetails() {
        return "Veg item discount: " + discount + "%";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double discount = 0;
    private final double nonVegCharge = 50;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        double total = (getPrice() * getQuantity()) + nonVegCharge;
        return total - (total * discount / 100);
    }

    public void applyDiscount(double percent) {
        discount = percent;
    }

    public String getDiscountDetails() {
        return "Non-veg item discount: " + discount + "%";
    }
}

public class FoodOrderSystem {
    public static void processOrder(FoodItem item) {
        System.out.println(item.getItemDetails());
        System.out.println("Total Price: ₹" + item.calculateTotalPrice());

        if (item instanceof Discountable) {
            Discountable d = (Discountable) item;
            System.out.println(d.getDiscountDetails());
        }

        System.out.println("-----");
    }

    public static void main(String[] args) {
        FoodItem veg = new VegItem("Paneer Tikka", 200, 2);
        FoodItem nonVeg = new NonVegItem("Chicken Biryani", 250, 1);

        ((Discountable) veg).applyDiscount(10);
        ((Discountable) nonVeg).applyDiscount(5);

        processOrder(veg);
        processOrder(nonVeg);
    }
}