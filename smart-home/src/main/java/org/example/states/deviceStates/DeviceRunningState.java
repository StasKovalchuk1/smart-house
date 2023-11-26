package org.example.states.deviceStates;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.example.devices.Device;
import org.example.exceptions.deviceExceptions.DeviceStateException;

@Slf4j
public class DeviceRunningState extends DeviceState{


    public DeviceRunningState(Device device) {
        super(device);
    }

    @Override
    public void turnOn() throws DeviceStateException {
        log.info("Device is already turned on");
        throw new DeviceStateException("Sorry, device is already turned on");
    }

    @Override
    public void turnOff() {
        device.changeState(new DeviceReadyState(device));
        log.info("Device state changed to ready");
    }

    @Override
    public void run() throws DeviceStateException {
        if (device.isTurnedOn()){
            device.changeState(new DeviceRunningState(device));
            log.info("Device state changed running");
        } else {
            throw new DeviceStateException("Sorry, you can not tun device because it is turned off");
        }
    }
}
