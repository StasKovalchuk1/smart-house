package org.example.states.deviceStates;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.example.devices.Device;
import org.example.exceptions.deviceExceptions.DeviceStateException;

@Slf4j
public class DeviceRunningState extends DeviceState{


    public DeviceRunningState(Device device) {
        super(device, "Running");
    }

    @Override
    public void turnOn() {
        log.error("Device is already turned on");
    }

    @Override
    public void turnOff() {
        device.changeState(new DeviceReadyState(device));
        log.info("Device state changed to ready");
    }

    @Override
    public void run() {
        log.info("Device is already running");
    }
}
