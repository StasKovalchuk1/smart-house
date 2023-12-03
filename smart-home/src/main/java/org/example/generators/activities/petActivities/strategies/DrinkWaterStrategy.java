package org.example.generators.activities.petActivities.strategies;

import lombok.Data;
import org.example.devices.Device;
import org.example.devices.DeviceController;
import org.example.devices.Shelter;
import org.example.generators.activities.ActivityStrategy;

@Data
public class DrinkWaterStrategy implements ActivityStrategy {
    @Override
    public void performActivity(DeviceController deviceController, Device device, String entityName) throws Exception {
        if (device!=null){
            if (((Shelter)device).getWaterAmount()!=0){
                ((Shelter)device).setWaterAmount(((Shelter)device).getWaterAmount()-10);
                System.out.printf("Pet %s drank water", entityName);
            } else {
                //todo: животному нечего пить, надо как-то обработать
            }
        }
    }
}
