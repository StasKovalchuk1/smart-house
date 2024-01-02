package org.example.houses;

import lombok.Data;
import org.example.houseComponents.Floor;
import org.example.houseComponents.Garage;

import java.util.List;

@Data
public class HouseWithGarage extends House{

    private final Garage garage;

    public HouseWithGarage(List<Floor> floors, Garage garage) {
        this.floors = floors;
        this.garage = garage;
        setType(HouseType.WITH_GARAGE);
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public Garage getGarage() {
        return garage;
    }
}
