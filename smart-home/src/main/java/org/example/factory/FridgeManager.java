package org.example.factory;

import org.example.devices.Device;
import org.example.devices.Fridge;
import org.example.devices.Grill;

public class FridgeManager extends DeviceManager{

    public FridgeManager(Integer deviceID, String deviceName, String deviceDocumentation) {
        super(deviceID, deviceName, deviceDocumentation);
    }

    @Override
    public Device createDevice(Integer deviceID, String deviceName, String deviceDocumentation) {
        return new Fridge(deviceID, deviceName, deviceDocumentation);
    }
}
