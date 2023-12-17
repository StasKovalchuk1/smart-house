package org.example.generators.activities;

import org.example.devices.Device;
import org.example.devices.DeviceController;
import org.example.houseResidents.people.Person;

public interface ActivityStrategy {
    void performActivity(DeviceController deviceController, Device device, Person person) throws Exception;
}
