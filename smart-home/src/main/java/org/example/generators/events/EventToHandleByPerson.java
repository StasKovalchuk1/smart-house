package org.example.generators.events;

public enum EventToHandleByPerson implements EventToHandle{
    BREAK_DEVICE, BAD_FOOD, CHILD_GOT_HURT, GUEST_ARRIVAL, FIRE_ALARM;

    @Override
    public String toString() {
        // Возвращаем строковое представление каждого элемента enum
        switch (this) {
            case BREAK_DEVICE:
                return "Break Device";
            case BAD_FOOD:
                return "Bad Food";
            case CHILD_GOT_HURT:
                return "Child Got Hurt";
            case GUEST_ARRIVAL:
                return "Guest Arrival";
            case FIRE_ALARM:
                return "Fire Alarm";
            default:
                return super.toString();
        }
    }
}
