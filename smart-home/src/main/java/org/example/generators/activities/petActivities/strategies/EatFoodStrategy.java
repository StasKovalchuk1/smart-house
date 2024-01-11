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
public class EatFoodStrategy implements ActivityStrategy {

    @Override
    public void performActivity(DeviceController deviceController, Device device, HouseResident petName) throws Exception {
        if (device!=null){
            if (((Shelter)device).getFoodAmount()!=0){
                ((Shelter)device).setFoodAmount(((Shelter)device).getFoodAmount()-2);
                log.info(String.format("Pet %s ate food", petName.getName()));
            } else {
                log.info(String.format("Not enough food to eat in %s", device.toString()));
            }
        }
    }
}
