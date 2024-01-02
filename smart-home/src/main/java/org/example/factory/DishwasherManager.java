package org.example.factory;

import org.example.devices.Device;
import org.example.devices.Dishwasher;
import org.example.devices.Grill;

public class DishwasherManager extends DeviceManager{


    public DishwasherManager(Integer deviceID, String deviceName, String deviceDocumentation) {
        super(deviceID, deviceName, deviceDocumentation);
    }

    @Override
    public Device createDevice(Integer deviceID, String deviceDocumentation) {
        return new Dishwasher(deviceID, deviceDocumentation);
    }
}
