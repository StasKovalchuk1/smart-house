package org.example.houses;

import org.example.houseComponents.Floor;
import org.example.houseComponents.Pool;

import java.util.List;

public class HouseWithPool extends House{

    private final Pool pool;

    public HouseWithPool(List<Floor> floors, Pool pool) {
        this.floors = floors;
        this.pool = pool;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public Pool getPool() {
        return pool;
    }
}
