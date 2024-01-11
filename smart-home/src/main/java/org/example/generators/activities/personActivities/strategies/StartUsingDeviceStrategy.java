package org.example.generators.activities.personActivities.strategies;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.example.devices.Device;
import org.example.devices.DeviceController;
import org.example.generators.activities.ActivityStrategy;
import org.example.houseResidents.HouseResident;
import org.example.houseResidents.people.Person;

@Data
@Slf4j
public class StartUsingDeviceStrategy implements ActivityStrategy {
    @Override
    public void performActivity(DeviceController deviceController, Device device, HouseResident person){
        if (device != null) {
            if (!device.isRunning()) {
                log.info(person.getName() + " started using device: " + device.getName());
                deviceController.turnOnDevice(device);
                deviceController.runDevice(device);
            } else {
                //todo реализовать логику ожидания пока девайс не освободиться
            }
        }
    }
}

