package org.example.generators.events.strategies.forController;

import org.example.devices.Device;
import org.example.devices.DeviceController;

public class WaterLeakStrategy implements EventHandleByControllerStrategy{
    @Override
    public void handle(DeviceController controller) {
        Device washingMachine = controller.getDeviceByName("WashingMachine");
        Device dishWasher = controller.getDeviceByName("DishWasher");
        controller.turnOffDevice(washingMachine);
        controller.turnOffDevice(dishWasher);
    }
}
