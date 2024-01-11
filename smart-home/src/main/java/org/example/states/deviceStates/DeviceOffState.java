package org.example.states.deviceStates;

import lombok.extern.slf4j.Slf4j;
import org.example.devices.Device;
import org.example.exceptions.deviceExceptions.DeviceStateException;

@Slf4j
public class DeviceOffState extends DeviceState{

    public DeviceOffState(Device device){
        super(device, "Off");
    }

    @Override
    public void turnOn() {
        device.changeState(new DeviceReadyState(device));
        log.info("{} was turned on", device.toString());
    }

    @Override
    public void turnOff() {
        log.info("{} is already turned off", device.toString());
    }

    @Override
    public void run(){
        log.info("{} can not change state to running", device.toString());
    }
}
