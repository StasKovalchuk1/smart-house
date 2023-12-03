package org.example.houseResidents.pets;

import lombok.Data;
import org.example.devices.Device;
import org.example.devices.Shelter;
import org.example.generators.activities.Activity;
import org.example.generators.activities.ActivityStrategy;
import org.example.houseResidents.HouseResident;

@Data
public abstract class Pet extends HouseResident {

    protected boolean isInShelter;
    protected Shelter petShelter;

    @Override
    public void doActivity(Activity activity){
        Shelter shelter;

    }

    @Override
    protected Device getDeviceByActivity(Activity activity){
        return null;
    }

    @Override
    protected ActivityStrategy getStrategyByActivity(Activity activity){
        return null;
    }
}
