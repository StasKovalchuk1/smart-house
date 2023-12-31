package org.example.generators.events.strategies.forPerson;

import lombok.extern.slf4j.Slf4j;
import org.example.devices.Device;
import org.example.devices.DeviceController;
import org.example.devices.Food;
import org.example.devices.Fridge;

import java.util.Optional;
import java.util.Random;

@Slf4j
public class ExpiredFoodStrategy implements EventHandleByPersonStrategy{
    @Override
    public void handle(DeviceController controller) {
        Optional<Device> fridgeOptional = controller.getDeviceByName("Fridge");
        Fridge fridge;
        if (fridgeOptional.isPresent()) {
            fridge = (Fridge) fridgeOptional.get();
            Food expiredFood = getExpiredFood(controller);
            fridge.removeFoodFromFridge(expiredFood);
            log.info("Expired {} was removed from the fridge", expiredFood);
        }
    }

    public Food getExpiredFood(DeviceController controller) {
        Optional<Device> fridgeOptional = controller.getDeviceByName("Fridge");
        Fridge fridge;
        if (fridgeOptional.isPresent()) {
            fridge = (Fridge) fridgeOptional.get();
            return fridge.getFoodInside().get(new Random().nextInt(0, fridge.getFoodInside().size()));
        }
        return null;
    }
}
