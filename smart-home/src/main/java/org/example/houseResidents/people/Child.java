package org.example.houseResidents.people;

import lombok.extern.slf4j.Slf4j;
import org.example.generators.events.EventToHandle;
import org.example.generators.events.EventToHandleByPerson;
import org.example.generators.events.strategies.forPerson.*;
import org.example.houses.House;

@Slf4j
public class Child extends Person{
    private final Mother mother;
    private final Father father;

    public Child(House house, String name, Mother mother, Father father) {
        super(house, name, PersonType.CHILD);
        this.mother = mother;
        this.father = father;
    }


    @Override
    public void handleEvent(EventToHandle event) {
        switch ((EventToHandleByPerson) event) {
            case BREAK_DEVICE, GUEST_ARRIVAL, FIRE_ALARM:
                log.info(father.toString() + " was chosen to handle event");
                father.handleEvent(event);
                break;
            case BAD_FOOD:
                setEventStrategy(new ExpiredFoodStrategy());
                getEventStrategy().handle(house.getDeviceController());
                break;
            case CHILD_GOT_HURT:
                log.info(mother.toString() + " was chosen to handle event");
                mother.handleEvent(event);
                break;
            case NO_EVENT_FOR_PERSON:
                setEventStrategy(new PersonNothingToDoStrategy());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + (EventToHandleByPerson) event);
        }
    }

}
