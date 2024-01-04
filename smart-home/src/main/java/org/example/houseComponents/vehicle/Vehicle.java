package org.example.houseComponents.vehicle;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.example.houseResidents.people.Person;

@Data
@Slf4j
public abstract class Vehicle {

    protected final VehicleType type;
    private boolean inUse = false;

    public Vehicle(VehicleType type) {
        this.type = type;
    }

    public abstract void ride(Person person);

    public abstract void returnToGarage(Person person);

    public void useVehicle(Person person) {
        try {
            if (isInUse()) {
                log.info(getType() + " is already in use. " + person.getName() + " should wait.");
            } else {
                ride(person);

                // Создаем новый поток
                Thread thread = new Thread(() -> {
                    try {
                        // Подождать 5 секунд
                        Thread.sleep(5000);

                        // Код, который выполнится после задержки
                        returnToGarage(person);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

                // Запустить поток
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
