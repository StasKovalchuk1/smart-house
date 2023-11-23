package org.example.builders;

import org.example.components.Floor;
import org.example.components.Garage;
import org.example.components.Pool;
import org.example.houses.House;

import java.util.List;

public interface HouseBuilder {
    void setFloors(List<Floor> floors);
    void setGarage(Garage garage);
    void setPool(Pool pool);
}
