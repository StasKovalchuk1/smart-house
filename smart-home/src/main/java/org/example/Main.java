package org.example;

import org.example.config.ConfigBuilder;
import org.example.devices.Device;
import org.example.houseComponents.vehicle.Vehicle;
import org.example.houseResidents.HouseResident;
import org.example.houseResidents.people.Person;
import org.example.houses.House;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        House house1 = ConfigBuilder.buildHouseFromJson("config/config1.json");

        Simulation simulation = new Simulation(house1);
        simulation.runSimulation();







//        System.out.println("People: ");
//        for (HouseResident person : house1.getPeople()) {
//            System.out.println(person.getType() + " " + person.getName());
//        }
//        System.out.println("----------");
//        System.out.println("Pets: ");
//        for (HouseResident pet : house1.getPets()) {
//            System.out.println(pet.getType() + " " + pet.getName());
//        }
//        System.out.println("----------");
//        System.out.println("Devices: ");
//        List<Device> devices = house1.getFloors().stream()
//        .flatMap(floor -> floor.getRooms().stream())
//        .flatMap(room -> room.getDevices().stream())
//        .toList();
//        for (Device device : devices) {
//            System.out.println(device.getName());
//        }

    }
}