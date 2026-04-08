import java.util.Scanner;
class vehicle{
    //instance variables (data members)
    private String brand;
    private String model;
    private int year;
    private double mileage;
    private double engineCapacity;

    //cpnstructor with different argument names
    vehicle(String brandName, String modelName, int manufactureYear, double currentMileage, double engineCC){

        brand= brandName;
        model=modelName;
        year= manufactureYear;
        mileage= currentMileage;
        engineCapacity= engineCC;
    }
    //getter methods
    String getBrand(){
        return brand;
    }
    String getModel(){
        return model;
    }
    int getYear(){
        return year;
    }
    double getMileage(){
        return mileage;
    }
    double getEngineCapacity(){
        return engineCapacity;
    }


    //Setter-like method to update mileage after trip
    void addTripDistance(double distance){
        mileage=mileage+distance;
    }

    //method to display vehicle details
    void displayDetails() {
    System.out.println("Vehicle Details:");
    System.out.println("Brand: " + brand);
    System.out.println("Model: " + model);
    System.out.println("Year: " + year);
    System.out.println("Mileage: " + mileage + " km");
    System.out.println("Engine Capacity: " + engineCapacity + " cc");
}

}