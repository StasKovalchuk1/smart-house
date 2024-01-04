package org.example.houseResidents.pets;

import lombok.Data;
import org.example.devices.DeviceController;


public class Cat extends Pet{

    public Cat(DeviceController deviceController, String name) {
        super(deviceController, name, PetType.CAT);
    }
}
