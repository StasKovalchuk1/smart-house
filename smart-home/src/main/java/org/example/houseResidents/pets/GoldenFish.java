package org.example.houseResidents.pets;

import lombok.Data;
import org.example.devices.DeviceController;
import org.example.houses.House;


public class GoldenFish extends Pet{

    public GoldenFish(String name, House house) {
        super(name, house, PetType.GOLDENFISH);
    }
}
