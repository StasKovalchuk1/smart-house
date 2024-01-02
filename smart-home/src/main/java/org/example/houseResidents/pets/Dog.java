package org.example.houseResidents.pets;

import lombok.Data;

@Data
public class Dog extends Pet{

    public Dog() {
        setType(PetType.DOG);
    }
}
