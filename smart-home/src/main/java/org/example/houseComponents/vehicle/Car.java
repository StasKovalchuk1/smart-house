package org.example.houseComponents.vehicle;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Car extends Vehicle{

    public Car() {
        setName("Car");
    }

    @Override
    public String toString() {
        return "Car";
    }

    @Override
    public void ride() {
        setInUse(true);
        log.info("Car is in use");
    }

    @Override
    public void returnToGarage() {
        setInUse(false);
        log.info("Car was returned to the garage ");
    }
}
