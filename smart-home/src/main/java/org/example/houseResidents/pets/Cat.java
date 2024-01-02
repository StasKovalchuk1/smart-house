package org.example.houseResidents.pets;

import lombok.Data;
import org.example.devices.Device;
import org.example.generators.activities.Activity;

@Data
public class Cat extends Pet{

    public Cat() {
        setType(PetType.CAT);
    }
}
