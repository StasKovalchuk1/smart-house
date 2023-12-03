package org.example.houseResidents.pets;

import lombok.Data;
import org.example.devices.Device;
import org.example.devices.DeviceController;
import org.example.devices.Shelter;
import org.example.generators.activities.Activity;
import org.example.generators.activities.ActivityStrategy;
import org.example.generators.activities.petActivities.PetActivity;
import org.example.generators.activities.petActivities.strategies.ComeOutShelterStrategy;
import org.example.generators.activities.petActivities.strategies.DrinkWaterStrategy;
import org.example.generators.activities.petActivities.strategies.EatFoodStrategy;
import org.example.generators.activities.petActivities.strategies.GoToShelterStrategy;
import org.example.houseResidents.HouseResident;



@Data
public abstract class Pet extends HouseResident {

    protected boolean isInShelter;
    private DeviceController deviceController;
    protected Shelter petShelter;
    private String name;

    @Override
    public void doActivity(Activity activity) throws Exception {
        if (this instanceof GoldenFish && !activity.toString().equals("EatFood")){
            return;
        }
        setStrategy(getStrategyByActivity(activity));
        strategy.performActivity(deviceController, petShelter, name);
    }

    @Override
    protected ActivityStrategy getStrategyByActivity(Activity activity){
        return switch ((PetActivity)activity){
            case EatFood -> new EatFoodStrategy();
            case DrinkWater -> new DrinkWaterStrategy();
            case GoToShelter -> new GoToShelterStrategy();
            case ComeOutShelter -> new ComeOutShelterStrategy();
        };
    }
}
