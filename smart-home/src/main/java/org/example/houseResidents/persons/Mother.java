package org.example.houseResidents.persons;

import org.example.devices.DeviceController;
import org.example.generators.events.EventToHandle;

public class Mother extends Person{

    public Mother(DeviceController deviceController) {
        super(deviceController);
    }

    @Override
    public void handleEvent(EventToHandle event) {

    }

    @Override
    public void update(String message) {

    }
}
