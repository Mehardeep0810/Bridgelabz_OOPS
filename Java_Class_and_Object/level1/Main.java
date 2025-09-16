package Assigned6.level1;

class Circle {
    double radius;

    Circle(double r) {
        radius = r;
    }

    double getArea() {
        return 3.141 * radius * radius;
    }
}

public class Main {
    public static void main(String[] args) {
        Circle c = new Circle(5); 
        System.out.println("Area of the circle: " + c.getArea());
    }
}
