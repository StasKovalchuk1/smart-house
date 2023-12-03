package org.example.generators.activities.strategies;

import org.example.devices.Device;
import org.example.devices.DeviceController;

public interface ActivityStrategy {
    void performActivity(DeviceController deviceController, Device device, String personName) throws Exception;
}
