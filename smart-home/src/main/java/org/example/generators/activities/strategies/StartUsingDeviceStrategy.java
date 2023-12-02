package org.example.generators.activities.strategies;

import lombok.Data;
import org.example.devices.Device;
import org.example.devices.DeviceController;

@Data
public class StartUsingDeviceStrategy implements ActivityStrategy{
    @Override
    public void performActivity(DeviceController deviceController, Device device, String personName){
        if (device != null) {
            if (!device.getState().getName().equals("Running")) {
                deviceController.turnOnDevice(device);
                deviceController.runDevice(device);
            } else {
                //todo реализовать логику ожидания пока девайс не освободиться
            }
        }
    }
}

