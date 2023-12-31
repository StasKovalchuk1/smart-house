package org.example.generators.events;

import lombok.extern.slf4j.Slf4j;
import org.example.devices.DeviceController;

import java.util.Random;

@Slf4j
public class EventGeneratorForAutomaticHandling implements EventGenerator {
    private DeviceController deviceController;

    public EventGeneratorForAutomaticHandling(DeviceController deviceController) {
        this.deviceController = deviceController;
    }

    @Override
    public void generateEvent() {
        deviceController.handleEvent(pickEvent());
    }

    @Override
    public EventToHandle pickEvent() {
        EventToHandleAutomatically[] events = EventToHandleAutomatically.values();
        int index = new Random().nextInt(events.length);
        log.info(events[index].toString());
        return events[index];
    }
}
