package org.example.generators.activities.personActivities.strategies;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.example.devices.Device;
import org.example.devices.DeviceController;
import org.example.devices.Food;
import org.example.devices.Fridge;
import org.example.generators.activities.ActivityStrategy;
import org.example.houseResidents.people.Person;

import java.util.Optional;
import java.util.Random;

@Data
@Slf4j
public class AddFoodToFridgeStrategy implements ActivityStrategy {
    @Override
    public void performActivity(DeviceController deviceController, Device device, Person person){
        Optional<Device> fridgeOptional = deviceController.getDeviceByName("Fridge");
        Food food = pickFood(deviceController);
        Fridge fridge;
        if (fridgeOptional.isPresent()) {
            fridge = (Fridge) fridgeOptional.get();
            fridge.getFoodInside().add(food);
            System.out.printf("%s has put %s to fridge%n", person.getName(), food.toString());
            log.info("Food was added to fridge");
        } else {
            log.warn(device.getName() + " was not found");
        }
    }

    private Food pickFood(DeviceController deviceController){
        Optional<Device> fridgeOptional = deviceController.getDeviceByName("Fridge");
        Food food = pickFood(deviceController);
        Fridge fridge;
        if (fridgeOptional.isPresent()) {
            fridge = (Fridge) fridgeOptional.get();
            int foodCount = fridge.getFoodInside().size();
            int randomFoodIndex = new Random().nextInt(foodCount+1);
            return fridge.getFoodInside().get(randomFoodIndex);
        } else {
            log.warn("Fridge was not found");
            return null;
        }

    }
}
