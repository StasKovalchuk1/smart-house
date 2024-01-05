package org.example.houseComponents;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.houseComponents.vehicle.Vehicle;
import org.example.houseComponents.vehicle.VehicleType;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
public class Garage {

    private List<Vehicle> vehicles;

    public Garage(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "Garage contains " +
                vehicles.toString();
    }

    public Optional<Vehicle> getVehicleByType(VehicleType type) {
        for (Vehicle vehicle: vehicles) {
            if (vehicle.getType().equals(type)) return Optional.of(vehicle);
        }
        return Optional.empty();
    }
}
