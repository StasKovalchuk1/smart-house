package org.example.states.deviceStates;

import lombok.extern.slf4j.Slf4j;
import org.example.devices.Device;
import org.example.exceptions.deviceExceptions.DeviceStateException;

@Slf4j
public class DeviceReadyState extends DeviceState{

    public DeviceReadyState(Device device) {
        super(device);
    }

    @Override
    public void turnOn() {
        log.error("Device is already turned on");
    }

    @Override
    public void turnOff() {
        device.changeState(new DeviceOffState(device));
        log.info("Device is turned off");
    }

    @Override
    public void run() {
        device.changeState(new DeviceRunningState(device));
        log.info("Device is running");
    }
}
