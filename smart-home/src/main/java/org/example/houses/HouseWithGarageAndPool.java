package org.example.houses;

import lombok.Data;
import org.example.devices.DeviceController;
import org.example.houseComponents.Floor;
import org.example.houseComponents.Garage;
import org.example.houseComponents.Pool;

import java.util.List;

@Data
public class HouseWithGarageAndPool extends House{

    private final Garage garage;

    private final Pool pool;

    public HouseWithGarageAndPool(List<Floor> floors, Garage garage, Pool pool, DeviceController deviceController) {
        this.floors = floors;
        this.garage = garage;
        this.pool = pool;
        this.deviceController = deviceController;
        setType(HouseType.WITH_GARAGE_AND_POOL);
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public Garage getGarage() {
        return garage;
    }

    public Pool getPool() {
        return pool;
    }
}
