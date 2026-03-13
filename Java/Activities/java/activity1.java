
class Car {
    String color;
    int make;
    String transmission;
    int tyres;
    int doors;

    public Car() {
        tyres = 4;
        doors = 4;
    }

    public void displayCharacteristics() {  // ✅ Correct spelling
        System.out.println("Color: " + color);
        System.out.println("Make: " + make);
        System.out.println("Transmission: " + transmission);
        System.out.println("Doors: " + doors);
        System.out.println("Tyres: " + tyres);
    }

    public void accelerate() {
        System.out.println("Car is moving forward.");
    }

    public void brake() {
        System.out.println("Car has stopped.");
    }
}

public class activity1 {
    public static void main(String[] args) {
        Car toyota = new Car();
        toyota.make = 2014;
        toyota.color = "Black";
        toyota.transmission = "Manual";

        toyota.displayCharacteristics();  // ✅ Match method name
        toyota.accelerate();
        toyota.brake();
    }
}