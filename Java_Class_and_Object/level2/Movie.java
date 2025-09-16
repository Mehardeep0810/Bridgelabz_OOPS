package Assigned6.level2;

class MovieTicket {
    String movieName;
    int seatNumber;
    double price;

    void bookTicket(String name, int seat, double cost) {
        movieName = name;
        seatNumber = seat;
        price = cost;
        System.out.println("Ticket booked successfully!");
    }

    void displayTicket() {
        System.out.println("Movie Name: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: " + price);
    }
}

public class Movie {
    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket();
        ticket.bookTicket("Jawan", 12, 250.00);
        ticket.displayTicket();
    }
}
