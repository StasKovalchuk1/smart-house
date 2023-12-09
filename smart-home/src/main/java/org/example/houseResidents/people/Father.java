package org.example.houseResidents.people;

import org.example.devices.DeviceController;
import org.example.generators.events.EventToHandle;
import org.example.generators.events.EventToHandleByPerson;
import org.example.generators.events.strategies.forPerson.*;

public class Father extends Person{

    public Father(DeviceController deviceController) {
        super(deviceController);
        setName("father");
    }

    @Override
    public void handleEvent(EventToHandle event) {
        setStrategyByEvent(event);
        getEventStrategy().handle(getDeviceController());
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

    @Override
    public void update(String message) {

    }
}
