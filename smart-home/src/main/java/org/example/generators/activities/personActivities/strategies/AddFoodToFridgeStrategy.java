package org.example.generators.activities.personActivities.strategies;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.example.devices.Device;
import org.example.devices.DeviceController;
import org.example.devices.Food;
import org.example.devices.Fridge;
import org.example.generators.activities.ActivityStrategy;

import java.util.Random;

@Data
@Slf4j
public class AddFoodToFridgeStrategy implements ActivityStrategy {
    @Override
    public void performActivity(DeviceController deviceController, Device device, String personName){
        Fridge fridge = (Fridge) deviceController.getDeviceByName("Fridge");
        Food food = pickFood(deviceController);
        fridge.getFoodInside().add(food);
        System.out.printf("%s has put %s to fridge%n", personName, food.toString());
        log.info("Food was added to fridge");
    }

    private Food pickFood(DeviceController deviceController){
        Fridge fridge = (Fridge)deviceController.getDeviceByName("Fridge");
        int foodCount = fridge.getFoodInside().size();
        int randomFoodIndex = new Random().nextInt(foodCount+1);
        return fridge.getFoodInside().get(randomFoodIndex);
    }
}
