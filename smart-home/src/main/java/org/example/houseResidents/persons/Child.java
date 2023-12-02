package org.example.houseResidents.persons;

import org.example.devices.DeviceController;
import org.example.generators.events.EventToHandle;

public class Child extends Person{

    public Child(DeviceController deviceController) {
        super(deviceController);
    }

    @Override
    public void handleEvent(EventToHandle event) {

    }

    @Override
    public void update(String message) {
        // отреагировать на сообщение
    }
}
