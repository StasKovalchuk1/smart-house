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
        if (isPossibleRepair(device)) sendToRepair();
        else purchaseNewDevice();
    }

    public Device getBrokenDevice(DeviceController controller) {
        return controller.getDevices().get(new Random().nextInt(0, controller.getDevices().size()));
    }

    private boolean isPossibleRepair(Device device) {
        readDeviceDocumentation(device.getDocumentation());
        return new Random().nextBoolean();
    }

    private void readDeviceDocumentation(String documentation) {
        log.info("Device documentation has been read");
    }

    private void sendToRepair() {
        log.info("Device has been sent to repair");
    }

    private void purchaseNewDevice() {
        log.info("Purchased new device");
    }

}
