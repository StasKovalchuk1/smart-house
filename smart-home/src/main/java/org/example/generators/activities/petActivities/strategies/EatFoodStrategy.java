package org.example.generators.activities.petActivities.strategies;

import lombok.Data;
import org.example.devices.Device;
import org.example.devices.DeviceController;
import org.example.devices.Shelter;
import org.example.generators.activities.ActivityStrategy;

@Data
public class EatFoodStrategy implements ActivityStrategy {
    @Override
    public void performActivity(DeviceController deviceController, Device device, String entityName) throws Exception {
        if (device!=null){
            if (((Shelter)device).getFoodAmount()!=0){
                ((Shelter)device).setFoodAmount(((Shelter)device).getFoodAmount()-10);
                System.out.printf("Pet %s ate food", entityName);
            } else {
                //todo: животному нечего есть, надо как-то обработать
            }
        }
    }
}
