package org.example.generators.activities.personActivities.strategies;

import org.example.devices.Device;
import org.example.devices.DeviceController;

public interface PersonActivityStrategy {
    void performActivity(DeviceController deviceController, Device device, String personName) throws Exception;
}
