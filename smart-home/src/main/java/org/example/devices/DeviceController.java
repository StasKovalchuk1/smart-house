package org.example.devices;

import org.example.generators.events.EventToHandle;

import java.util.List;

public class DeviceController {

    private List<Device> devices;

    public void turnOnDevice(Device device) {
        device.getState().turnOn();
    }

    public void turnOffDevice(Device device) {
        device.getState().turnOff();
    }

    public void runDevice(Device device) {
        device.getState().run();
    }

    public void handleEvent(EventToHandle event) {}
}
