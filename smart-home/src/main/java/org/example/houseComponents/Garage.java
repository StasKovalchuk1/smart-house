package org.example.houseComponents;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.houseComponents.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
public class Garage {

    private Integer id;

    private List<Vehicle> vehicles;

    @Override
    public String toString() {
        return "Garage contains " +
                vehicles.toString();
    }

    public Optional<Vehicle> getVehicleByName(String name) {
        for (Vehicle vehicle: vehicles) {
            if (vehicle.getName().equals(name)) return Optional.of(vehicle);
        }
        return Optional.empty();
    }
}
