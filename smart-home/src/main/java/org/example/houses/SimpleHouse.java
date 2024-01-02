package org.example.houses;

import lombok.Data;
import org.example.houseComponents.Floor;

import java.util.List;

@Data
public class SimpleHouse extends House{

    public SimpleHouse(List<Floor> floors){
        this.floors = floors;
        setType(HouseType.SIMPLE);
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
