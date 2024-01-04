package org.example.devices;

import lombok.Data;
import org.example.states.deviceStates.DeviceOffState;
import org.example.states.deviceStates.DeviceState;

@Data
public abstract class Device {
    private Integer id;
    private String name;
    private String documentation;
    private DeviceState state;
    private double averageWaterConsumption;
    private double averageGasConsumption;
    private double averageElectricityConsumption;
    private double currentWaterConsumption;
    private double currentGasConsumption;
    private double currentElectricityConsumption;
    private DeviceController controller;

    protected Device() {
        this.state = new DeviceOffState(this);
    }

    public Device(Integer id, String name, String documentation) {
        this.id = id;
        this.name = name;
        this.documentation = documentation;
        this.state = new DeviceOffState(this);
    }

    public void changeState(DeviceState state){
        this.state=state;
    }

    public abstract String somethingToFix();

    public abstract void performDeviceAction();

    public abstract void stopDeviceAction();
}
