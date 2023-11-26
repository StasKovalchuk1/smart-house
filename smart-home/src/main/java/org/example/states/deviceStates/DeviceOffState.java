package org.example.states.deviceStates;

import lombok.extern.slf4j.Slf4j;
import org.example.devices.Device;
import org.example.exceptions.deviceExceptions.DeviceStateException;

@Slf4j
public class DeviceOffState extends DeviceState{

    public DeviceOffState(Device device){
        super(device);
        device.setTurnedOn(false);
    }

    @Override
    public void turnOn() {
        device.changeState(new DeviceReadyState(device));
        log.info("Device was turned on");
    }

    @Override
    public void turnOff() throws DeviceStateException {
        if (device.isTurnedOn()){
            device.changeState(new DeviceOffState(device));
            log.info("Device was turned off");
        } else {
            log.error("Device is already turned off");
            throw new DeviceStateException("Sorry, device is already turned off");
        }
    }

    @Override
    public void run() throws DeviceStateException {
        log.error("Device can not change state to running");
        throw new DeviceStateException("Sorry, you can not change device state to running");
    }
}
