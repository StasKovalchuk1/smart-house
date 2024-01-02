package org.example.factory;

import org.example.devices.Device;
import org.example.devices.Grill;
import org.example.devices.Microwave;

public class MicrowaveManager extends DeviceManager{
    public MicrowaveManager(Integer deviceID, String deviceName, String deviceDocumentation) {
        super(deviceID, deviceName, deviceDocumentation);
    }

    @Override
    public Device createDevice(Integer deviceID, String deviceDocumentation) {
        return new Microwave(deviceID, deviceDocumentation);
    }
}
