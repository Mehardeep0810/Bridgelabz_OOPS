package Assigned10;

import java.util.*;

// Abstract class
abstract class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getters and Setters (Encapsulation)
    public String getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }

    // Abstract method
    public abstract double calculateDiscount();
}

// Interface
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Electronics class
class Electronics extends Product implements Taxable {
    public Electronics(String productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    public double calculateTax() {
        return getPrice() * 0.18;
    }

    public String getTaxDetails() {
        return "18% GST on Electronics";
    }
}

// Clothing class
class Clothing extends Product implements Taxable {
    public Clothing(String productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.15;
    }

    public double calculateTax() {
        return getPrice() * 0.05;
    }

    public String getTaxDetails() {
        return "5% GST on Clothing";
    }
}

// Groceries class
class Groceries extends Product {
    public Groceries(String productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}

// Main class
public class ECommerceApp {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Electronics("E101", "Laptop", 50000));
        products.add(new Clothing("C202", "T-Shirt", 800));
        products.add(new Groceries("G303", "Rice Bag", 1200));

        for (Product p : products) {
            double price = p.getPrice();
            double discount = p.calculateDiscount();
            double tax = 0;

            if (p instanceof Taxable) {
                Taxable t = (Taxable) p;
                tax = t.calculateTax();
                System.out.println(t.getTaxDetails());
            }

            double finalPrice = price + tax - discount;
            System.out.printf("Product: %s | Final Price: ₹%.2f%n", p.getName(), finalPrice);
        }
    }
}