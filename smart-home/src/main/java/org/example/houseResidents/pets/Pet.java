package org.example.houseResidents.pets;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.decorators.BaseShelterDecorator;
import org.example.decorators.ShelterInterface;
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


//@EqualsAndHashCode(callSuper = true)
@Data
public abstract class Pet extends HouseResident {

    protected boolean isInShelter;
    protected ShelterInterface petShelter;

    public Pet(String name, House house, PetType type) {
        super(name, house, type);
    }

    //TODO раскомментирвоать строку
    @Override
    public void doActivity(Activity activity) throws Exception {
        if (this instanceof GoldenFish && !activity.toString().equals("EatFood")){
            return;
        }
        setStrategy(getStrategyByActivity(activity));
        strategy.performActivity(house.getDeviceController(), ((BaseShelterDecorator) petShelter).getWrapper(), this);
        activityAndUsageReportGenerator.writeDeviceUsage(this, ((BaseShelterDecorator) petShelter).getWrapper());
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
