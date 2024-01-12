package org.example.houseComponents.vehicle;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.example.houseResidents.people.Person;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;

@Data
@Slf4j
public abstract class Vehicle {

    protected final VehicleType type;
    private boolean inUse = false;

    private Semaphore vehicleSemaphore = new Semaphore(1);

    public Vehicle(VehicleType type) {
        this.type = type;
    }

    public abstract void ride(Person person);

    public abstract void returnToGarage(Person person);

    public void useVehicle(Person person) {
        try {
            vehicleSemaphore.acquire();
            if (isInUse()) {
                log.info(getType() + " is already in use. " + person.getName() + " should wait.");
            } else {
                ride(person);

                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        vehicleSemaphore.release();
                        returnToGarage(person);
                    }
                }, 5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            vehicleSemaphore.release();
        }
    }
}
