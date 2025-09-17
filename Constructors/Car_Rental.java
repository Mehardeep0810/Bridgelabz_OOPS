package Assigned7.level1;

public class Car_Rental {
    String customerName;
    String carModel; 
    int rentalDays;
    int pricePerDay;

    public Car_Rental(String customerName, String carModel, int rentalDays, int pricePerDay) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.pricePerDay = pricePerDay;
    }

    public void displayInfo() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Price Per Day: " + pricePerDay);
        System.out.println("Total Cost: " + (rentalDays * pricePerDay));
    }

    public static void main(String[] args) {

        Car_Rental customCar = new Car_Rental("Mehardeep", "Fortuner", 5, 10000);
        customCar.displayInfo();
    }
}
