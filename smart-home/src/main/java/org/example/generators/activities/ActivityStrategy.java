package org.example.generators.activities;

import org.example.devices.Device;
import org.example.devices.DeviceController;

public interface ActivityStrategy {
    void performActivity(DeviceController deviceController, Device device, String entityName) throws Exception;
}
