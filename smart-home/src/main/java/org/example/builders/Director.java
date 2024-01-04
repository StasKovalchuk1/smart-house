package org.example.builders;

import lombok.Data;
import org.example.builders.HouseBuilder;
import org.example.houseComponents.Floor;
import org.example.houseComponents.Garage;
import org.example.houseComponents.Pool;
import org.example.houseComponents.vehicle.Vehicle;

import java.util.List;

@Data
public class Director {

    public void constructSimpleHouse(HouseBuilder builder, List<Floor> floors) {
        builder.setFloors(floors);
    }

    public void constructHouseWithGarage(HouseBuilder builder, List<Floor> floors, List<Vehicle> vehicles) {
        builder.setFloors(floors);
        builder.setGarage(new Garage(vehicles));
    }
    public void constructHouseWithPool(HouseBuilder builder, List<Floor> floors) {
        builder.setFloors(floors);
        builder.setPool(new Pool());
    }
    public void constructHouseWithGarageAndPool(HouseBuilder builder, List<Floor> floors, List<Vehicle> vehicles) {
        builder.setFloors(floors);
        builder.setPool(new Pool());
        builder.setGarage(new Garage(vehicles));
    }
}
