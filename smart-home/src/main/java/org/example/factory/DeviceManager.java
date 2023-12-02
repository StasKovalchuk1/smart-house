package org.example.factory;

import org.example.devices.Device;
import org.example.persons.Subscriber;

import java.util.List;

public abstract class DeviceManager {

    private String message;

    private List<Subscriber> subscribers;

    public abstract Device createDevice();

    public void collectData() {
        Device device = createDevice();
        int gasConsumption = device.getGasConsumption();
        int electricityConsumption = device.getElectricityConsumption();
        int waterConsumption = device.getWaterConsumption();

        // какая-то логика обработки данных с девайса
        if (true) {
            notifySubscribers("Something to fix");
        }
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(String message) {
        this.message = message;
        for (Subscriber subscriber : subscribers) {
            subscriber.update(this.message);
        }
    }

}
