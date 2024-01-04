package org.example.houseResidents.pets;

import lombok.Data;
import org.example.devices.DeviceController;
import org.example.houses.House;


public class Dog extends Pet{

    public Dog(DeviceController deviceController, String name, House house) {
        super(deviceController, name, house, PetType.DOG);
    }
}
