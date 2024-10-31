package com.pluralsight;

import java.util.List;
import java.util.Scanner;


public class UserInterface {
    private Dealership dealership; // Dealership instance
    private DealershipFileManager fileManager = new DealershipFileManager(); // File manager instance
    private Scanner scanner = new Scanner(System.in); // Scanner for user input

    public UserInterface() {
        // Load dealership data when the user interface is initialized
    }


    public void display() {
        dealership = fileManager.getDealership(); // Load dealership data from the file

        while (true) {
            System.out.println("\nDEALERSHIP MENU: ");
            System.out.println("\t1 - Search by Price");
            System.out.println("\t2 - Search by Make/Model");
            System.out.println("\t3 - Search by Year");
            System.out.println("\t4 - Search by Color");
            System.out.println("\t5 - Search by Mileage");
            System.out.println("\t6 - Search by Type");
            System.out.println("\t7 - List All Vehicles");
            System.out.println("\t8 - Add a Vehicle");
            System.out.println("\t9 - Remove a Vehicle");
            System.out.println("\t99 - Exit");

            int choice = scanner.nextInt(); // Get user choice
            scanner.nextLine(); // Consume the newline

            // Handle user choices
            switch (choice) {
                case 1 -> searchByPrice();
                case 2 -> searchByMakeModel();
                case 3 -> searchByYear();
                case 4 -> searchByColor();
                case 5 -> searchByMileage();
                case 6 -> searchByType();
                case 7 -> listAllVehicles();
                case 8 -> addVehicle();
                case 9 -> removeVehicle();
                case 99 -> {
                    return; // Exit the program
                }
                default -> System.out.println("Error: Invalid option."); // Handle invalid input
            }
        }
    }

    public void searchByPrice() {
        System.out.print("Enter minimum price: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double maxPrice = scanner.nextDouble();

        // Display vehicles in the specified price range
        displayVehicles(dealership.getVehiclesByPrice(minPrice, maxPrice));
    }

    public void searchByMakeModel() {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        // Display vehicles by make and model
        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }

    public void searchByYear() {
        System.out.print("Enter minimum year: ");
        int minYear = scanner.nextInt();
        System.out.print("Enter maximum year: ");
        int maxYear = scanner.nextInt();

        // Display vehicles by year range
        displayVehicles(dealership.getVehiclesByYear(minYear, maxYear));
    }

    public void searchByColor() {
        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        // Display vehicles by color
        displayVehicles(dealership.getVehiclesByColor(color));
    }

    public void searchByMileage() {
        System.out.print("Enter minimum mileage: ");
        double minMileage = scanner.nextDouble();
        System.out.print("Enter maximum mileage: ");
        double maxMileage = scanner.nextDouble();

        // Display vehicles by mileage range
        displayVehicles(dealership.getVehiclesByMileage(minMileage, maxMileage));
    }

    public void searchByType() {
        System.out.print("Enter vehicle type: ");
        String type = scanner.nextLine();

        // Display vehicles by type
        displayVehicles(dealership.getVehiclesByType(type));
    }

    public void listAllVehicles() {
        // Display all vehicles in the dealership
        displayVehicles(dealership.getAllVehicles());
    }

    public void addVehicle() {
        // Collect vehicle details and add to the inventory
        System.out.print("Enter VIN: ");
        int vin = scanner.nextInt();
        System.out.print("Enter Year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Make: ");
        String make = scanner.nextLine();
        System.out.print("Enter Model: ");
        String model = scanner.nextLine();
        System.out.print("Enter Type: ");
        String type = scanner.nextLine();
        System.out.print("Enter Color: ");
        String color = scanner.nextLine();
        System.out.print("Enter Odometer: ");
        int odometer = scanner.nextInt();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();

        // Create a new vehicle object and add it to the dealership
        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(vehicle);
        System.out.println("Vehicle added successfully!");
    }

    public void removeVehicle() {
        System.out.print("Enter VIN of the vehicle to remove: ");
        int vin = scanner.nextInt();

        // Find the vehicle by VIN and remove it
        Vehicle vehicle = dealership.getVehiclesByVin(vin);
        if (vehicle != null) {
            dealership.removeVehicle(vehicle);
            System.out.println("Vehicle removed successfully!");
        } else {
            System.out.println("Vehicle not found.");
        }
    }


    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            // Formatter for the table
            String formatter = "| %-6s | %-15s | %-15s | %-5d | %-8d | $%.2f |%n";

            // Print table header
            System.out.format("+--------+-----------------+-----------------+-------+----------+------------+%n");
            System.out.printf("| VIN    | Make            | Model           | Year  | Mileage  | Price      |%n");
            System.out.format("+--------+-----------------+-----------------+-------+----------+------------+%n");

            // Print each vehicle's details
            for (Vehicle vehicle : vehicles) {
                System.out.format(formatter, vehicle.getVin(), vehicle.getMake(), vehicle.getModel(),
                        vehicle.getYear(), vehicle.getOdometer(), vehicle.getPrice());
            }
            System.out.format("+--------+-----------------+-----------------+-------+----------+------------+%n");
        }
    }
}



