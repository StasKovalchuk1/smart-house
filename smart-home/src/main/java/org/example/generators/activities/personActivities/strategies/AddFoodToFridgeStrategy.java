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
public class AddFoodToFridgeStrategy implements ActivityStrategy {

    //TODO если нет включенного холодильника, надо взять выключенный и включить его
    @Override
    public void performActivity(DeviceController deviceController, Device device, HouseResident person){
        Optional<Device> fridgeOptional = deviceController.getRunningDeviceByName("Fridge");
        Fridge fridge;
        if (fridgeOptional.isPresent()) {
            fridge = (Fridge) fridgeOptional.get();
            Food food = pickFood(fridge);
            fridge.getFoodInside().add(food);
            log.info(String.format("%s has put %s to fridge%n", person.getName(), food.toString()));
        } else {
            fridgeOptional = deviceController.getOffDeviceByName("Fridge");
            if (fridgeOptional.isPresent()){
                fridge = (Fridge) fridgeOptional.get();
                deviceController.turnOnDevice(fridge);
                deviceController.runDevice(fridge);
                Food food = pickFood(fridge);
                fridge.getFoodInside().add(food);
                log.info(String.format("%s has put %s to fridge%n", person.getName(), food.toString()));
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
