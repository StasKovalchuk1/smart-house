package org.example.houseResidents.pets;

import lombok.Data;
import org.example.devices.DeviceController;
import org.example.houses.House;


public class Cat extends Pet{

    public Cat(Integer id, String name, House house) {
        super(id, name, house, PetType.CAT);
    }
}
