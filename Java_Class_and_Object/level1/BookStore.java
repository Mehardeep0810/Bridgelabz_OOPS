package Assigned6.level1;

class Book {
    String title;
    String author;
    double price;

    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}

public class BookStore {
    public static void main(String[] args) {
        Book b = new Book();
        b.title = "The Silent Patient";
        b.author = "Mehardeep";
        b.price = 499.00;

        b.displayDetails();
    }
}
