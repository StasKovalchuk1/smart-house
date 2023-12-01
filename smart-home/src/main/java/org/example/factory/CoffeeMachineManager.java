package org.example.factory;

import org.example.devices.CoffeeMachine;
import org.example.devices.Device;

public class CoffeeMachineManager extends DeviceManager{
    @Override
    public Device createDevice() {
        return new CoffeeMachine();
    }
}
