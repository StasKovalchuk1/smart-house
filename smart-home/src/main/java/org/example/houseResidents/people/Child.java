package org.example.houseResidents.people;

import org.example.devices.DeviceController;
import org.example.generators.events.EventToHandle;
import org.example.generators.events.EventToHandleByPerson;
import org.example.generators.events.strategies.forPerson.*;

public class Child extends Person{
    private Mother mother;
    private Father father;

    public Child(DeviceController deviceController, Mother mother, Father father) {
        super(deviceController);
        this.mother = mother;
        this.father = father;
    }

    @Override
    public void handleEvent(EventToHandle event) {
        // ребенок просит отца порешать
        switch ((EventToHandleByPerson) event) {
            case BREAK_DEVICE, GUEST_ARRIVAL, FIRE_ALARM:
                father.handleEvent(event);
                break;
            case BAD_FOOD:
                setEventStrategy(new ExpiredFoodStrategy());
                getEventStrategy().handle(getDeviceController());
            case CHILD_GOT_HURT:
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
