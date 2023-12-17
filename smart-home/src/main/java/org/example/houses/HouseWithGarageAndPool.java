package org.example.houses;

import org.example.houseComponents.Floor;
import org.example.houseComponents.Garage;
import org.example.houseComponents.Pool;

import java.util.List;

public class HouseWithGarageAndPool extends House{

    private final Garage garage;

    private final Pool pool;

    public HouseWithGarageAndPool(List<Floor> floors, Garage garage, Pool pool) {
        this.floors = floors;
        this.garage = garage;
        this.pool = pool;
        setType(HouseTypes.WITH_GARAGE_AND_POOL);
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public Garage getGarage() {
        return garage;
    }

    public Pool getPool() {
        return pool;
    }
}
