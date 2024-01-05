package org.example.builders;

import lombok.Data;
import org.example.devices.DeviceController;
import org.example.houseComponents.Floor;
import org.example.houseComponents.Garage;
import org.example.houseComponents.Pool;
import org.example.houses.HouseWithGarage;

import java.util.List;

@Data
public class HouseWithGarageBuilder implements HouseBuilder{

    private List<Floor> floors;
    private Garage garage;
    private final DeviceController deviceController;

    public HouseWithGarageBuilder(DeviceController deviceController) {
        this.deviceController = deviceController;
    }

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
        return new HouseWithGarage(floors, garage, deviceController);
    }
}
