package org.example.generators.events;

public enum EventToHandleByPerson implements EventToHandle{
    BREAK_DEVICE, BAD_FOOD, CHILD_GOT_HURT, GUEST_ARRIVAL, FIRE_ALARM;

//    @Override
//    public String toString() {
//        return switch (this) {
//            case BREAK_DEVICE -> "Break Device";
//            case BAD_FOOD -> "Bad Food";
//            case CHILD_GOT_HURT -> "Child Got Hurt";
//            case GUEST_ARRIVAL -> "Guest Arrival";
//            case FIRE_ALARM -> "Fire Alarm";
//            default -> super.toString();
//        };
//    }
}
