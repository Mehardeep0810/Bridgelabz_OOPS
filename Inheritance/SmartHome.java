

class Device{
    int DeviceID = 101;
    String status = "Active";

}
class Thermostat extends Device{
    int temperatureSetting = 22;
    public void displayThermostatInfo(){
        System.out.println("Device ID: " + DeviceID);
        System.out.println("Status: " + status);
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}
public class SmartHome {
    public static void main(String [] args){
        Thermostat thermostat = new Thermostat();
        thermostat.displayThermostatInfo();
    }
}
