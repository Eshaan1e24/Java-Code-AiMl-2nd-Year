import java.util.Scanner;

public class CalcApp{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calc cal = new Calc();

        System.out.print("Enter first number: ");
        double a = sc.nextDouble();

        System.out.print("Enter second number: ");
        double b = sc.nextDouble();

        System.out.println("Choose operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        System.out.print("Enter your choice (1-4): ");
        int choice = sc.nextInt();

        double result = cal.calc(a, b, choice);
        System.out.println("Result = " + result);

        sc.close();
    }
}
