package org.example.houseResidents.pets;

import lombok.Data;
import org.example.devices.DeviceController;
import org.example.houses.House;


public class GoldenFish extends Pet{

    public GoldenFish(DeviceController deviceController, String name, House house) {
        super(deviceController, name, house, PetType.GOLDENFISH);
    }
}
