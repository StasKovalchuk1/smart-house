package org.example.generators.events.strategies.forController;

import org.example.devices.DeviceController;

public class PowerOutageStrategy implements EventHandleByControllerStrategy{
    @Override
    public void handle(DeviceController controller) {
        controller.turnOffAllDevices();
    }
}
