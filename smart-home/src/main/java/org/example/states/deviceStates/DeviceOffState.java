package org.example.states.deviceStates;

import lombok.extern.slf4j.Slf4j;
import org.example.devices.Device;
import org.example.exceptions.deviceExceptions.DeviceStateException;

@Slf4j
public class DeviceOffState extends DeviceState{

    public DeviceOffState(Device device){
        super(device);
    }

    @Override
    public void turnOn() {
        device.changeState(new DeviceReadyState(device));
        log.info("Device was turned on");
    }

    @Override
    public void turnOff() {
        log.error("Device is already turned off");
    }

    @Override
    public void run(){
        log.error("Device can not change state to running");
    }
}
