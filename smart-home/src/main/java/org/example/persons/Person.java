package org.example.persons;

import org.example.devices.DeviceController;

public abstract class Person implements Subscriber{

    private String name;

    private boolean atHome;

    private final DeviceController deviceController;

    public Person(DeviceController deviceController) {
        this.deviceController = deviceController;
    }

    public abstract void handleEvent();

    public abstract void doActivity();

}
