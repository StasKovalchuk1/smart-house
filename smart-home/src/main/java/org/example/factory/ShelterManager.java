package org.example.factory;

import org.example.devices.Device;
import org.example.devices.Shelter;

public class ShelterManager extends DeviceManager{

    @Override
    public Device createDevice() {
        return new Shelter(10, 2, false);
    }

}
