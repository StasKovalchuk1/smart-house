package org.example.houseComponents;

import org.example.houseComponents.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Garage {

    private List<Vehicle> vehicles;

    public Garage() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public String toString() {
        return "Garage contains " +
                vehicles.toString();
    }
}
