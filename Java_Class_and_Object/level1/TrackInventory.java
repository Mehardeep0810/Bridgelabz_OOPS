package Assigned6.level1;

class Item {
    int itemCode;
    String itemName;
    double price;

    void displayDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per unit: ₹" + price);
    }

    double calculateTotalCost(int quantity) {
        return price * quantity;
    }
}

public class TrackInventory {
    public static void main(String[] args) {
        Item item = new Item();
        item.itemCode = 101;
        item.itemName = "Wireless Mouse";
        item.price = 799.00;

        item.displayDetails();

        int quantity = 3;
        double total = item.calculateTotalCost(quantity);
        System.out.println("Total cost for " + quantity + " units: " + total);
    }
}