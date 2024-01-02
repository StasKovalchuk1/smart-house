package org.example.houses;

import lombok.Data;
import org.example.houseComponents.Floor;
import org.example.houseComponents.Pool;

import java.util.List;

@Data
public class HouseWithPool extends House{

    private final Pool pool;

    public HouseWithPool(List<Floor> floors, Pool pool) {
        this.floors = floors;
        this.pool = pool;
        setType(HouseType.WITH_POOL);
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public Pool getPool() {
        return pool;
    }
}
