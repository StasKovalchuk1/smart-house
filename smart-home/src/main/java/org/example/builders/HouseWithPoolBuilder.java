package org.example.builders;

import org.example.components.Floor;
import org.example.components.Garage;
import org.example.components.Pool;
import org.example.houses.House;
import org.example.houses.HouseWithPool;

import java.util.List;

public class HouseWithPoolBuilder implements HouseBuilder{

    private List<Floor> floors;

    private Pool pool;

    @Override
    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    @Override
    public void setGarage(Garage garage) {}

    @Override
    public void setPool(Pool pool) {
        this.pool = pool;
    }

    public HouseWithPool getResult() {
        return new HouseWithPool(floors, pool);
    }
}
