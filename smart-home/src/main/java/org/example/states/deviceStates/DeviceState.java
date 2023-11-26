package org.example.states.deviceStates;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.devices.Device;
import org.example.exceptions.deviceExceptions.DeviceStateException;

@Data
@AllArgsConstructor
public abstract class DeviceState {

    protected final Device device;

    public abstract void turnOn();

    public abstract void turnOff();

    public abstract void run();


}
