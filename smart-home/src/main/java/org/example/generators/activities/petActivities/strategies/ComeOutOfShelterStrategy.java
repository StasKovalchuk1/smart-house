package org.example.generators.activities.petActivities.strategies;

import lombok.Data;
import org.example.devices.Device;
import org.example.devices.DeviceController;
import org.example.generators.activities.ActivityStrategy;

@Data
public class ComeOutOfShelterStrategy implements ActivityStrategy {
    @Override
    public void performActivity(DeviceController deviceController, Device device, String entityName) throws Exception {
        if (device != null) {
            deviceController.turnOffDevice(device);
            System.out.printf("Pet %s came out of the shelter, shelter was turned off", entityName);
        }
    }
}
