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


@EqualsAndHashCode(callSuper = true)
@Slf4j
@Data
public abstract class Person extends HouseResident implements Subscriber{

    private boolean atHome;
    private EventHandleByPersonStrategy eventStrategy;

    public Person(Integer id, House house, String name, PersonType type) {
        super(id, name, house, type);
    }

    public abstract void handleEvent(EventToHandle event);

    @Override
    public void doActivity(Activity activity) throws Exception {
        if (getDeviceByActivity(activity).isPresent()) {
            Device device = getDeviceByActivity(activity).get();
            setStrategy(getStrategyByActivity(activity));
            activityAndUsageReportGenerator.writeActivity(this, activity);
            activityAndUsageReportGenerator.writeDeviceUsage(this, device);
            strategy.performActivity(house.getDeviceController(), device, this);
        } else {
            log.info(activity.toString() + " wasn't performed");
        }
    }

    protected Optional<Device> getDeviceByActivity(Activity activity) {
        DeviceController deviceController = house.getDeviceController();
        switch ((PersonActivity) activity) {
            case GetFoodFromFridge, AddFoodToFridge -> {
                if (deviceController.getRunningDeviceByName("Fridge").isPresent()) {
                    return deviceController.getRunningDeviceByName("Fridge");
                } else {
                    return Optional.empty();
                }
            }
            case StartDoingLaundry -> {
                if (deviceController.getOffDeviceByName("WashingMachine").isPresent()) {
                    return deviceController.getOffDeviceByName("WashingMachine");
                } else {
                    return Optional.empty();
                }
            }
            case FinishDoingLaundry -> {
                if (deviceController.getRunningDeviceByName("WashingMachine").isPresent()) {
                    return deviceController.getRunningDeviceByName("WashingMachine");
                } else {
                    return Optional.empty();
                }
            }
            case StartWashingDishes -> {
                if (deviceController.getOffDeviceByName("Dishwasher").isPresent()) {
                    return deviceController.getOffDeviceByName("Dishwasher");
                } else {
                    return Optional.empty();
                }
            }
            case FinishWashingDishes -> {
                if (deviceController.getRunningDeviceByName("Dishwasher").isPresent()) {
                    return deviceController.getRunningDeviceByName("Dishwasher");
                } else {
                    return Optional.empty();
                }
            }
            case StartGrillingMeet -> {
                if (deviceController.getOffDeviceByName("Grill").isPresent()) {
                    return deviceController.getOffDeviceByName("Grill");
                } else {
                    return Optional.empty();
                }
            }
            case FinishGrillingMeet -> {
                if (deviceController.getRunningDeviceByName("Grill").isPresent()) {
                    return deviceController.getRunningDeviceByName("Grill");
                } else {
                    return Optional.empty();
                }
            }
            case StartMakingCoffee -> {
                if (deviceController.getOffDeviceByName("CoffeeMachine").isPresent()) {
                    return deviceController.getOffDeviceByName("CoffeeMachine");
                } else {
                    return Optional.empty();
                }
            }
            case FinishMakingCoffee -> {
                if (deviceController.getRunningDeviceByName("CoffeeMachine").isPresent()) {
                    return deviceController.getRunningDeviceByName("CoffeeMachine");
                } else {
                    return Optional.empty();
                }
            }
            case StartHeatingFood -> {
                if (deviceController.getOffDeviceByName("Microwave").isPresent()) {
                    return deviceController.getOffDeviceByName("Microwave");
                } else {
                    return Optional.empty();
                }
            }
            case FinishHeatingFood -> {
                if (deviceController.getRunningDeviceByName("Microwave").isPresent()) {
                    return deviceController.getRunningDeviceByName("Microwave");
                } else {
                    return Optional.empty();
                }
            }
            case StartBakingFood -> {
                if (deviceController.getOffDeviceByName("Oven").isPresent()) {
                    return deviceController.getOffDeviceByName("Oven");
                } else {
                    return Optional.empty();
                }
            }
            case FinishBakingFood -> {
                if (deviceController.getRunningDeviceByName("Oven").isPresent()) {
                    return deviceController.getRunningDeviceByName("Oven");
                } else {
                    return Optional.empty();
                }
            }
            case StartUsingComputer -> {
                if (deviceController.getOffDeviceByName("Computer").isPresent()) {
                    return deviceController.getOffDeviceByName("Computer");
                } else {
                    return Optional.empty();
                }
            }
            case FinishUsingComputer -> {
                if (deviceController.getRunningDeviceByName("Computer").isPresent()) {
                    return deviceController.getRunningDeviceByName("Computer");
                } else {
                    return Optional.empty();
                }
            }
            default -> {
                return Optional.empty();
            }
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
