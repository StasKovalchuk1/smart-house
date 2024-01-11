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
        Fridge fridge;
        if (fridgeOptional.isPresent()) {
            fridge = (Fridge) fridgeOptional.get();
            Food food = pickFood(fridge);
            if (fridge.getFoodInside().contains(food)) {
                fridge.getFoodInside().remove(food);
                log.info(String.format("%s has took %s from %s", person.toString(), food.toString(), fridge.toString()));
            } else {
                log.info("There is not enough " + food.toString() + " in the " + fridge.toString());
            }
        } else {
            fridgeOptional = deviceController.getOffDeviceByName("Fridge");
            if (fridgeOptional.isPresent()){
                fridge = (Fridge) fridgeOptional.get();
                deviceController.turnOnDevice(fridge);
                deviceController.runDevice(fridge);
                Food food = pickFood(fridge);
                if (fridge.getFoodInside().contains(food)) {
                    fridge.getFoodInside().remove(food);
                    log.info(String.format("%s has took %s from %s", person.toString(), food.toString(), fridge.toString()));
                } else {
                    log.info("There is not enough " + food.toString() + " in the " + fridge.toString());
                }
            } else {
                log.warn(device.toString() + " was not found");
            }
        }
    }

    private Food pickFood(Fridge fridge){
        int foodCount = fridge.getFoodInside().size();
        int randomFoodIndex = new Random().nextInt(foodCount);
        return fridge.getFoodInside().get(randomFoodIndex);
    }
}

