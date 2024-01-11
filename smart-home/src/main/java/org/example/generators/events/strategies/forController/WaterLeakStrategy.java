package org.example.generators.events.strategies.forController;

import org.example.devices.Device;
import org.example.devices.DeviceController;

import java.util.Optional;

public class WaterLeakStrategy implements EventHandleByControllerStrategy{
    @Override
    public void handle(DeviceController controller) {
        Optional<Device> washingMachine = controller.getRunningDeviceByName("WashingMachine");
        Optional<Device> dishWasher = controller.getRunningDeviceByName("Dishwasher");
        washingMachine.ifPresent(controller::turnOffDevice);
        dishWasher.ifPresent(controller::turnOffDevice);
    }
}
