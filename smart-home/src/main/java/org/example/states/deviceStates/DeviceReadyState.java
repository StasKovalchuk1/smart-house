package org.example.states.deviceStates;

import lombok.extern.slf4j.Slf4j;
import org.example.devices.Device;
import org.example.exceptions.deviceExceptions.DeviceStateException;

@Slf4j
public class DeviceReadyState extends DeviceState{

    public DeviceReadyState(Device device) {
        super(device, "Ready");
    }

    @Override
    public void turnOn() {
        log.info("{} is already turned on", device.toString());
    }

    @Override
    public void turnOff() {
        device.changeState(new DeviceOffState(device));
        log.info("{} is turned off", device.toString());
    }

    @Override
    public void run() {
        device.changeState(new DeviceRunningState(device));
        device.performDeviceAction();
        log.info("{} is running", device.toString());
    }
}
