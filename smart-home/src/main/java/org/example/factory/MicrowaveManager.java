package org.example.factory;

import org.example.devices.Device;
import org.example.devices.Microwave;

public class MicrowaveManager extends DeviceManager{
    @Override
    public Device createDevice() {
        return new Microwave();
    }
}
