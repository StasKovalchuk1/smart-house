package org.example.houseResidents.pets;

import lombok.Data;
import org.example.decorators.BaseShelterDecorator;
import org.example.devices.DeviceController;
import org.example.generators.activities.Activity;
import org.example.generators.activities.ActivityStrategy;
import org.example.generators.activities.petActivities.PetActivity;
import org.example.generators.activities.petActivities.strategies.ComeIntoShelterStrategy;
import org.example.generators.activities.petActivities.strategies.ComeOutOfShelterStrategy;
import org.example.generators.activities.petActivities.strategies.DrinkWaterStrategy;
import org.example.generators.activities.petActivities.strategies.EatFoodStrategy;
import org.example.houses.House;


public class GoldenFish extends Pet{

    public GoldenFish(String name, House house) {
        super(name, house, PetType.GOLDENFISH);
    }

    @Override
    public void doActivity(Activity activity) throws Exception {
        setStrategy(new EatFoodStrategy());
        strategy.performActivity(house.getDeviceController(), ((BaseShelterDecorator) petShelter).getWrapper(), this);
        activityAndUsageReportGenerator.writeDeviceUsage(this, ((BaseShelterDecorator) petShelter).getWrapper());
    }

}
