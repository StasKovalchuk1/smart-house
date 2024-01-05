package org.example.builders;

import lombok.Data;
import org.example.devices.DeviceController;
import org.example.houseComponents.Floor;
import org.example.houseComponents.Garage;
import org.example.houseComponents.Pool;
import org.example.houses.HouseWithPool;

import java.util.List;

@Data
public class HouseWithPoolBuilder implements HouseBuilder{

    private List<Floor> floors;
    private Pool pool;
    private final DeviceController deviceController;

    public HouseWithPoolBuilder(DeviceController deviceController) {
        this.deviceController = deviceController;
    }

    @Override
    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    @Override
    public void setGarage(Garage garage) {}

    @Override
    public void setPool(Pool pool) {
        this.pool = pool;
    }

    public HouseWithPool getResult() {
        return new HouseWithPool(floors, pool, deviceController);
    }
}
