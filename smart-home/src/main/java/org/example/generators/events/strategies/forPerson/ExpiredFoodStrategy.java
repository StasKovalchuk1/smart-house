package org.example.generators.events.strategies.forPerson;

import org.example.devices.DeviceController;
import org.example.devices.Food;
import org.example.devices.Fridge;

import java.util.Random;

public class ExpiredFoodStrategy implements EventHandleByPersonStrategy{
    @Override
    public void handle(DeviceController controller) {
        Food expiredFood = getExpiredFood(controller);
        Fridge fridge = (Fridge) controller.getDeviceByName("fridge");
        fridge.removeFoodFromFridge(expiredFood);
    }

    public Food getExpiredFood(DeviceController controller) {
        Fridge fridge = (Fridge) controller.getDeviceByName("fridge");
        return fridge.getFoodInside().get(new Random().nextInt(0, fridge.getFoodInside().size()));
    }
}
