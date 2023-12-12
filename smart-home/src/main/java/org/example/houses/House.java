package org.example.houses;

import lombok.Data;
import org.example.houseComponents.Floor;

import java.util.List;

@Data
public abstract class House {

    private Integer id;

    protected List<Floor> floors;
}
