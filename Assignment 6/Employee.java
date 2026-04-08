// -------------------- Base Class --------------------
class Employee {

    int empId;
    String empName;
    double basicSalary;

    public Employee(int id, String name, double basic) {
        this.empId = id;
        this.empName = name;
        this.basicSalary = basic;
    }

    // Base gross = just basic salary
    public double calculateGross() {
        return basicSalary;
    }

    public String getEmployeeType() {
        return "EMPLOYEE";
    }

    public void printComponents() {
        System.out.println("  Basic          : INR " + basicSalary);
    }

    public void printHeader() {
        System.out.println("  EmpID          : " + empId);
        System.out.println("  Name           : " + empName);
        System.out.println("  Type           : " + getEmployeeType());
    }
}

// -------------------- Single Inheritance: Employee -> PermanentEmployee --------------------
class PermanentEmployee extends Employee {

    double hra;  // 20% of basic
    double da;   // 15% of basic

    public PermanentEmployee(int id, String name, double basic) {
        super(id, name, basic);
        this.hra = basic * 0.20;
        this.da  = basic * 0.15;
    }

    @Override
    public String getEmployeeType() {
        return "PERMANENT";
    }

    @Override
    public double calculateGross() {
        return basicSalary + hra + da;
    }

    @Override
    public void printComponents() {
        System.out.println("  Basic          : INR " + basicSalary);
        System.out.println("  HRA (20%)      : INR " + hra);
        System.out.println("  DA  (15%)      : INR " + da);
    }
}

// -------------------- Hierarchical Inheritance: Employee -> ContractEmployee --------------------
class ContractEmployee extends Employee {

    int hoursWorked;
    double hourlyRate;

    public ContractEmployee(int id, String name, int hoursWorked, double hourlyRate) {
        super(id, name, hoursWorked * hourlyRate); // basic = hours x rate
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String getEmployeeType() {
        return "CONTRACT";
    }

    @Override
    public double calculateGross() {
        return basicSalary; // already computed in constructor
    }

    @Override
    public void printComponents() {
        System.out.println("  Hours Worked   : " + hoursWorked);
        System.out.println("  Hourly Rate    : INR " + hourlyRate);
        System.out.println("  Earnings       : INR " + basicSalary);
    }
}

// -------------------- Multilevel Inheritance: Employee -> PermanentEmployee -> Manager --------------------
class Manager extends PermanentEmployee {

    double bonus;
    double travelAllowance; // 10% of basic

    public Manager(int id, String name, double basic, double bonus) {
        super(id, name, basic);
        this.bonus = bonus;
        this.travelAllowance = basic * 0.10;
    }

    @Override
    public String getEmployeeType() {
        return "MANAGER";
    }

    @Override
    public double calculateGross() {
        return super.calculateGross() + bonus + travelAllowance;
    }

    @Override
    public void printComponents() {
        super.printComponents(); // reuse permanent breakdown
        System.out.println("  Bonus          : INR " + bonus);
        System.out.println("  Travel (10%)   : INR " + travelAllowance);
    }
}
