package org.example.houseResidents.pets;

import lombok.Data;
import org.example.devices.DeviceController;


public class GoldenFish extends Pet{

    public GoldenFish(DeviceController deviceController, String name) {
        super(deviceController, name, PetType.GOLDENFISH);
    }
}
