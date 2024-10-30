package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {
    private String fileName;

    public DealershipFileManager(String fileName) {
        this.fileName = fileName;
    }

    public Dealership getDealership() {
        Dealership dealership = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            if (line != null) {
                String[] dealershipInfo = line.split("\\|");
                dealership = new Dealership(dealershipInfo[0].trim(), dealershipInfo[1].trim(), dealershipInfo[2].trim());
            }

            while ((line = br.readLine()) != null) {
                String[] vehicleData = line.split("\\|");
                Vehicle vehicle = new Vehicle(
                        Integer.parseInt(vehicleData[0].trim()),
                        Integer.parseInt(vehicleData[1].trim()),
                        vehicleData[2].trim(),
                        vehicleData[3].trim(),
                        vehicleData[4].trim(),
                        vehicleData[5].trim(),
                        Integer.parseInt(vehicleData[6].trim()),
                        Double.parseDouble(vehicleData[7].trim())
                );
                if (dealership != null) {
                    dealership.addVehicle(vehicle);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                writer.println(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" +
                        vehicle.getModel() + "|" + vehicle.getVehicletype() + "|" + vehicle.getColor() + "|" +
                        vehicle.getOdometer() + "|" + vehicle.getPrice());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


