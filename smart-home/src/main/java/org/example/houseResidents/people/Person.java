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

@EqualsAndHashCode(callSuper = true)
@Slf4j
@Data
public abstract class Person extends HouseResident implements Subscriber{

    private boolean atHome;
    private EventHandleByPersonStrategy eventStrategy;

    public Person(DeviceController deviceController, House house, String name, PersonType type) {
        super(deviceController, name, house, type);
    }

    public abstract void handleEvent(EventToHandle event);

    @Override
    public void doActivity(Activity activity) throws Exception {
        Device device = getDeviceByActivity(activity);
        setStrategy(getStrategyByActivity(activity));
        strategy.performActivity(deviceController, device, this);
        activityAndUsageReportGenerator.writeDeviceUsage(this, device);
    }

    protected Device getDeviceByActivity(Activity activity) {
        return switch ((PersonActivity) activity) {
            case GetFoodFromFridge, AddFoodToFridge -> deviceController.getDeviceByName("Fridge").get();
            case StartDoingLaundry, FinishDoingLaundry -> deviceController.getDeviceByName("Washing machine").get();
            case StartWashingDishes, FinishWashingDishes -> deviceController.getDeviceByName("Dishwasher").get();
            case StartGrillingMeet, FinishGrillingMeet -> deviceController.getDeviceByName("Grill").get();
            case StartMakingCoffee, FinishMakingCoffee -> deviceController.getDeviceByName("Coffee Machine").get();
            case StartHeatingFood, FinishHeatingFood -> deviceController.getDeviceByName("Microwave").get();
            case StartBakingFood, FinishBakingFood -> deviceController.getDeviceByName("Oven").get();
            case StartUsingComputer, FinishUsingComputer -> deviceController.getDeviceByName("Computer").get();
        };
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
