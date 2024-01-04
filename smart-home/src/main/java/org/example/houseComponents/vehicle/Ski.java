package org.example.houseComponents.vehicle;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.houseResidents.people.Person;


@Slf4j
public class Ski extends Vehicle{

    public Ski() {
        super(VehicleType.SKI);
    }

    @Override
    public String toString() {
        return "Ski";
    }

    @Override
    public void ride(Person person) {
        setInUse(true);
        person.setAtHome(false);
        log.info("Ski is in use");
    }

    @Override
    public void returnToGarage(Person person) {
        setInUse(false);
        person.setAtHome(true);
        log.info("Ski were returned to the garage ");
    }
}
