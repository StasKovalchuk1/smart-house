package org.example.houses;

import org.example.components.Floor;
import org.example.components.Garage;

import java.util.List;

public class HouseWithGarage extends House{

    private final Garage garage;

    public HouseWithGarage(List<Floor> floors, Garage garage) {
        this.floors = floors;
        this.garage = garage;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public Garage getGarage() {
        return garage;
    }
}
