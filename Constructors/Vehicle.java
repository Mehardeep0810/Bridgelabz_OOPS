package Assigned7.level1;

public class Vehicle {
    private String ownerName;
    private String vehicleType;
    private static double registrationFee = 5000.0;

    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public static void main(String[] args) {
        Vehicle.updateRegistrationFee(6500.0);

        Vehicle v1 = new Vehicle("Mehardeep", "Car");
        Vehicle v2 = new Vehicle("Aman", "Motorcycle");

        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();
    }
}
