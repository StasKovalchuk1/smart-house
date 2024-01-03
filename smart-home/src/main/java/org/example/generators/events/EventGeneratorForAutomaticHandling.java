package org.example.generators.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.example.devices.DeviceController;
import org.example.reports.reportGenerators.EventReportGenerator;

import java.util.Random;

@Slf4j
@Data
@AllArgsConstructor
public class EventGeneratorForAutomaticHandling implements EventGenerator {

    private DeviceController deviceController;
    private EventReportGenerator eventReportGenerator;

    @Override
    public void generateEvent() {
        EventToHandle eventToHandle = pickEvent();
        deviceController.handleEvent(eventToHandle);
        eventReportGenerator.writeEventToReport(null, eventToHandle);
    }

    @Override
    public EventToHandle pickEvent() {
        EventToHandleAutomatically[] events = EventToHandleAutomatically.values();
        int index = new Random().nextInt(events.length);
        log.info(events[index].toString());
        return events[index];
    }
}
