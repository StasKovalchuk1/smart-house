package org.example.builders;

import org.example.houseComponents.Floor;
import org.example.houseComponents.Garage;
import org.example.houseComponents.Pool;

import java.util.List;

public interface HouseBuilder {
    void setFloors(List<Floor> floors);
    void setGarage(Garage garage);
    void setPool(Pool pool);
}
