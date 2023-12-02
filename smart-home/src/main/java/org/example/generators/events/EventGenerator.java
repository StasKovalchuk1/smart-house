package org.example.generators.events;

public interface EventGenerator {
    void generateEvent();
    EventToHandle pickEvent();
}
