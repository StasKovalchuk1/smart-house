package org.example.houses;

import lombok.Data;
import org.example.devices.DeviceController;
import org.example.houseComponents.Floor;
import org.example.houseComponents.Garage;

import java.util.List;

@Data
public class HouseWithGarage extends House{

    private final Garage garage;

    public HouseWithGarage(List<Floor> floors, Garage garage, DeviceController deviceController) {
        this.floors = floors;
        this.garage = garage;
        this.deviceController = deviceController;
        setType(HouseType.WITH_GARAGE);
    }

}
