package org.example.builders;

import lombok.Data;
import org.example.houseComponents.Floor;
import org.example.houseComponents.Garage;
import org.example.houseComponents.Pool;
import org.example.houses.SimpleHouse;

import java.util.List;

@Data
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
