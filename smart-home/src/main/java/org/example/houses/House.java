package org.example.houses;

import lombok.Data;
import org.example.houseComponents.Floor;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

@Data
public abstract class House {
    private HouseTypes type;

    protected List<Floor> floors;

    public void addFloor(Floor floor) {
        if (floors.isEmpty()) floors = new ArrayList<>();
        floors.add(floor);
    }
}
