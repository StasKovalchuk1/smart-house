package org.example.factory;

import org.example.devices.Device;
import org.example.devices.Dishwasher;

public class DishwasherManager extends DeviceManager{
    @Override
    public Device createDevice() {
        return new Dishwasher();
    }
}
