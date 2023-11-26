package org.example.houseComponents;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.houseComponents.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

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
}
