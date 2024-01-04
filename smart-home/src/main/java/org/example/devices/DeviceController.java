package org.example.devices;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.generators.events.EventGeneratorForAutomaticHandling;
import org.example.generators.events.EventToHandle;
import org.example.generators.events.EventToHandleAutomatically;
import org.example.generators.events.EventToHandleByPerson;
import org.example.generators.events.strategies.forController.EventHandleByControllerStrategy;
import org.example.generators.events.strategies.forController.PowerOutageStrategy;
import org.example.generators.events.strategies.forController.WaterLeakStrategy;
import org.example.generators.events.strategies.forPerson.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@Slf4j
public class DeviceController {

    private double totalWaterConsumption;
    private double totalGasConsumption;
    private double totalElectricityConsumption;
    private double maxTotalWaterConsumption;
    private double maxTotalGasConsumption;
    private double maxTotalElectricityConsumption;

    private List<Device> devices = new ArrayList<>();

    private EventHandleByControllerStrategy eventStrategy;

    public DeviceController(List<Device> devices) {
        this.devices = devices;
    }

    public void turnOnDevice(Device device) {
        device.getState().turnOn();
    }

    public void turnOffDevice(Device device) {
        device.getState().turnOff();
    }

    public void turnOffAllDevices() {
        for (Device device : devices) {
            turnOffDevice(device);
        }
    }

    public void runDevice(Device device) {
        device.getState().run();
    }

    public void handleEvent(EventToHandle event) {
        setStrategyByEvent(event);
        getEventStrategy().handle(this);
    }

    public void setStrategyByEvent(EventToHandle event) {
        switch ((EventToHandleAutomatically) event) {
            case POWER_OUTAGE -> setEventStrategy(new PowerOutageStrategy());
            case WATER_LEAK -> setEventStrategy(new WaterLeakStrategy());
        };
    }

    public Optional<Device> getDeviceByName(String name){
        for (Device device : devices){
            if (device.getName().equals(name)){
                return Optional.of(device);
            }
        }
        log.warn(name + " was not found");
        return Optional.empty();
    }

    public void increaseTotalWaterConsumption(double amount) {
        totalWaterConsumption += amount;
    }

    public void increaseTotalGasConsumption(double amount) {
        totalGasConsumption += amount;
    }

    public void increaseTotalElectricityConsumption(double amount) {
        totalElectricityConsumption += amount;
    }

    public void decreaseTotalWaterConsumption(double amount) {
        totalWaterConsumption -= amount;
    }

    public void decreaseTotalGasConsumption(double amount) {
        totalGasConsumption -= amount;
    }

    public void decreaseTotalElectricityConsumption(double amount) {
        totalElectricityConsumption -= amount;
    }
}
