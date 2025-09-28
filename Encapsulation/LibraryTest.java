package Assigned10;

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemDetails() {
        return "ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }

    public abstract int getLoanDuration();
}

interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    private boolean isAvailable = true;
    private String borrowerName;

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 21;
    }

    public void reserveItem(String borrowerName) {
        if (isAvailable) {
            this.borrowerName = borrowerName;
            isAvailable = false;
            System.out.println("Book reserved for " + borrowerName);
        } else {
            System.out.println("Book is not available.");
        }
    }

    public boolean checkAvailability() {
        return isAvailable;
    }

    public String getBorrowerName() {
        return borrowerName;
    }
}

class Magazine extends LibraryItem implements Reservable {
    private boolean isAvailable = true;

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 7;
    }

    public void reserveItem(String borrowerName) {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Magazine reserved for " + borrowerName);
        } else {
            System.out.println("Magazine is not available.");
        }
    }

    public boolean checkAvailability() {
        return isAvailable;
    }
}

class DVD extends LibraryItem implements Reservable {
    private boolean isAvailable = true;

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 14;
    }

    public void reserveItem(String borrowerName) {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("DVD reserved for " + borrowerName);
        } else {
            System.out.println("DVD is not available.");
        }
    }

    public boolean checkAvailability() {
        return isAvailable;
    }
}

public class LibraryTest {
    public static void main(String[] args) {
        LibraryItem[] items = {
            new Book("B001", "Java Basics", "Mehardeep"),
            new Magazine("M001", "Tech Monthly", "Editor A"),
            new DVD("D001", "AI Revolution", "Director B")
        };

        for (LibraryItem item : items) {
            System.out.println(item.getItemDetails());
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                ((Reservable) item).reserveItem("Alice");
                System.out.println("Available: " + ((Reservable) item).checkAvailability());
            }

            System.out.println("-----");
        }
    }
}