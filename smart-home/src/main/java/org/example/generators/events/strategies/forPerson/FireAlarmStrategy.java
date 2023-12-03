package org.example.generators.events.strategies.forPerson;

import lombok.extern.slf4j.Slf4j;
import org.example.devices.DeviceController;

import java.util.Random;

@Slf4j
public class FireAlarmStrategy implements EventHandleByPersonStrategy{
    @Override
    public void handle(DeviceController controller) {
        controller.turnOffAllDevices();
        useFireExtinguisher();
        if (needsToCallFireDepartment()) callFireDepartment();
        log.info("The fire has been extinguished");
    }

    private void useFireExtinguisher() {
        log.info("Fire extinguisher was used");
    }

    private boolean needsToCallFireDepartment(){
        return new Random().nextBoolean();
    }

    private void callFireDepartment() {
        log.info("Calling fire department");
    }
}
