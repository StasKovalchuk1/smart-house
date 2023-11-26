package org.example.director;

import org.example.builders.HouseBuilder;
import org.example.houseComponents.Floor;
import org.example.houseComponents.Garage;
import org.example.houseComponents.Pool;

import java.util.List;

public class Director {

    public void constructSimpleHouse(HouseBuilder builder, List<Floor> floors) {
        builder.setFloors(floors);
    }

    public void constructHouseWithGarage(HouseBuilder builder, List<Floor> floors) {
        builder.setFloors(floors);
        builder.setGarage(new Garage());
    }
    public void constructHouseWithPool(HouseBuilder builder, List<Floor> floors) {
        builder.setFloors(floors);
        builder.setPool(new Pool());
    }
    public void constructHouseWithGarageAndPool(HouseBuilder builder, List<Floor> floors) {
        builder.setFloors(floors);
        builder.setPool(new Pool());
        builder.setGarage(new Garage());
    }
}
