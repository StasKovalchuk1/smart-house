package org.example.generators.events.strategies.forController;

import org.example.devices.DeviceController;


public class NothingToDoStrategy implements EventHandleByControllerStrategy{
    @Override
    public void handle(DeviceController controller) {}
}
