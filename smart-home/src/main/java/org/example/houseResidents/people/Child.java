package org.example.houseResidents.people;

import org.example.devices.DeviceController;
import org.example.generators.events.EventToHandle;
import org.example.generators.events.EventToHandleByPerson;
import org.example.generators.events.strategies.forPerson.*;
import org.example.houses.House;

public class Child extends Person{
    private Mother mother;
    private Father father;

//    public Child(DeviceController deviceController, House house, Mother mother, Father father) {
//        super(deviceController, house);
//        this.mother = mother;
//        this.father = father;
//
//    }

    public Child(DeviceController deviceController, House house) {
        super(deviceController, house);
        setType(PersonType.CHILD);

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
