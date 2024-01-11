package org.example.houseResidents.pets;

import lombok.Data;
import org.example.devices.DeviceController;
import org.example.houses.House;


public class Dog extends Pet{

    public Dog(Integer id, String name, House house) {
        super(id, name, house, PetType.DOG);
    }
}
