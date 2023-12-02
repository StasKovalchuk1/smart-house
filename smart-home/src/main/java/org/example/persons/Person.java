package org.example.persons;

import org.example.devices.DeviceController;
import org.example.generators.events.EventToHandle;

public abstract class Person implements Subscriber{

    private String name;

    private boolean atHome;

    private final DeviceController deviceController;

    public Person(DeviceController deviceController) {
        this.deviceController = deviceController;
    }

    public abstract void handleEvent(EventToHandle event);

    public abstract void doActivity();

}
