package practicaPolimorfismo;

// Base class (already done for you)
abstract class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Abstract method - MUST be implemented by child classes
    public abstract void makeSound();

    // Abstract method - MUST be implemented by child classes
    public abstract void eat();

    // Regular method - can be used by all animals
    public void sleep() {
        System.out.println(name + " is sleeping... Zzz");
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// TODO: Create a Dog class that extends Animal
class Dog extends Animal  {
    public Dog(String name, int age) {
        super(name, age);
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
    }
    @Override
    public void sleep() {
        super.sleep();
    }
    // - Override makeSound() to print "Woof! Woof!"
    @Override
    public void makeSound(){
        System.out.println("Woof! Woof!");
    }
// - Override eat() to print "Dog is eating dog food"
    @Override
    public void eat(){
        System.out.println("Dog is eating dog food");
    }
// - Add a method: fetch()
    public void fetch(){
        System.out.println("Dog goes catch the ball");
    }
}
// TODO: Create a Cat class that extends Animal
class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
    }
    @Override
    public void sleep() {
        super.sleep();
    }
    // - Override makeSound() to print "Meow!"
    public void makeSound(){
        System.out.println("Meow!");
    }
    // - Override eat() to print "Cat is eating fish"
    @Override
    public void eat(){
        System.out.println("Cat is eating fish");
    }
// - Add a method: scratch()
    public void scratch(){
        System.out.println("Cat scratches the mat");
    }
}
// TODO: Create a Bird class that extends Animal
class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
    }
    @Override
    public void sleep(){
        super.sleep();
    }
    // - Override makeSound() to print "Tweet! Tweet!"
    @Override
    public void makeSound(){
        System.out.println("Tweet! Tweet!");
    }
// - Override eat() to print "Bird is eating seeds"
    @Override
    public void eat(){

    }
// - Add a method: fly()
    public void fly(){
        System.out.println("Bird flies across the room");
    }
}
// Test class (already done for you)
class Main {
    public static void main(String[] args) {
        // Polymorphism: Animal reference, different object types
        Animal[] animals = new Animal[3];
        animals[0] = new Dog("Buddy", 3);
        animals[1] = new Cat("Whiskers", 2);
        animals[2] = new Bird("Tweety", 1);

        // Loop through and call the same methods - polymorphism in action!
        for (Animal animal : animals) {
            animal.displayInfo();
            animal.makeSound();  // Different sound for each!
            animal.eat();        // Different eating behavior!
            animal.sleep();      // Same for all
            System.out.println();
        }

        // You can also do this:
        makeAnimalSpeak(new Dog("Max", 5));
        makeAnimalSpeak(new Cat("Luna", 4));
        makeAnimalSpeak(new Bird("Chirpy", 1));
    }

    // This method accepts ANY Animal - that's polymorphism!
    public static void makeAnimalSpeak(Animal animal) {
        System.out.print(animal.name + " says: ");
        animal.makeSound();
    }
}