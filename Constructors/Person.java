package Assigned7.level1;

public class Person {
    String name;
    int age;
    String address;
    String phoneNumber;

    Person(String name, int age, String address, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    Person(Person p) {
        this.name = p.name;
        this.age = p.age;
        this.address = p.address;
        this.phoneNumber = p.phoneNumber;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNumber);
    }

    public static void main(String[] args) {
        Person person1 = new Person("Mehar", 30, "123 xyz", "8755647839");
        Person person2 = new Person(person1); 
        System.out.println("Person 1 details:");
        person1.display();

        System.out.println("\nPerson 2 details (copied from Person 1):");
        person2.display();
    }


}
