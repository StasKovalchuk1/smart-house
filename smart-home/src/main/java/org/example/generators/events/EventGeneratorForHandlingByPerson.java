package org.example.generators.events;

import lombok.extern.slf4j.Slf4j;
import org.example.devices.DeviceController;
import org.example.houseResidents.people.Person;

import java.util.List;
import java.util.Random;

@Slf4j
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
        log.info(events[index].toString());
        return events[index];
    }

    public Person pickPerson() {
        int index = new Random().nextInt(people.size());
        log.info(people.get(index).toString() + " was chosen to handle event");
        return people.get(index);
    }
}
