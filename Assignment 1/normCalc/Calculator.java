public class Calculator{

    public double calculate(double a, double b, int choice) {

        if (choice == 1) {
            return a + b;
        } 
        else if (choice == 2) {
            return a - b;
        } 
        else if (choice == 3) {
            return a * b;
        } 
        else if (choice == 4) {
            if (b != 0) {
                return a / b;
            } 
            else {
                System.out.println("Error: Division by zero");
                return 0;
            }
        } 
        else {
            System.out.println("Invalid choice");
            return 0;
        }
    }
}

