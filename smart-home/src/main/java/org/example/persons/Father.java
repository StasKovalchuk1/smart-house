package org.example.persons;

import org.example.devices.DeviceController;
import org.example.generators.events.EventToHandle;

public class Father extends Person{

    public Father(DeviceController deviceController) {
        super(deviceController);
    }

    @Override
    public void handleEvent(EventToHandle event) {

    }

    @Override
    public void doActivity() {

    }

    @Override
    public void update(String message) {

    }
}
