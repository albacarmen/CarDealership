package com.pluralsight;

import java.util.Scanner;

public class Program {
    private static final Scanner sc = new Scanner(System.in);
    private static Dealership dealership;

    public static void main(String[] args) {
        String fileName = "dealership.csv";
        DealershipFileManager fileManager = new DealershipFileManager(fileName);

        // Load dealership
        dealership = fileManager.getDealership();

        int menuOption;
        do {
            displayMenu();
            menuOption = sc.nextInt();
            handleMenuOption(menuOption, fileManager);
        } while (menuOption != 6);
    }

    public static void displayMenu() {
        System.out.println("Welcome to the Dealership! Please pick from the following options:");
        System.out.println("1. Show all vehicles");
        System.out.println("2. Add a new vehicle");
        System.out.println("3. Delete a vehicle");
        System.out.println("4. Search for a vehicle");
        System.out.println("5. Show vehicles by price range");
        System.out.println("6. Exit");
    }

    public static void handleMenuOption(int option, DealershipFileManager fileManager) {
        switch (option) {
            case 1 -> displayVehicles();
            case 2 -> addNewVehicle();
            case 3 -> deleteVehicle();
            case 4 -> searchVehicle();
            case 5 -> showVehiclesByPriceRange();
            case 6 -> {
                fileManager.saveDealership(dealership); // Save before exiting
                System.out.println("Exiting program...");
            }
            default -> System.out.println("Invalid option. Please try again.");
        }
    }

    public static void displayVehicles() {
        if (dealership.getAllVehicles().isEmpty()) {
            System.out.println("No vehicles available.");
            return;
        }
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            System.out.println(vehicle.getVin() + ": " + vehicle.getMake() + " " + vehicle.getModel() + " - $" + vehicle.getPrice());
        }
    }

    private static void addNewVehicle() {
        // Logic for adding
    }

    private static void deleteVehicle() {
        // Logic for deleting
    }

    private static void searchVehicle() {
        // Logic for searching
    }

    private static void showVehiclesByPriceRange() {
        // show
    }
}


