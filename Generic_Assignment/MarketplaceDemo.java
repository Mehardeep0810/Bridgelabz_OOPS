public class MarketplaceDemo {

    interface BookCategory {}
    interface ClothingCategory {}
    interface GadgetCategory {}

    static class Product<T> {
        private String name;
        private double price;
        private T category;

        public Product(String name, double price, T category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }

        public String getName() { return name; }
        public double getPrice() { return price; }
        public T getCategory() { return category; }

        public void setPrice(double price) { this.price = price; }

        @Override
        public String toString() {
            return name + " (" + category.getClass().getSimpleName() + ")" + price;
        }
    }

    static class MarketplaceUtils {
        public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
            double discount = product.getPrice() * (percentage / 100);
            product.setPrice(product.getPrice() - discount);
            System.out.println("Applied " + percentage + "% discount to " + product.getName());
        }
    }

    public static void main(String[] args) {

        Product<BookCategory> book = new Product<>("Java Programming", 50.0, new BookCategory(){});
        Product<ClothingCategory> shirt = new Product<>("Cotton Shirt", 30.0, new ClothingCategory(){});
        Product<GadgetCategory> phone = new Product<>("Smartphone", 500.0, new GadgetCategory(){});

        MarketplaceUtils.applyDiscount(book, 10);  
        MarketplaceUtils.applyDiscount(shirt, 20);  
        MarketplaceUtils.applyDiscount(phone, 5);   

        System.out.println("\nCatalog:");
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(phone);
    }
}
