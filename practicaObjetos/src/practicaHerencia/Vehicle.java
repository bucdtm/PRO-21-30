package practicaHerencia;

// Base class (already done for you)
public class Vehicle {
    private String brand;
    private String model;
    private int year;

    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }

    public void start() {
        System.out.println("The vehicle is starting...");
    }

    // Getters
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
}

// TODO: Create a Car class that extends Vehicle
class Car extends Vehicle {
    // - Add a field: numberOfDoors (int)
    int numberOfDoors;

    // - Create a constructor that calls the parent constructor
    public Car(String brand, String model, int year, int numberOfDoors) {
        super(brand, model, year);
        this.numberOfDoors = numberOfDoors;
    }

// - Override the start() method to print "The car engine is starting..."
    @Override
    public void start() {
        System.out.println("The car is starting...");
    }
// - Override displayInfo() to show all info including numberOfDoors
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Doors: " + numberOfDoors);
    }
// - Add a method: openTrunk()
    public void openTrunk(){
        System.out.println("Trunk opened!");
    }
}
// TODO: Create a Motorcycle class that extends Vehicle
class Motorcycle extends Vehicle {
// - Add a field: hasSidecar (boolean)
    boolean hasSidecar;
// - Create a constructor that calls the parent constructor
    public Motorcycle(String brand, String model, int year, boolean hasSidecar) {
        super(brand, model, year);
        this.hasSidecar = hasSidecar;
    }
// - Override the start() method to print "The motorcycle is roaring to life..."
    @Override
    public void start() {
        System.out.println("The motorcycle is roaring to life...");
    }
// - Override displayInfo() to show all info including hasSidecar
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Has Sidecar: " + hasSidecar);
    }
// - Add a method: doWheelie()
    public void doWheelie(){
        System.out.println("Motorcycle does a wheelie!");
    }
}
// Test class (already done for you)
class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 2023, 4);
        car.displayInfo();
        car.start();
        car.openTrunk();

        System.out.println();

        Motorcycle bike = new Motorcycle("Harley-Davidson", "Street 750", 2022, false);
        bike.displayInfo();
        bike.start();
        bike.doWheelie();

        // Polymorphism test:
        Vehicle vehicle1 = new Car("Honda", "Civic", 2024, 4);
        Vehicle vehicle2 = new Motorcycle("Yamaha", "R1", 2023, false);

        vehicle1.start();  // Should call Car's start()
        vehicle2.start();  // Should call Motorcycle's start()
    }
}