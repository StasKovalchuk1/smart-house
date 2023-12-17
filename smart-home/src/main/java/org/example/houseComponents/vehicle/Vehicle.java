package org.example.houseComponents.vehicle;

import lombok.Data;

@Data
public abstract class Vehicle {
    private String name;

    private boolean inUse;

    public abstract void ride();

    public abstract void returnToGarage();
}
