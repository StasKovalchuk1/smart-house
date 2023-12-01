package org.example.factory;

import org.example.devices.Computer;
import org.example.devices.Device;

public class ComputerManager extends DeviceManager {
    @Override
    public Device createDevice() {
        return new Computer();
    }

}
