package org.example.devices;

import lombok.Data;
import org.example.generators.events.EventToHandle;

import java.util.List;

@Data
public class DeviceController {

    private List<Device> devices;

    public void turnOnDevice(Device device) {
        device.getState().turnOn();
    }

    public void turnOffDevice(Device device) {
        device.getState().turnOff();
    }

    public void turnOffAllDevices() {
        for (Device device : devices) {
            turnOffDevice(device);
        }
    }

    public void runDevice(Device device) {
        device.getState().run();
    }

    public void handleEvent(EventToHandle event) {}

    public Device getDeviceByName(String name){
        for (Device device : devices){
            if (device.getName().equals(name)){
                return device;
            }
        }
        return null;
    }


}
