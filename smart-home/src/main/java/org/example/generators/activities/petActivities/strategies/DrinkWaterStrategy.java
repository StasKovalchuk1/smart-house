package org.example.generators.activities.petActivities.strategies;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.example.devices.Device;
import org.example.devices.DeviceController;
import org.example.devices.Shelter;
import org.example.generators.activities.ActivityStrategy;
import org.example.houseResidents.HouseResident;
import org.example.houseResidents.people.Person;

@Data
@Slf4j
public class DrinkWaterStrategy implements ActivityStrategy {

    @Override
    public void performActivity(DeviceController deviceController, Device device, HouseResident petName) throws Exception {
        if (device!=null){
            if (((Shelter)device).getWaterAmount()!=0){
                ((Shelter)device).setWaterAmount(((Shelter)device).getWaterAmount()-2);
                log.info(String.format("Pet %s drank water", petName.getName()));
            } else {
                log.info(String.format("Not enough water to eat in %s", device.toString()));
            }
        }
    }
}
