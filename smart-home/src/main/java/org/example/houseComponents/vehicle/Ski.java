package org.example.houseComponents.vehicle;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Ski extends Vehicle{

    public Ski() {
        setName("Ski");
    }

    @Override
    public String toString() {
        return "Ski";
    }

    @Override
    public void ride() {
        setInUse(true);
        log.info("Ski is in use");
    }

    @Override
    public void returnToGarage() {
        setInUse(false);
        log.info("Ski were returned to the garage ");
    }
}
