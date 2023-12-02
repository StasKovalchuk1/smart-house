package org.example.houseResidents.persons;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.example.devices.*;
import org.example.generators.activities.Activity;
import org.example.generators.activities.PersonActivity;
import org.example.generators.events.EventToHandle;
import org.example.houseResidents.HouseResident;

import java.util.Random;

import static org.example.generators.activities.PersonActivity.*;

@Slf4j
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class Person extends HouseResident implements Subscriber{

    private String name;

    private boolean atHome;

    private final DeviceController deviceController;

    public Person(DeviceController deviceController) {
        this.deviceController = deviceController;
    }

    public abstract void handleEvent(EventToHandle event);

    public void doActivity(Activity activity) throws Exception {
        Device device;
        Fridge fridge;
        Food food;
        switch ((PersonActivity) activity) {
            case GetFoodFromFridge -> {
                fridge = (Fridge) deviceController.getDeviceByName("Fridge");
                food = pickFood();
                if (fridge.getFoodInside().contains(food)) {
                    //todo добавить логику уменьшение кол-ва еды из холодильника
                    fridge.getFoodInside().remove(food);
                    System.out.printf("%s took %s from fridge%n", name, food.toString());
                    log.info("Person took food from fridge");
                } else {
                    throw new Exception("There is not enough " + food.toString() + " in the fridge");
                }
            }
            case AddFoodToFridge -> {
                food = pickFood();
                ((Fridge) deviceController.getDeviceByName("Fridge")).getFoodInside().add(food);
                log.info("Food was added to fridge");
            }
            //todo добавить логику увеличения кол-ва еды в холодильнике
            case DoLaundry -> {
                device = deviceController.getDeviceByName("Laundry");
                //Checking if device is not being used by someone else
                if (device != null) {
                    if (!device.getState().getName().equals("Running")) {
                        deviceController.turnOnDevice(device);
                        deviceController.runDevice(device);
                    } else {
                        //todo реализовать логику ожидания пока девайс не освободиться
                    }
                }
            }
            case WashDishes -> {
                device = deviceController.getDeviceByName("Dishwasher");
                //Checking if device is not being used by someone else
                if (device != null) {
                    if (!device.getState().getName().equals("Running")) {
                        deviceController.turnOnDevice(device);
                        deviceController.runDevice(device);
                    } else {
                        //todo реализовать логику ожидания пока девайс не освободиться
                    }
                }
            }
            case GrillMeet -> {
                device = deviceController.getDeviceByName("Grill");
                //Checking if device is not being used by someone else
                if (device != null) {
                    if (!device.getState().getName().equals("Running")) {
                        deviceController.turnOnDevice(device);
                        deviceController.runDevice(device);
                    } else {
                        //todo реализовать логику ожидания пока девайс не освободиться
                    }
                }
            }
            case MakeCoffee -> {
                device = deviceController.getDeviceByName("CoffeeMachine");
                //Checking if device is not being used by someone else
                if (device != null) {
                    if (!device.getState().getName().equals("Running")) {
                        deviceController.turnOnDevice(device);
                        deviceController.runDevice(device);
                    } else {
                        //todo реализовать логику ожидания пока девайс не освободиться
                    }
                }
            }
            case HeatFood -> {
                device = deviceController.getDeviceByName("Microwave");
                //Checking if device is not being used by someone else
                if (device != null) {
                    if (!device.getState().getName().equals("Running")) {
                        deviceController.turnOnDevice(device);
                        deviceController.runDevice(device);
                    } else {
                        //todo реализовать логику ожидания пока девайс не освободиться
                    }
                }
            }
            case BakeFood -> {
                device = deviceController.getDeviceByName("Oven");
                //Checking if device is not being used by someone else
                if (device != null) {
                    if (!device.getState().getName().equals("Running")) {
                        deviceController.turnOnDevice(device);
                        deviceController.runDevice(device);
                    } else {
                        //todo реализовать логику ожидания пока девайс не освободиться
                    }
                }
            }
            case UseComputer -> {
                device = deviceController.getDeviceByName("Computer");
                //Checking if device is not being used by someone else
                if (device != null) {
                    if (!device.getState().getName().equals("Running")) {
                        deviceController.turnOnDevice(device);
                        deviceController.runDevice(device);
                    } else {
                        //todo реализовать логику ожидания пока девайс не освободиться
                    }
                }
            }
        }
    }

    public Food pickFood(){
        Fridge fridge = (Fridge)deviceController.getDeviceByName("Fridge");
        int foodCount = fridge.getFoodInside().size();
        int randomFoodIndex = new Random().nextInt(foodCount+1);
        return fridge.getFoodInside().get(randomFoodIndex);
    }
}
