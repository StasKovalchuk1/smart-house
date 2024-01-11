package org.example.generators.activities.personActivities.strategies;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.example.devices.Device;
import org.example.devices.DeviceController;
import org.example.devices.Food;
import org.example.devices.Fridge;
import org.example.generators.activities.ActivityStrategy;
import org.example.houseResidents.HouseResident;

import java.util.Optional;
import java.util.Random;

@Data
@Slf4j
public class GetFoodFromFridgeStrategy implements ActivityStrategy {

    @Override
    public void performActivity(DeviceController deviceController, Device device, HouseResident person) throws Exception {
        Optional<Device> fridgeOptional = deviceController.getRunningDeviceByName("Fridge");
        Food food = pickFood(deviceController);
        Fridge fridge;
        if (fridgeOptional.isPresent()) {
            fridge = (Fridge) fridgeOptional.get();
            if (fridge.getFoodInside().contains(food)) {
                fridge.getFoodInside().remove(food);
                log.info(String.format("%s has took %s from fridge%n", person.getName(), food.toString()));
                log.info(String.format("%s took food from fridge", person.getName()));
            } else {
                log.info("There is not enough " + food.toString() + " in the fridge");
            }
        }
        else {
            log.warn("Fridge doesn't exist");
        }
    }

    private Food pickFood(DeviceController deviceController){
        Optional<Device> fridgeOptional = deviceController.getRunningDeviceByName("Fridge");
        Fridge fridge;
        if (fridgeOptional.isPresent()) {
            fridge = (Fridge) fridgeOptional.get();
            int foodCount = fridge.getFoodInside().size();
            int randomFoodIndex = new Random().nextInt(foodCount+1);
            return fridge.getFoodInside().get(randomFoodIndex);
        } else {
            log.warn("Fridge doesn't exist");
            return null;
        }
    }
}

