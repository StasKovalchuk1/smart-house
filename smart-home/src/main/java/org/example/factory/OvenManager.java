package org.example.factory;

import org.example.devices.Device;
import org.example.devices.Oven;

public class OvenManager extends DeviceManager{
    @Override
    public Device createDevice() {
        return new Oven();
    }
}
