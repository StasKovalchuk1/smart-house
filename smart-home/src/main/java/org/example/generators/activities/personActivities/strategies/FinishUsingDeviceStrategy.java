package org.example.generators.activities.personActivities.strategies;

import lombok.Data;
import org.example.devices.Device;
import org.example.devices.DeviceController;
import org.example.generators.activities.ActivityStrategy;

@Data
public class FinishUsingDeviceStrategy implements ActivityStrategy {
    @Override
    public void performActivity(DeviceController deviceController, Device device, String personName){
        if (device != null) {
            if (device.getState().getName().equals("Running")) {
                deviceController.turnOffDevice(device);
            } else {
                System.out.printf("%s tried to stop using %s, but %s is not being used", personName, device.getName(),device.getName());
            }
        }
    }
}
