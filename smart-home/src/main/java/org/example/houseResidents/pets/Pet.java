package org.example.houseResidents.pets;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.devices.DeviceController;
import org.example.devices.Shelter;
import org.example.generators.activities.Activity;
import org.example.generators.activities.ActivityStrategy;
import org.example.generators.activities.petActivities.PetActivity;
import org.example.generators.activities.petActivities.strategies.ComeOutOfShelterStrategy;
import org.example.generators.activities.petActivities.strategies.DrinkWaterStrategy;
import org.example.generators.activities.petActivities.strategies.EatFoodStrategy;
import org.example.generators.activities.petActivities.strategies.ComeIntoShelterStrategy;
import org.example.houseResidents.HouseResident;
import org.example.houses.House;


@EqualsAndHashCode(callSuper = true)
@Data
public abstract class Pet extends HouseResident {

    protected boolean isInShelter;
    protected Shelter petShelter;

    public Pet(DeviceController deviceController, String name, House house, PetType type) {
        super(deviceController, name, house, type);
    }

    //TODO раскомментирвоать строку
    @Override
    public void doActivity(Activity activity) throws Exception {
        if (this instanceof GoldenFish && !activity.toString().equals("EatFood")){
            return;
        }
        setStrategy(getStrategyByActivity(activity));
//        strategy.performActivity(deviceController, petShelter, name);
        activityAndUsageReportGenerator.writeDeviceUsage(this, petShelter);
    }

    @Override
    protected ActivityStrategy getStrategyByActivity(Activity activity){
        return switch ((PetActivity)activity){
            case EatFood -> new EatFoodStrategy();
            case DrinkWater -> new DrinkWaterStrategy();
            case GoToShelter -> new ComeIntoShelterStrategy();
            case ComeOutShelter -> new ComeOutOfShelterStrategy();
        };
    }
}
