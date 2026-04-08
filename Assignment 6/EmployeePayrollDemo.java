import java.util.ArrayList;

public class EmployeePayrollDemo {

    // Tax calculation based on gross salary
    public static double calculateTax(double gross) {
        if (gross <= 20000)      return 0.0;
        else if (gross <= 50000) return gross * 0.10;
        else                     return gross * 0.20;
    }

    // Print payslip for any employee (works for all types via polymorphism)
    public static void printPayslip(Employee emp) {
        System.out.println("\n====== PAYSLIP ======");
        emp.printHeader();

        System.out.println("---- Salary Breakdown ----");
        emp.printComponents();

        double gross = emp.calculateGross();
        double tax   = calculateTax(gross);
        double net   = gross - tax;

        System.out.println("---- Summary ----");
        System.out.println("  Gross  : INR " + gross);
        System.out.println("  Tax    : INR " + tax);
        System.out.println("  NET    : INR " + net);
        System.out.println("=====================");
    }

    public static void main(String[] args) {

        ArrayList<Employee> staff = new ArrayList<>();

        // Single inheritance
        staff.add(new PermanentEmployee(101, "Priya Sharma", 40000));

        // Hierarchical inheritance
        staff.add(new ContractEmployee(102, "Rahul Verma", 160, 250));

        // Multilevel inheritance
        staff.add(new Manager(103, "Sunita Rao", 80000, 15000));

        // Print payslips for all
        for (Employee e : staff) {
            printPayslip(e);
        }
    }
}
