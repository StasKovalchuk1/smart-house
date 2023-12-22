package org.example.factory;

import org.example.devices.Device;
import org.example.devices.Grill;
import org.example.devices.WashingMachine;

public class WashingMachineManager extends DeviceManager{

    public WashingMachineManager(Integer deviceID, String deviceName, String deviceDocumentation) {
        super(deviceID, deviceName, deviceDocumentation);
    }

    @Override
    public Device createDevice(Integer deviceID, String deviceName, String deviceDocumentation) {
        return new Grill(deviceID, deviceName, deviceDocumentation);
    }
}
