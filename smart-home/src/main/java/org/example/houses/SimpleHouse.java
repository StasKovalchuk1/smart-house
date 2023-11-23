package org.example.houses;

import org.example.components.Floor;

import java.util.List;

public class SimpleHouse extends House{

    public SimpleHouse(List<Floor> floors){
        this.floors = floors;
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
