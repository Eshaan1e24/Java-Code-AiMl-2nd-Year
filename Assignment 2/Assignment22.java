import java.util.Scanner;

class VehicleApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Vehicle[] vehicles = new Vehicle[5];
        int count = 0;
        int choice;

        do {
            System.out.println("\nMenu");
            System.out.println("1) Add vehicle");
            System.out.println("2) Display all vehicles");
            System.out.println("3) Update mileage after trip");
            System.out.println("4) Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    if (count >= vehicles.length) {
                        System.out.println("Vehicle list full!");
                        break;
                    }

                    System.out.print("Enter brand: ");
                    String brand = sc.next();

                    System.out.print("Enter model: ");
                    String model = sc.next();

                    System.out.print("Enter Manufacture year: ");
                    int year = sc.nextInt();

                    System.out.print("Enter Current mileage: ");
                    double mileage = sc.nextDouble();

                    System.out.print("Enter Engine capacity: ");
                    double engineCapacity = sc.nextDouble();

                    vehicles[count] =
                            new Vehicle(brand, model, year, mileage, engineCapacity);
                    count++;

                    System.out.println("Vehicle added successfully.");
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No vehicles available.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            System.out.println("\nVehicle " + (i + 1));
                            vehicles[i].displayDetails();
                        }
                    }
                    break;

                case 3:
                    if (count == 0) {
                        System.out.println("No vehicles available.");
                        break;
                    }

                    System.out.print("Enter vehicle number: ");
                    int num = sc.nextInt();

                    if (num < 1 || num > count) {
                        System.out.println("Invalid vehicle number.");
                        break;
                    }

                    System.out.print("Enter trip distance (km): ");
                    double trip = sc.nextDouble();

                    vehicles[num - 1].addTripDistance(trip);
                    System.out.println("Mileage updated.");
                    break;

                case 4:
                    System.out.println("Program exited.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }}
