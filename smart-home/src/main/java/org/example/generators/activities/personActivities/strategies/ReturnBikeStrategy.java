package org.example.generators.activities.personActivities.strategies;

import lombok.extern.slf4j.Slf4j;
import org.example.devices.Device;
import org.example.devices.DeviceController;
import org.example.generators.activities.ActivityStrategy;
import org.example.houseComponents.vehicle.Vehicle;
import org.example.houseResidents.people.Person;
import org.example.houses.HouseWithGarage;

import java.util.Optional;

@Slf4j
public class ReturnBikeStrategy implements ActivityStrategy {

    // исправить логику
    @Override
    public void performActivity(DeviceController deviceController, Device device, Person person) throws Exception {
        Optional<Vehicle> bicycle = ((HouseWithGarage) person.getHouse()).getGarage().getVehicleByName("Bicycle");
        if (bicycle.isPresent()) {
            if (bicycle.get().isInUse()) {
                bicycle.get().setInUse(false);
                person.setAtHome(true);
            }
            else {
                log.info("Bicycle is already in use. " + person.getName() + " should wait.");
            }
        }
    }
}
