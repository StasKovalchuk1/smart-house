package org.example.generators.events.strategies.forController;

import org.example.devices.DeviceController;

public interface EventHandleByControllerStrategy {
    void handle(DeviceController controller);
}
