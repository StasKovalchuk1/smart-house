package org.example.houses;

import lombok.Data;
import org.example.houseComponents.Floor;

import java.util.List;
import java.util.PrimitiveIterator;

@Data
public abstract class House {
    private Integer id;
    private HouseTypes type;

    protected List<Floor> floors;
}
