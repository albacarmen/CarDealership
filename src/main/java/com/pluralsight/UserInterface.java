package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private DealershipFileManager fileManager;
    private Scanner sc = new Scanner(System.in);

    public UserInterface(String fileName) {
        fileManager = new DealershipFileManager(fileName);
        init();
    }

    private void init() {
        dealership = fileManager.getDealership();
    }

    public void display() {
        int menuOption;
        do {
            showMenu();
            menuOption = sc.nextInt();
            processMenuOption(menuOption);
        } while (menuOption != 6);
    }

    private void showMenu() {
        System.out.println("Welcome to the Dealership! Please pick from the following options:");
        System.out.println("1. Show all vehicles");
        System.out.println("2. Add a new vehicle");
        System.out.println("3. Delete a vehicle");
        System.out.println("4. Search for a vehicle");
        System.out.println("5. Show vehicles by price range");
        System.out.println("6. Exit");
    }

    private void processMenuOption(int option) {
        switch (option) {
            case 1 -> processGetAllVehiclesRequest();
            case 2 -> processAddVehicleRequest();
            case 3 -> processRemoveVehicleRequest();
            case 4 -> processGetByVinRequest();
            case 5 -> processGetByPriceRangeRequest();
            case 6 -> {
                fileManager.saveDealership(dealership); // Save before exiting
                System.out.println("Exiting program...");
            }
            default -> System.out.println("Invalid option. Please try again.");
        }
    }

    private void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    private void displayVehicles(Iterable<Vehicle> vehicles) {
        if (!vehicles.iterator().hasNext()) {
            System.out.println("No vehicles available.");
            return;
        }
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getVin() + ": " + vehicle.getMake() + " " + vehicle.getModel() + " - $" + vehicle.getPrice());
        }
    }

    private void processAddVehicleRequest() {

    }

    private void processRemoveVehicleRequest() {

    }

    private void processGetByVinRequest() {

    }

    private void processGetByPriceRangeRequest() {

    }
}
