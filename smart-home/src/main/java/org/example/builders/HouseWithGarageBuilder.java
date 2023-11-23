package org.example.builders;

import org.example.components.Floor;
import org.example.components.Garage;
import org.example.components.Pool;
import org.example.houses.House;
import org.example.houses.HouseWithGarage;

import java.util.ArrayList;
import java.util.List;

public class HouseWithGarageBuilder implements HouseBuilder{

    private List<Floor> floors;

    private Garage garage;

    @Override
    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    @Override
    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    @Override
    public void setPool(Pool pool) {}

    public HouseWithGarage getResult() {
        return new HouseWithGarage(floors, garage);
    }
}
