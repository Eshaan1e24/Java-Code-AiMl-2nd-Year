public class Calc{

    public double calc(double a, double b, int choice) {
        switch(choice){
            case 1:
                System.out.println("Doing Addition");
                return a+b;
            case 2:
                System.out.println("Doing Subtraction");
                return a-b;
            case 3:
                System.out.println("Doing Multiplication");
                return a*b;
            case 4:
                if(b==0){
                    System.out.println("No division by zero allowd!");
                    return 0;
                }
                else{
                System.out.println("Doing Multiplication");
                return a/b;                    
                }
            default:
                System.out.println("Invalid size number");
                return 0;
        }
    }
}

