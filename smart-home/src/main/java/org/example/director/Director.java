package org.example.director;

import org.example.builders.HouseBuilder;
import org.example.components.Floor;
import org.example.components.Garage;
import org.example.components.Pool;

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
