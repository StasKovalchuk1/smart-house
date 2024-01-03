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
        EventToHandleByPerson[] events = EventToHandleByPerson.values();
        int index = new Random().nextInt(events.length+1);
        log.info(events[index].toString());
        return events[index];
    }

    public Person pickPerson() {
        int index = new Random().nextInt(people.size()+1);
        log.info(people.get(index).toString() + " was chosen to handle event");
        return (Person)people.get(index);
    }
}
