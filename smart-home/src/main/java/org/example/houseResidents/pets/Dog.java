package org.example.houseResidents.pets;

import lombok.Data;
import org.example.devices.DeviceController;
import org.example.houses.House;


public class Dog extends Pet{

    public Dog(String name, House house) {
        super(name, house, PetType.DOG);
    }
}
