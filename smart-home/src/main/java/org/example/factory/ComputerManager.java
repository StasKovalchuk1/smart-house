package org.example.factory;

import org.example.devices.Computer;
import org.example.devices.Device;
import org.example.devices.Grill;

public class ComputerManager extends DeviceManager {


    public ComputerManager(Integer deviceID, String deviceName, String deviceDocumentation) {
        super(deviceID, deviceName, deviceDocumentation);
    }

    @Override
    public Device createDevice(Integer deviceID, String deviceDocumentation) {
        return new Computer(deviceID, deviceDocumentation);
    }

}
