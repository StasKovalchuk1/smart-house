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

    // TODO пофиксить person аргумент
    @Override
    public void performActivity(DeviceController deviceController, Device device, HouseResident petName) throws Exception {
        if (device!=null){
            if (((Shelter)device).getWaterAmount()!=0){
                ((Shelter)device).setWaterAmount(((Shelter)device).getWaterAmount()-10);
                log.info(String.format("Pet %s drank water", petName));
            } else {
                //todo: животному нечего пить, надо как-то обработать
            }
        }
    }
}
