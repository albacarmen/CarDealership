package com.pluralsight;

import java.util.ArrayList;
import java.util.List;


public class Dealership {

    private String name;  // Name of the dealership
    private String address; // Address of the dealership
    private String phone;   // Contact number for the dealership
    private ArrayList<Vehicle> inventory; // List of vehicles available in the dealership


    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>(); // Initialize an empty inventory
    }

    // Getter and setter methods for dealership properties

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> vehicles = new ArrayList<>();

        // Iterate through the inventory to find matching vehicles
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }


    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> vehicles = new ArrayList<>();

        // Check each vehicle for matching make and model
        for (Vehicle vehicle : inventory) {
            if ((vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) ||
                    (vehicle.getMake().equalsIgnoreCase(make) && model.isEmpty())) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }


    public List<Vehicle> getVehiclesByYear(Integer min, Integer max) {
        List<Vehicle> vehicles = new ArrayList<>();

        // Filter vehicles by year
        for (Vehicle vehicle : inventory) {
            if ((max == null || vehicle.getYear() <= max) && (min == null || vehicle.getYear() >= min)) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }


    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> vehicles = new ArrayList<>();

        // Add vehicles that match the specified color
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }


    public List<Vehicle> getVehiclesByMileage(double min, double max) {
        List<Vehicle> vehicles = new ArrayList<>();

        // Check mileage of each vehicle
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() <= max && vehicle.getOdometer() >= min) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }


    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> vehicles = new ArrayList<>();

        // Filter vehicles based on type
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }


    public Vehicle getVehiclesByVin(int vin) {
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVin() == vin) {
                return vehicle; // Return the vehicle if found
            }
        }
        return null; // Return null if not found
    }


    public List<Vehicle> getAllVehicles() {
        return inventory;
    }


    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }


    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s|%s|%s", name, address, phone));
        // Append details of each vehicle in the inventory
        for (Vehicle vehicle : inventory) {
            output.append(String.format("%n%d|%d|%s|%s|%s|%s|%d|%.2f",
                    vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(),
                    vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice()));
        }
        return output.toString();
    }
}


