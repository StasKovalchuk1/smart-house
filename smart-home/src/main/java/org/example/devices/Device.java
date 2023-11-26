package org.example.devices;

import lombok.Data;

@Data
public abstract class Device {

    private Integer id;

    private final String documentation;
    private State state;
    private int waterConsumption;
    private int gasConsumption;
    private int electricityConsumption;
}
