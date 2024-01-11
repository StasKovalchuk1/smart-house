package org.example.houseResidents.people;

import org.example.devices.DeviceController;
import org.example.generators.events.EventToHandle;
import org.example.generators.events.EventToHandleByPerson;
import org.example.generators.events.strategies.forPerson.*;
import org.example.houses.House;

public class Mother extends Person{

    public Mother(Integer id, House house, String name) {
        super(id, house, name, PersonType.MOTHER);
    }

    @Override
    public void handleEvent(EventToHandle event) {
        setStrategyByEvent(event);
        getEventStrategy().handle(house.getDeviceController());
    }

    public void setStrategyByEvent(EventToHandle event) {
        switch ((EventToHandleByPerson) event) {
            case BREAK_DEVICE -> setEventStrategy(new BreakDeviceStrategy());
            case BAD_FOOD -> setEventStrategy(new ExpiredFoodStrategy());
            case CHILD_GOT_HURT -> setEventStrategy(new ChildGotHurtStrategy());
            case GUEST_ARRIVAL -> setEventStrategy(new GuestArrivalStrategy());
            case FIRE_ALARM -> setEventStrategy(new FireAlarmStrategy());
        };
    }

//    public EventHandleByPersonStrategy getStrategyByEvent(EventToHandle event) {
//        return switch ((EventToHandleByPerson) event) {
//            case BREAK_DEVICE -> new BreakDeviceStrategy();
//            case BAD_FOOD -> new ExpiredFoodStrategy();
//            case CHILD_GOT_HURT -> new ChildGotHurtStrategy();
//            case GUEST_ARRIVAL -> new GuestArrivalStrategy();
//            case FIRE_ALARM -> new FireAlarmStrategy();
//        };
//    }

    @Override
    public void update(String message) {

    }
}
