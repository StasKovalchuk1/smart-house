package org.example.houseResidents.persons;

import org.example.devices.DeviceController;
import org.example.generators.events.EventToHandle;
import org.example.generators.events.EventToHandleByPerson;
import org.example.generators.events.strategies.forPerson.*;

public class Mother extends Person{

    public Mother(DeviceController deviceController) {
        super(deviceController);
    }

    @Override
    public void handleEvent(EventToHandle event) {
        setEventStrategy(getStrategyByEvent(event));
        getEventStrategy().handle();
    }

    public EventHandleByPersonStrategy getStrategyByEvent(EventToHandle event) {
        return switch ((EventToHandleByPerson) event) {
            case BREAK_DEVICE -> new BreakDeviceStrategy();
            case BAD_FOOD -> new BadFoodStrategy();
            case CHILD_GOT_HURT -> new ChildGotHurtStrategy();
            case GUEST_ARRIVAL -> new GuestArrivalStrategy();
            case FIRE_ALARM -> new FireAlarmStrategy();
        };
    }

    @Override
    public void update(String message) {

    }
}
