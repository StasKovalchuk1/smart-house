package org.example.houseResidents.pets;

import lombok.Data;
import org.example.generators.activities.Activity;
import org.example.houseResidents.HouseResident;

@Data
public abstract class Pet extends HouseResident {

    protected boolean isInShelter;

    @Override
    public void doActivity(Activity activity){}
}
