package org.example.houseComponents.vehicle;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.houseResidents.people.Person;

@Data
@Slf4j
public class Bicycle extends Vehicle{

    public Bicycle() {
        setName("Bicycle");
    }

    @Override
    public void ride(Person person) {
        setInUse(true);
        person.setAtHome(false);
        log.info("Bicycle is in use");
    }

    @Override
    public void returnToGarage(Person person) {
        setInUse(false);
        person.setAtHome(true);
        log.info("Bicycle was returned to the garage ");
    }

    @Override
    public String toString() {
        return "Bicycle";
    }
}
