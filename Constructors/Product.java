package Assigned7.level1;

public class Product {
    String productName;
    double price;

    private static int totalProducts = 0;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
    }

    public static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }

    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 50000);
        Product product2 = new Product("Smartphone", 30000);

        product1.displayProductDetails();
        product2.displayProductDetails();

        Product.displayTotalProducts();
    }
}
