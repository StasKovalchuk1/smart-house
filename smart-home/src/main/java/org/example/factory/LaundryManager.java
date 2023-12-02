package org.example.factory;

import org.example.devices.Device;
import org.example.devices.WashingMachine;

public class LaundryManager extends DeviceManager{
    @Override
    public Device createDevice() {
        return new WashingMachine();
    }
}
