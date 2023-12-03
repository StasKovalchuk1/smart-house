package org.example.generators.events;

import org.example.devices.DeviceController;
import org.example.houseResidents.people.Person;

import java.util.List;
import java.util.Random;

public class EventGeneratorForHandlingByPerson implements EventGenerator{
    private List<Person> people;

    private DeviceController deviceController;

    public EventGeneratorForHandlingByPerson(List<Person> people, DeviceController deviceController) {
        this.people = people;
        this.deviceController = deviceController;
    }

    @Override
    public void generateEvent() {
        pickPerson().handleEvent(pickEvent());
    }

    @Override
    public EventToHandle pickEvent() {
        EventToHandleByPerson[] events = EventToHandleByPerson.values();
        int index = new Random().nextInt(events.length);
        return events[index];
    }

    public Person pickPerson() {
        return null;
    }
}
