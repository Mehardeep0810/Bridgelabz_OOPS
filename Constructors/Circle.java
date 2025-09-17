package Assigned7.level1;

public class Circle {
    double radius;

    public Circle() {
        radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public void displayRadius() {
        System.out.println("Radius: " + radius);
    }

    public static void main(String[] args) {
        Circle defaultCircle = new Circle();         
        Circle customCircle = new Circle(5.5);      

        defaultCircle.displayRadius();               
        customCircle.displayRadius();               
    }
}