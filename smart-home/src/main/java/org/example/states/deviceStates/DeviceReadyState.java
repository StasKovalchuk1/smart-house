package org.example.states.deviceStates;

import lombok.extern.slf4j.Slf4j;
import org.example.devices.Device;
import org.example.exceptions.deviceExceptions.DeviceStateException;

@Slf4j
public class DeviceReadyState extends DeviceState{

    public DeviceReadyState(Device device) {
        super(device);
        device.setTurnedOn(true);
    }

    @Override
    public void turnOn() throws DeviceStateException {
        if (!device.isTurnedOn()){
            device.changeState(new DeviceReadyState(device));
            device.setTurnedOn(true);
            log.info("Device is running");
        } else {
            log.error("Device is already turned on");
            throw new DeviceStateException("Sorry, device is already turned on");
        }
    }

    @Override
    public void turnOff() {
        device.changeState(new DeviceOffState(device));
        device.setTurnedOn(false);
        log.info("Device is turned off");
    }

    @Override
    public void run() throws DeviceStateException {
        log.error("Device can not change state to running");
        throw new DeviceStateException("Sorry, you can not change device state to running");
    }
}
