package org.example.generators.events.strategies.forPerson;

import org.example.devices.CoffeeMachine;
import org.example.devices.Device;
import org.example.devices.DeviceController;

import java.util.Optional;

public class GuestArrivalStrategy implements EventHandleByPersonStrategy{
    @Override
    public void handle(DeviceController controller) {
        Optional<Device> coffeeMachineOptional = controller.getOffDeviceByName("CoffeeMachine");
        coffeeMachineOptional.ifPresent(device -> device.getState().turnOn());
    }
}
