package org.example.generators.events.strategies.forPerson;

import lombok.extern.slf4j.Slf4j;
import org.example.devices.DeviceController;
import org.example.devices.Food;
import org.example.devices.Fridge;

import java.util.Random;

@Slf4j
public class ExpiredFoodStrategy implements EventHandleByPersonStrategy{
    @Override
    public void handle(DeviceController controller) {
        Food expiredFood = getExpiredFood(controller);
        Fridge fridge = (Fridge) controller.getDeviceByName("fridge");
        fridge.removeFoodFromFridge(expiredFood);
        log.info("Expired {} was removed from the fridge", expiredFood);
    }

    public Food getExpiredFood(DeviceController controller) {
        Fridge fridge = (Fridge) controller.getDeviceByName("fridge");
        return fridge.getFoodInside().get(new Random().nextInt(0, fridge.getFoodInside().size()));
    }
}
