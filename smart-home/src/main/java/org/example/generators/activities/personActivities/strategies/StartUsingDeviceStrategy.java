package org.example.generators.activities.personActivities.strategies;

import lombok.Data;
import org.example.devices.Device;
import org.example.devices.DeviceController;
import org.example.generators.activities.ActivityStrategy;
import org.example.houseResidents.HouseResident;
import org.example.houseResidents.people.Person;

@Data
public class StartUsingDeviceStrategy implements ActivityStrategy {
    @Override
    public void performActivity(DeviceController deviceController, Device device, HouseResident person){
        if (device != null) {
            if (!device.isRunning()) {
                deviceController.turnOnDevice(device);
                deviceController.runDevice(device);
            } else {
                //todo реализовать логику ожидания пока девайс не освободиться
            }
        }
    }
}

