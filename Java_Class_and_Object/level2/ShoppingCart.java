package Assigned6.level2;

class CartItem {
    String itemName;
    double price;
    int quantity;

    void addItem(String name, double itemPrice, int qty) {
        itemName = name;
        price = itemPrice;
        quantity = qty;
        System.out.println("Item added to cart.");
    }

    void removeItem() {
        itemName = "";
        price = 0.0;
        quantity = 0;
        System.out.println("Item removed from cart.");
    }

    void displayTotalCost() {
        double total = price * quantity;
        System.out.println("Item: " + itemName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: ₹" + total);
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        CartItem cart = new CartItem();
        cart.addItem("Bluetooth Speaker", 1499.00, 2);
        cart.displayTotalCost();

        cart.removeItem();
        cart.displayTotalCost(); 
    }
}