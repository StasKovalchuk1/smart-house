package org.example.factory;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.devices.CoffeeMachine;
import org.example.devices.Device;
import org.example.devices.Grill;
import org.example.devices.Oven;
import org.example.houseResidents.people.Subscriber;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class DeviceManager {
    private Device device;
    private Integer deviceID;
    private String deviceName;
    private String deviceDocumentation;

    private final List<Subscriber> subscribers = new ArrayList<>();

    public DeviceManager(Integer deviceID, String deviceName, String deviceDocumentation) {
        this.deviceID = deviceID;
        this.deviceName = deviceName;
        this.deviceDocumentation = deviceDocumentation;
    }

    public abstract Device createDevice(Integer deviceID, String deviceDocumentation);

    // TODO
    public Device collectData() {
        if (device == null) device = createDevice(deviceID, deviceDocumentation);

        // check device needs
        if (device.somethingToFix() != null) {
            notifySubscribers(device.somethingToFix());
        }
        return device;
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
