package org.example.houses;

import lombok.Data;
import org.example.devices.DeviceController;
import org.example.houseComponents.Floor;

import java.util.List;

@Data
public class SimpleHouse extends House{

    public SimpleHouse(List<Floor> floors, DeviceController deviceController){
        this.floors = floors;
        this.deviceController = deviceController;
        setType(HouseType.SIMPLE);
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
