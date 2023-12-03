package org.example.houseResidents.pets;

import lombok.Data;

@Data
public class GoldenFish extends Pet{

    public GoldenFish() {
        isInShelter=true;
    }
}
