package org.example.generators.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.example.devices.DeviceController;
import org.example.houseResidents.HouseResident;
import org.example.houseResidents.people.Person;
import org.example.reports.reportGenerators.EventReportGenerator;

import java.util.List;
import java.util.Random;

@Slf4j
@Data
@AllArgsConstructor
public class EventGeneratorForHandlingByPerson implements EventGenerator{

    private List<HouseResident> people;
    private DeviceController deviceController;
    private EventReportGenerator eventReportGenerator;

    @Override
    public void generateEvent() {
        Person eventHandler = pickPerson();
        EventToHandle eventToHandle = pickEvent();
        eventHandler.handleEvent(eventToHandle);
        eventReportGenerator.writeEventToReport(eventHandler, eventToHandle);
    }

    @Override
    public EventToHandle pickEvent() {
        if (new Random().nextBoolean()){
            EventToHandleByPerson[] events = EventToHandleByPerson.values();
            int index = new Random().nextInt(events.length);
            log.info(events[index].toString());
            return events[index];
        }
        else {
            log.info(EventToHandleByPerson.NO_EVENT_FOR_PERSON.toString());
            return EventToHandleByPerson.NO_EVENT_FOR_PERSON;
        }
    }

    public Person pickPerson() {
        int index = new Random().nextInt(people.size());
        Person person = (Person) people.get(index);
        log.info(person.toString() + " was chosen to handle event");
        if (!person.isAtHome()) {
            log.info(person.toString() + " is not at home");
            for (HouseResident nextPerson : people) {
                if (((Person) nextPerson).isAtHome()) {
                    log.info(nextPerson.toString() + " was chosen to handle event");
                    return (Person) nextPerson;
                }
            }
        }
        return person;
    }
}
