package Assigned7.level1;

public class BookDetails{

    String title;
    String author;
    double price;

    public BookDetails() {
        System.out.println("Entering BookDetails constructor");
        this.title = "";
        this.author = "";
        this.price = 0.0;
    }

    public BookDetails(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
    public void Display(){
        System.out.println(title+" "+author+" "+price);
    }
    public static void main(String[] args) {
        BookDetails book1 = new BookDetails();
        BookDetails book2 = new BookDetails("Effective Java", "Joshua Bloch", 45.00);
        BookDetails book3 = new BookDetails("Clean Code", "Robert C. Martin", 40.00);
        book1.Display();
        book2.Display();    
        book3.Display();
    }

}



