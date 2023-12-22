package org.example.generators.activities.petActivities.strategies;

import lombok.Data;
import org.example.devices.Device;
import org.example.devices.DeviceController;
import org.example.generators.activities.ActivityStrategy;
import org.example.houseResidents.people.Person;

@Data
public class ComeIntoShelterStrategy implements ActivityStrategy {

    // TODO пофиксить person аргумент
    @Override
    public void performActivity(DeviceController deviceController, Device device, Person entityName) throws Exception {
        if (device != null) {
            deviceController.turnOnDevice(device);
            deviceController.runDevice(device);
            System.out.printf("Pet %s came into the shelter, shelter was turned on", entityName);
        }
    }
}
