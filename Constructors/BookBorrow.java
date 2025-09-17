package Assigned7.level1;

public class BookBorrow {
    String title;
    String author;
    String price;
    String availability;


    public BookBorrow(String title, String author, String price, String availability) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = availability;
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Availability: " + availability);
    }

    public static void main(String[] args) {

        BookBorrow customBook = new BookBorrow("1984", "George Orwell", "15.99", "Available");
        customBook.displayInfo();
    }


}
