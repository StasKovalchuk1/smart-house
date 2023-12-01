package org.example.factory;

import org.example.devices.Device;
import org.example.devices.Laundry;

public class LaundryManager extends DeviceManager{
    @Override
    public Device createDevice() {
        return new Laundry();
    }
}
