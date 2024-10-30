package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private DealershipFileManager fileManager;
    private Scanner scanner;

    public UserInterface(String fileName) {
        fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership(fileName);
        this.scanner = new Scanner(System.in);
    }

    public void display() {
        int menuOption;
        do {
            System.out.println("Welcome to the Dealership! Please pick from the following options:");
            System.out.println("1. Show all vehicles");
            System.out.println("2. Add a new vehicle");
            System.out.println("3. Delete a vehicle");
            System.out.println("4. Search for a vehicle");
            System.out.println("5. Show vehicles by price range");
            System.out.println("6. Exit");
            System.out.print("What would you like to do? (1-6): ");

            menuOption = scanner.nextInt();
            switch (menuOption) {
                case 1 -> showAllVehicles();
                case 2 -> addVehicle();
                case 3 -> removeVehicle();
                case 4 -> searchVehicle();
                case 5 -> showVehiclesByPriceRange();
                case 6 -> System.out.println("Exiting program...");
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while (menuOption != 6);
    }

    private void showAllVehicles() {
        displayVehicles(dealership.getAllVehicles());
    }

    private void addVehicle() {
        System.out.println("Enter vehicle details (VIN, year, make, model, type, color, odometer, price):");
        String vin = scanner.next();
        int year = scanner.nextInt();
        String make = scanner.next();
        String model = scanner.next();
        String type = scanner.next();
        String color = scanner.next();
        int odometer = scanner.nextInt();
        double price = scanner.nextDouble();

        Vehicle newVehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(newVehicle);
        fileManager.saveDealership(dealership);
        System.out.println("Vehicle added successfully.");
    }

    private void removeVehicle() {
        System.out.print("Enter VIN of the vehicle to remove: ");
        String vin = scanner.next();
        Vehicle vehicleToRemove = dealership.getVehiclesByVIN(vin);
        if (vehicleToRemove != null) {
            dealership.removeVehicle(vehicleToRemove);
            fileManager.saveDealership(dealership);
            System.out.println("Vehicle removed successfully.");
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    private void searchVehicle() {
        System.out.print("Enter VIN of the vehicle to search: ");
        String vin = scanner.next();
        Vehicle foundVehicle = dealership.getVehiclesByVIN(vin);

        if (foundVehicle != null) {
            System.out.printf("Found Vehicle: VIN: %s, Make: %s, Model: %s, Year: %d, Price: %.2f%n",
                    foundVehicle.getVin(), foundVehicle.getMake(), foundVehicle.getModel(), foundVehicle.getYear(), foundVehicle.getPrice());
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    private void showVehiclesByPriceRange() {
        System.out.print("Enter minimum price: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double maxPrice = scanner.nextDouble();

        List<Vehicle> vehiclesInRange = dealership.getVehiclesByPriceRange(minPrice, maxPrice);

        if (vehiclesInRange.isEmpty()) {
            System.out.println("No vehicles found in this price range.");
        } else {
            displayVehicles(vehiclesInRange);
        }
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }
        for (Vehicle vehicle : vehicles) {
            System.out.printf("VIN: %s, Make: %s, Model: %s, Year: %d, Price: %.2f%n",
                    vehicle.getVin(), vehicle.getMake(), vehicle.getModel(), vehicle.getYear(), vehicle.getPrice());
        }
    }
}


