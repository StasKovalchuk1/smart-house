package org.example.generators.activities.personActivities.strategies;

import lombok.extern.slf4j.Slf4j;
import org.example.devices.Device;
import org.example.devices.DeviceController;
import org.example.generators.activities.ActivityStrategy;
import org.example.houseComponents.vehicle.Vehicle;
import org.example.houseComponents.vehicle.VehicleType;
import org.example.houseResidents.HouseResident;
import org.example.houseResidents.people.Person;
import org.example.houses.HouseType;
import org.example.houses.HouseWithGarage;
import org.example.houses.HouseWithGarageAndPool;

import java.util.Optional;

@Slf4j
public class RideBikeStrategy implements ActivityStrategy {

    @Override
    public void performActivity(DeviceController deviceController, Device device, HouseResident person) throws Exception {
        HouseType type = person.getHouse().getType();
        switch (type){
            case SIMPLE, WITH_POOL -> log.info("There is no bike to ride");
            case WITH_GARAGE -> {
                Optional<Vehicle> bicycle = ((HouseWithGarage) person.getHouse()).getGarage().getVehicleByType(VehicleType.BICYCLE);
                bicycle.ifPresent(vehicle -> vehicle.useVehicle((Person) person));
            }
            case WITH_GARAGE_AND_POOL -> {
                Optional<Vehicle> bicycle = ((HouseWithGarageAndPool) person.getHouse()).getGarage().getVehicleByType(VehicleType.BICYCLE);
                bicycle.ifPresent(vehicle -> vehicle.useVehicle((Person) person));
            }
        }
    }
}
