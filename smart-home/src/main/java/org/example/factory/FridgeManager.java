package org.example.factory;

import org.example.devices.Device;
import org.example.devices.Fridge;

public class FridgeManager extends DeviceManager{
    @Override
    public Device createDevice() {
        return new Fridge();
    }
}
