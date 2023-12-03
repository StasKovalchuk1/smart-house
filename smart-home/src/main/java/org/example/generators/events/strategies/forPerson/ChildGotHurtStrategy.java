package org.example.generators.events.strategies.forPerson;

import lombok.extern.slf4j.Slf4j;
import org.example.devices.DeviceController;

import java.util.Random;

@Slf4j
public class ChildGotHurtStrategy implements EventHandleByPersonStrategy{
    @Override
    public void handle(DeviceController controller) {
        if (needAmbulance()) callAmbulance();
        else takeCareAboutKid();
    }

    private boolean needAmbulance() {
        return new Random().nextBoolean();
    }

    private void callAmbulance() {
        log.info("An ambulance was called");
    }

    private void takeCareAboutKid() {
        log.info("Child got medical care");
    }
}
