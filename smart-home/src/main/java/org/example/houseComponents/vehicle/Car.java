package org.example.houseComponents.vehicle;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.houseResidents.people.Person;

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
    public void ride(Person person) {
        setInUse(true);
        person.setAtHome(false);
        log.info("Car is in use");
    }

    @Override
    public void returnToGarage(Person person) {
        setInUse(false);
        person.setAtHome(true);
        log.info("Car was returned to the garage ");
    }
}
