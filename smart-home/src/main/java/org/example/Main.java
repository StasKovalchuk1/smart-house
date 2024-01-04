package org.example;

import org.example.config.ConfigBuilder;
import org.example.devices.Device;
import org.example.devices.DeviceController;
import org.example.generators.events.EventGeneratorForAutomaticHandling;
import org.example.generators.events.EventGeneratorForHandlingByPerson;
import org.example.houseResidents.people.Person;
import org.example.houses.House;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        try {
//            House house = ConfigBuilder.buildHouseFromJson("config/config1.json");
//            System.out.println(house.toString());
//            System.out.println(house.getFloors().get(1));
//
//            System.out.println(house.getFloors().get(1).getRooms().get(0).getDevices());
//
//            System.out.println(house.getFloors().get(1).getRooms().get(1).getDevices());
//
//            List<Device> devices = house.getFloors().stream()
//                    .flatMap(floor -> floor.getRooms().stream())
//                    .flatMap(room -> room.getDevices().stream())
//                    .toList();
//
//            DeviceController controller = new DeviceController(devices);
//
//            List<Person> people = ConfigBuilder.parsePeople("config/config1.json", controller, house);
//            System.out.println(people);
//            System.out.println("-------------------");
//
//            EventGeneratorForAutomaticHandling automaticHandling = new EventGeneratorForAutomaticHandling(controller);
//            EventGeneratorForHandlingByPerson personHandling = new EventGeneratorForHandlingByPerson(people, controller);
//            automaticHandling.generateEvent();
//            System.out.println("-------------------");
//            personHandling.generateEvent();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

}