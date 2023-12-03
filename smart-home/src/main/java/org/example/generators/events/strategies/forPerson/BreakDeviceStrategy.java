package org.example.generators.events.strategies.forPerson;

import lombok.extern.slf4j.Slf4j;
import org.example.devices.Device;
import org.example.devices.DeviceController;

import java.util.Random;

@Slf4j
public class BreakDeviceStrategy implements EventHandleByPersonStrategy{
    @Override
    public void handle(DeviceController controller) {
        Device device = getBrokenDevice(controller);
        if (isPossibleRepair(device)) sendToRepair(device);
        else {
            log.info("{} cannot be repaired", device.getName());
            purchaseNewDevice();
        }
    }

    public Device getBrokenDevice(DeviceController controller) {
        return controller.getDevices().get(new Random().nextInt(0, controller.getDevices().size()));
    }

    private boolean isPossibleRepair(Device device) {
        readDeviceDocumentation(device);
        return new Random().nextBoolean();
    }

    private void readDeviceDocumentation(Device device) {
        device.getDocumentation();
        log.info("{} documentation has been read", device.getName());
    }

    private void sendToRepair(Device device) {
        log.info("{} has been sent to repair", device.getName());
    }

    private void purchaseNewDevice() {
        log.info("Purchased new device");
    }

}
