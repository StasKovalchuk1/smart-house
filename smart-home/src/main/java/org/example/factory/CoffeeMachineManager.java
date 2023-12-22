package org.example.factory;

import org.example.devices.CoffeeMachine;
import org.example.devices.Device;
import org.example.devices.Grill;

public class CoffeeMachineManager extends DeviceManager{


    public CoffeeMachineManager(Integer deviceID, String deviceName, String deviceDocumentation) {
        super(deviceID, deviceName, deviceDocumentation);
    }

    @Override
    public Device createDevice(Integer deviceID, String deviceName, String deviceDocumentation) {
        return new CoffeeMachine(deviceID, deviceName, deviceDocumentation);
    }
}
