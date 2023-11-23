package org.example.houses;

import org.example.components.Floor;
import org.example.components.Garage;
import org.example.components.Pool;

import java.util.List;

public class HouseWithGarageAndPool extends House{

    private final Garage garage;

    private final Pool pool;

    public HouseWithGarageAndPool(List<Floor> floors, Garage garage, Pool pool) {
        this.floors = floors;
        this.garage = garage;
        this.pool = pool;
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
