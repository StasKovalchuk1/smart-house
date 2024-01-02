package org.example.factory;

import lombok.NoArgsConstructor;
import org.example.devices.CoffeeMachine;
import org.example.devices.Device;
import org.example.devices.Grill;
import org.example.devices.Oven;
import org.example.houseResidents.people.Subscriber;

import java.util.ArrayList;
import java.util.List;
public abstract class DeviceManager {
    private Device device;
    private Integer deviceID;
    private String deviceName;
    private String deviceDocumentation;
    private int deviceGasConsumption;
    private int deviceElectricityConsumption;
    private int deviceWaterConsumption;

    private final List<Subscriber> subscribers = new ArrayList<>();

    public DeviceManager(Integer deviceID, String deviceName, String deviceDocumentation) {
        this.deviceID = deviceID;
        this.deviceName = deviceName;
        this.deviceDocumentation = deviceDocumentation;
    }

    public abstract Device createDevice(Integer deviceID, String deviceDocumentation);

        // метод будет вызываться к примеру каждый месяц
    public Device collectData() {
        if (device == null) device = createDevice(deviceID, deviceDocumentation);
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
        return deviceWaterConsumption > 100;
    }

    private boolean highGasConsumption() {
        if (deviceGasConsumption > 10 && device instanceof Grill) return true;
        return deviceGasConsumption > 15 && device instanceof Oven;
    }

    private boolean highElectricityConsumption() {
        return deviceElectricityConsumption > 50;
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
