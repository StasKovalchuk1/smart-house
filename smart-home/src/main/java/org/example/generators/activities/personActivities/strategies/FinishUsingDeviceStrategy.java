package org.example.generators.activities.personActivities.strategies;

import lombok.Data;
import org.example.devices.Device;
import org.example.devices.DeviceController;
import org.example.generators.activities.ActivityStrategy;
import org.example.houseResidents.people.Person;

@Data
public class FinishUsingDeviceStrategy implements ActivityStrategy {
    @Override
    public void performActivity(DeviceController deviceController, Device device, Person person){
        if (device != null) {
            if (device.getState().getName().equals("Running")) {
                deviceController.turnOffDevice(device);
            } else {
                System.out.printf("%s tried to stop using %s, but %s is not being used", person.getName(), device.getName(),device.getName());
            }
        }
    }
}
