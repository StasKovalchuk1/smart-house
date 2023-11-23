package org.example.builders;

import org.example.components.Floor;
import org.example.components.Garage;
import org.example.components.Pool;
import org.example.houses.House;
import org.example.houses.SimpleHouse;

import java.util.List;

public class SimpleHouseBuilder implements HouseBuilder{

    private List<Floor> floors;

    @Override
    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    @Override
    public void setGarage(Garage garage) {}

    @Override
    public void setPool(Pool pool) {}

    public SimpleHouse getResult() {
        return new SimpleHouse(floors);
    }
}
