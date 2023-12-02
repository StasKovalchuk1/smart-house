package org.example.factory;

import org.example.devices.CoffeeMachine;
import org.example.devices.Device;
import org.example.devices.Grill;
import org.example.devices.Oven;
import org.example.houseResidents.persons.Subscriber;

import java.util.List;

public abstract class DeviceManager {
    private Device device;
    private int deviceGasConsumption;
    private int deviceElectricityConsumption;
    private int deviceWaterConsumption;

    private List<Subscriber> subscribers;

    public abstract Device createDevice();

        // метод будет вызываться к примеру каждый месяц
    public Device collectData() {
        if (device == null) device = createDevice();
        deviceGasConsumption = device.getGasConsumption();
        deviceElectricityConsumption = device.getElectricityConsumption();
        deviceWaterConsumption = device.getWaterConsumption();
        // какая-то логика обработки данных с девайса
        if (highWaterConsumption()) {
            notifySubscribers("High water consumption. Check " + device.toString());
        }
        if (highGasConsumption()) {
            notifySubscribers("High gas consumption. Check " + device.toString());
        }
        if (highElectricityConsumption()) {
            notifySubscribers("High electricity consumption. Check " + device.toString());
        }
        // check device needs
        if (device.somethingToFix() != null) {
            notifySubscribers(device.somethingToFix());
        }
        return device;
    }

    private boolean highWaterConsumption() {
        if (deviceWaterConsumption > 20 && device instanceof CoffeeMachine) return true;
        if (deviceWaterConsumption > 100) return true;
        return false;
    }

    private boolean highGasConsumption() {
        if (deviceGasConsumption > 10 && device instanceof Grill) return true;
        if (deviceGasConsumption > 15 && device instanceof Oven) return true;
        return false;
    }

    private boolean highElectricityConsumption() {
        if (deviceElectricityConsumption > 50) return true;
        return false;
    }


    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(String message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(message);
        }
    }

}
