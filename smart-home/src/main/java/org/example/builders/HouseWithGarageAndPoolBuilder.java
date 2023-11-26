package org.example.builders;

import org.example.houseComponents.Floor;
import org.example.houseComponents.Garage;
import org.example.houseComponents.Pool;
import org.example.houses.HouseWithGarageAndPool;

import java.util.List;

public class HouseWithGarageAndPoolBuilder implements HouseBuilder{

    private List<Floor> floors;

    private Garage garage;

    private Pool pool;


    @Override
    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    @Override
    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    @Override
    public void setPool(Pool pool) {
        this.pool = pool;
    }

    public HouseWithGarageAndPool getResult() {
        return new HouseWithGarageAndPool(floors, garage, pool);
    }
}
