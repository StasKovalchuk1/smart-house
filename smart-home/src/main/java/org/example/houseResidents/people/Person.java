package org.example.houseResidents.people;

import lombok.Data;
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

    public Person(Integer id, House house, String name, PersonType type) {
        super(id, name, house, type);
    }

    public abstract void handleEvent(EventToHandle event);

    @Override
    public void doActivity(Activity activity) throws Exception {
        if (getDeviceByActivity(activity).isPresent()) {
            Device device = getDeviceByActivity(activity).get();

            setStrategy(getStrategyByActivity(activity));
            strategy.performActivity(house.getDeviceController(), device, this);

            activityAndUsageReportGenerator.writeDeviceUsage(this, device);
        } else if (activity.equals(PersonActivity.StartCarRiding) || activity.equals(PersonActivity.StartBikeRiding)
                || activity.equals(PersonActivity.StartSkiing)){
            setStrategy(getStrategyByActivity(activity));
            strategy.performActivity(house.getDeviceController(), null, this);

            // todo надо что-то с этим делать
//            activityAndUsageReportGenerator.writeDeviceUsage(this, device);
        } else {
            log.info(activity.toString() + " wasn't performed");

        }
    }

    protected Optional<Device> getDeviceByActivity(Activity activity) {
        DeviceController deviceController = house.getDeviceController();
        switch ((PersonActivity) activity) {
            case GetFoodFromFridge, AddFoodToFridge:
                return deviceController.getRunningDeviceByName("Fridge");
            case StartDoingLaundry:
                return deviceController.getOffDeviceByName("WashingMachine");

            case FinishDoingLaundry:
                return deviceController.getRunningDeviceByName("WashingMachine");

            case StartWashingDishes:
                return deviceController.getOffDeviceByName("Dishwasher");

            case FinishWashingDishes:
                return deviceController.getRunningDeviceByName("Dishwasher");

            case StartGrillingMeet:
                return deviceController.getOffDeviceByName("Grill");

            case FinishGrillingMeet:
                return deviceController.getRunningDeviceByName("Grill");

            case StartMakingCoffee:
                return deviceController.getOffDeviceByName("CoffeeMachine");

            case FinishMakingCoffee:
                return deviceController.getRunningDeviceByName("CoffeeMachine");

            case StartHeatingFood:
                return deviceController.getOffDeviceByName("Microwave");

            case FinishHeatingFood:
                return deviceController.getRunningDeviceByName("Microwave");

            case StartBakingFood:
                return deviceController.getOffDeviceByName("Oven");

            case FinishBakingFood:
                return deviceController.getRunningDeviceByName("Oven");

            case StartUsingComputer:
                return deviceController.getOffDeviceByName("Computer");

            case FinishUsingComputer:
                return deviceController.getRunningDeviceByName("Computer");

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
            case StartBikeRiding -> new RideBikeStrategy();
            case StartSkiing -> new SkiStrategy();
            case StartCarRiding -> new RideCarStrategy();

        };
    }

    @Override
    public void update(String message) {
        log.info(toString() + " got the message: " + message);
    }

    @Override
    public String toString() {
        return "Person{" +
                " name='" + name + '\'' +
                " type='" + type + '\'' +
                '}';
    }

}
