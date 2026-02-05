public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();

        // Add items to the menu
        menu.addItem("Home");
        menu.addItem("About Us");
        menu.addItem("Contact Us");

        // Display the menu
        System.out.println(menu);
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}