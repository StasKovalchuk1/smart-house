package org.example.factory;

import org.example.devices.Device;
import org.example.devices.Grill;

public class GrillManager extends DeviceManager{
    @Override
    public Device createDevice() {
        return new Grill();
    }

}
