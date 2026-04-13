package assignment_2_constructors;
class Car {
    String brand;
    double price;

    // 1. Parameterized constructor accepting brand and price
    public Car(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    // 2. display() method to print the car details
    public void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Price: $" + price);
        System.out.println();
    }
}

public class Main3 {
    public static void main(String[] args) {
        // 3. Create at least 3 different Car objects with different brands
        Car car1 = new Car("Toyota", 25000.0);
        Car car2 = new Car("Honda", 28000.0);
        Car car3 = new Car("Tesla", 45000.0);

        // 4. Call display() on each object
        car1.display();
        car2.display();
        car3.display();
    }
}


