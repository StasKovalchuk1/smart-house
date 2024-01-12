package org.example.reports.reportGenerators;

import lombok.Data;
import org.example.generators.events.EventToHandle;
import org.example.houseResidents.people.Person;

import java.io.File;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class EventReportGenerator extends BaseReportGenerator {

    private Map<Person, EventToHandle> eventsHandledByPeople = new HashMap<>();
    private List<EventToHandle> eventsHandledAutomatically = new ArrayList<>();

    public EventReportGenerator() {
        this.reportFile = "smart-home/src/main/java/org/example/reports/reports/eventReport.txt";
        try {
            this.writer = new PrintWriter(new PrintWriter(reportFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateReport() {
        writer.println("EVENTS REPORT");
        writer.println("");
        printEventsHandledByPeople();
        printEventsHandledAutomatically();
        writer.close();
    }

    private void printEventsHandledByPeople() {
        writer.println("EVENTS HANDLED BY PEOPLE:");
        int i = 1;
        for (Map.Entry<Person, EventToHandle> entry : eventsHandledByPeople.entrySet()) {
            writer.println(i + ") Event '" + entry.getValue() + "' was handled by person '" + entry.getKey().getType() + "'");
            ++i;
        }
        writer.println("---");
    }

    private void printEventsHandledAutomatically(){
        writer.println("EVENTS HANDLED AUTOMATICALLY:");
        int j = 1;
        for (EventToHandle event : eventsHandledAutomatically){
            writer.println(j + ") Event '" + event + "' was handled automatically");
            ++j;
        }
    }

    public void writeEventToReport(Person eventHandler, EventToHandle handledEvent) {
        if (eventHandler != null) {
            eventsHandledByPeople.put(eventHandler, handledEvent);
        } else {
            eventsHandledAutomatically.add(handledEvent);
        }
    }
}
