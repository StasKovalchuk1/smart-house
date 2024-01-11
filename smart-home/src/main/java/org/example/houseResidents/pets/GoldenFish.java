package org.example.houseResidents.pets;

import lombok.Data;
import org.example.devices.DeviceController;
import org.example.houses.House;


public class GoldenFish extends Pet{

    public GoldenFish(Integer id, String name, House house) {
        super(id, name, house, PetType.GOLDENFISH);
    }
}
