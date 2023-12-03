package org.example.generators.activities.petActivities.strategies;

import lombok.Data;
import org.example.devices.Device;
import org.example.devices.DeviceController;
import org.example.generators.activities.ActivityStrategy;

@Data
public class ComeIntoShelterStrategy implements ActivityStrategy {
    @Override
    public void performActivity(DeviceController deviceController, Device device, String entityName) throws Exception {
        if (device != null) {
            deviceController.turnOnDevice(device);
            deviceController.runDevice(device);
            System.out.printf("Pet %s came into the shelter, shelter was turned on", entityName);
        }
    }
}
