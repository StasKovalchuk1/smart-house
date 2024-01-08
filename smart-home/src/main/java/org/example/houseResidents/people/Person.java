package org.example.houseResidents.people;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.example.devices.Device;
import org.example.devices.DeviceController;
import org.example.generators.activities.Activity;
import org.example.generators.activities.ActivityStrategy;
import org.example.generators.activities.personActivities.PersonActivity;
import org.example.generators.activities.personActivities.strategies.*;
import org.example.generators.events.EventToHandle;
import org.example.generators.events.strategies.forPerson.EventHandleByPersonStrategy;
import org.example.houseResidents.HouseResident;
import org.example.houses.House;

import java.util.Optional;

//@EqualsAndHashCode(callSuper = true)
@Slf4j
@Data
public abstract class Person extends HouseResident implements Subscriber{

    private boolean atHome;
    private EventHandleByPersonStrategy eventStrategy;

    public Person(House house, String name, PersonType type) {
        super(name, house, type);
    }

    public abstract void handleEvent(EventToHandle event);

    @Override
    public void doActivity(Activity activity) throws Exception {
        if (getDeviceByActivity(activity).isPresent()) {
            Device device = getDeviceByActivity(activity).get();
            setStrategy(getStrategyByActivity(activity));
            strategy.performActivity(house.getDeviceController(), device, this);
            activityAndUsageReportGenerator.writeDeviceUsage(this, device);
        } else {
            log.info(activity.toString() + " wasn't performed");
        }
    }

    protected Optional<Device> getDeviceByActivity(Activity activity) {
        DeviceController deviceController = house.getDeviceController();
        switch ((PersonActivity) activity) {
            case GetFoodFromFridge, AddFoodToFridge:
                if (deviceController.getDeviceByName("Fridge").isPresent()) {
                    return deviceController.getDeviceByName("Fridge");
                } else {
                    return Optional.empty();
                }
            case StartDoingLaundry, FinishDoingLaundry:
                if (deviceController.getDeviceByName("WashingMachine").isPresent()) {
                    return deviceController.getDeviceByName("WashingMachine");
                } else {
                    return Optional.empty();
                }
            case StartWashingDishes, FinishWashingDishes:
                if (deviceController.getDeviceByName("Dishwasher").isPresent()) {
                    return deviceController.getDeviceByName("Dishwasher");
                } else {
                    return Optional.empty();
                }
            case StartGrillingMeet, FinishGrillingMeet:
                if (deviceController.getDeviceByName("Grill").isPresent()) {
                    return deviceController.getDeviceByName("Grill");
                } else {
                    return Optional.empty();
                }
            case StartMakingCoffee, FinishMakingCoffee:
                if (deviceController.getDeviceByName("CoffeeMachine").isPresent()) {
                    return deviceController.getDeviceByName("CoffeeMachine");
                } else {
                    return Optional.empty();
                }
            case StartHeatingFood, FinishHeatingFood:
                if (deviceController.getDeviceByName("Microwave").isPresent()) {
                    return deviceController.getDeviceByName("Microwave");
                } else {
                    return Optional.empty();
                }
            case StartBakingFood, FinishBakingFood:
                if (deviceController.getDeviceByName("Oven").isPresent()) {
                    return deviceController.getDeviceByName("Oven");
                } else {
                    return Optional.empty();
                }
            case StartUsingComputer, FinishUsingComputer:
                if (deviceController.getDeviceByName("Computer").isPresent()) {
                    return deviceController.getDeviceByName("Computer");
                } else {
                    return Optional.empty();
                }
            default:
                return Optional.empty();
        }
    }

    @Override
    protected ActivityStrategy getStrategyByActivity(Activity activity) {
        return switch ((PersonActivity) activity) {
            case GetFoodFromFridge -> new GetFoodFromFridgeStrategy();

            case AddFoodToFridge -> new AddFoodToFridgeStrategy();

            case StartDoingLaundry, StartWashingDishes,
                 StartGrillingMeet, StartMakingCoffee,
                 StartHeatingFood, StartBakingFood,
                 StartUsingComputer -> new StartUsingDeviceStrategy();

            case FinishDoingLaundry, FinishWashingDishes,
                 FinishGrillingMeet, FinishMakingCoffee,
                 FinishHeatingFood, FinishBakingFood,
                 FinishUsingComputer -> new FinishUsingDeviceStrategy();
        };
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                "type='" + type + '\'' +
                '}';
    }
}
