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

    }
}