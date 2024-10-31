package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class DealershipFileManager {
    private final String fileName; // File name for dealership data
    private final Dealership dealership; // Instance of Dealership

    public DealershipFileManager() {
        this.fileName = "new_dealership_data.csv"; // New file name for dealership data
        this.dealership = new Dealership("", "", ""); // Initialize dealership with empty values
    }


    public Dealership getDealership() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String input;

            // Vehicle attributes
            int vin;
            int year;
            String make;
            String model;
            String vehicleType;
            String color;
            int odometer;
            double price;

            // Read lines from the file
            while ((input = bufferedReader.readLine()) != null) {
                String[] strings = input.split("\\|");

                // Read dealership details if there are 3 parts
                if (strings.length == 3) {
                    String name = strings[0];
                    String address = strings[1];
                    String phone = strings[2];
                }

                // Read vehicle details if there are 8 parts
                if (strings.length == 8) {
                    vin = Integer.parseInt(strings[0]);
                    year = Integer.parseInt(strings[1]);
                    make = strings[2];
                    model = strings[3];
                    vehicleType = strings[4];
                    color = strings[5];
                    odometer = Integer.parseInt(strings[6]);
                    price = Double.parseDouble(strings[7]);

                    // Create a Vehicle object and add it to the dealership
                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    dealership.addVehicle(vehicle);
                }
            }
            return dealership; // Return the populated dealership object
        } catch (Exception e) {
            System.err.println("Error: Unable to read file."); // Error handling
        }
        return null;
    }


    public void overwriteDealership(Dealership dealership) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            // Write dealership details to the file
            bufferedWriter.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            bufferedWriter.newLine();
            // Write each vehicle's details to the file
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                bufferedWriter.write(vehicle.getVin() + "|" +
                        vehicle.getYear() + "|" +
                        vehicle.getMake() + "|" +
                        vehicle.getModel() + "|" +
                        vehicle.getVehicleType() + "|" +
                        vehicle.getColor() + "|" +
                        vehicle.getOdometer() + "|" +
                        vehicle.getPrice());
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error: Unable to write file: " + e.getMessage()); // Error handling
        }
    }
}



