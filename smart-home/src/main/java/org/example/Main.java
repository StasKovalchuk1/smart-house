package org.example;

import org.example.builders.HouseWithGarageAndPoolBuilder;
import org.example.devices.Device;
import org.example.devices.DeviceController;
import org.example.factory.DeviceManager;
import org.example.factory.FridgeManager;
import org.example.generators.events.EventGeneratorForHandlingByPerson;
import org.example.houseComponents.Floor;
import org.example.houseComponents.vehicle.Car;
import org.example.director.Director;
import org.example.houseResidents.people.Father;
import org.example.houseResidents.people.Person;
import org.example.houses.HouseWithGarageAndPool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DeviceManager fridgeManager = new FridgeManager();
        Device fridge = fridgeManager.collectData();

        DeviceManager ovenManager = new FridgeManager();
        Device oven = ovenManager.collectData();

        DeviceManager dishwasherManager = new FridgeManager();
        Device dishwasher = dishwasherManager.collectData();

        DeviceController controller = new DeviceController();
        controller.getDevices().add(fridge);
        controller.getDevices().add(oven);
        controller.getDevices().add(dishwasher);

        Person father = new Father(controller);

        EventGeneratorForHandlingByPerson generator = new EventGeneratorForHandlingByPerson(List.of(father), controller);

        generator.generateEvent();
    }
}