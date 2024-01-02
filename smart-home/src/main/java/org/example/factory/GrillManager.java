package org.example.factory;

import org.example.devices.Device;
import org.example.devices.Grill;

public class GrillManager extends DeviceManager{

    public GrillManager(Integer deviceID, String deviceName, String deviceDocumentation) {
        super(deviceID, deviceName, deviceDocumentation);
    }

    @Override
    public Device createDevice(Integer deviceID, String deviceDocumentation) {
        return new Grill(deviceID, deviceDocumentation);
    }
}
