package org.example.houseResidents.people;

import lombok.extern.slf4j.Slf4j;
import org.example.devices.DeviceController;
import org.example.generators.events.EventToHandle;
import org.example.generators.events.EventToHandleByPerson;
import org.example.generators.events.strategies.forPerson.*;
import org.example.houses.House;

@Slf4j
public class Child extends Person{
    private Mother mother;
    private Father father;

    public Child(DeviceController deviceController, House house, Mother mother, Father father) {
        super(deviceController, house);
        this.mother = mother;
        this.father = father;
        setType(PersonType.CHILD);
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
                getEventStrategy().handle(getDeviceController());
            case CHILD_GOT_HURT:
                log.info(mother.toString() + " was chosen to handle event");
                mother.handleEvent(event);
            default:
                throw new IllegalStateException("Unexpected value: " + (EventToHandleByPerson) event);
        }
    }

    @Override
    public void update(String message) {
        // отреагировать на сообщение
    }
}
