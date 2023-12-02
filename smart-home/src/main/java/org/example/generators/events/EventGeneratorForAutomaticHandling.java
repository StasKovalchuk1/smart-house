package org.example.generators.events;

import org.example.devices.Device;
import org.example.devices.DeviceController;
import org.example.persons.Person;

import java.util.List;
import java.util.Random;

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
        return events[index];
    }
}
