package org.example.houseResidents.pets;

import lombok.Data;
import org.example.devices.DeviceController;


public class Dog extends Pet{

    public Dog(DeviceController deviceController, String name) {
        super(deviceController, name, PetType.DOG);
    }
}
