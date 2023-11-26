package org.example;

import org.example.builders.HouseWithGarageAndPoolBuilder;
import org.example.houseComponents.Floor;
import org.example.houseComponents.vehicle.Car;
import org.example.director.Director;
import org.example.houses.HouseWithGarageAndPool;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Director director = new Director();

        HouseWithGarageAndPoolBuilder builder = new HouseWithGarageAndPoolBuilder();
        director.constructHouseWithGarageAndPool(builder, new ArrayList<>(List.of(new Floor())));

        HouseWithGarageAndPool house = builder.getResult();
        house.getGarage().addVehicle(new Car());

        System.out.println("House:\n "
                + house.getFloors().size() + " floor\n"
                        + house.getGarage().toString());
    }
}