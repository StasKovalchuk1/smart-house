package org.example.persons;

import org.example.devices.DeviceController;

public class Child extends Person{

    public Child(DeviceController deviceController) {
        super(deviceController);
    }

    @Override
    public void handleEvent() {

    }

    @Override
    public void doActivity() {

    }

    @Override
    public void update(String message) {
        // отреагировать на сообщение
    }
}
