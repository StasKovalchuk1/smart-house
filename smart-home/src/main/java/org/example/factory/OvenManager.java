package org.example.factory;

import org.example.devices.Device;
import org.example.devices.Grill;
import org.example.devices.Oven;

public class OvenManager extends DeviceManager{

    public OvenManager(Integer deviceID, String deviceName, String deviceDocumentation) {
        super(deviceID, deviceName, deviceDocumentation);
    }

    @Override
    public Device createDevice(Integer deviceID, String deviceDocumentation) {
        return new Oven(deviceID, deviceDocumentation);
    }
}
