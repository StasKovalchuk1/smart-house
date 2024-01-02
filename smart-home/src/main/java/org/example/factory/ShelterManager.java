package org.example.factory;

import lombok.Data;
import org.example.devices.Device;
import org.example.devices.Grill;
import org.example.devices.Shelter;

public class ShelterManager extends DeviceManager{

    public ShelterManager(Integer deviceID, String deviceName, String deviceDocumentation) {
        super(deviceID, deviceName, deviceDocumentation);
    }

    @Override
    public Device createDevice(Integer deviceID, String deviceDocumentation) {
        return new Shelter(deviceID, deviceDocumentation);
    }

}
