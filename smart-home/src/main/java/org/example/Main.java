package org.example;

import org.example.configBuilders.ConfigBuilder;
import org.example.houses.House;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        House house1 = ConfigBuilder.buildHouseFromJson("config/config1.json");
        House house1 = ConfigBuilder.buildHouseFromJson("./config/config1.json");
        House house2 = ConfigBuilder.buildHouseFromJson("./config/config2.json");

        Simulation simulation = new Simulation(house1);
        simulation.runSimulation();


    }
}