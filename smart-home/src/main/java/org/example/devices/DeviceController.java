package org.example.devices;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.generators.events.EventToHandle;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Slf4j
public class DeviceController {

    private List<Device> devices = new ArrayList<>();

    public DeviceController(List<Device> devices) {
        this.devices = devices;
    }

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

    public void handleEvent(EventToHandle event) {
        log.info("ЧТО-ТО ПРОИСХОДИТ");
    }

    public Device getDeviceByName(String name){
        for (Device device : devices){
            if (device.getName().equals(name)){
                return device;
            }
        }
        return null;
    }


}
