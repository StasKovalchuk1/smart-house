package org.example.houseResidents.pets;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.decorators.BaseShelterDecorator;
import org.example.decorators.ShelterInterface;
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
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class Pet extends HouseResident {

    protected boolean isInShelter;
    protected ShelterInterface petShelter;

    public Pet(Integer id, String name, House house, PetType type) {
        super(id, name, house, type);
    }

    @Override
    public void doActivity(Activity activity) throws Exception {
        setStrategy(getStrategyByActivity(activity));
        activityAndUsageReportGenerator.writeActivity(this, activity);
        activityAndUsageReportGenerator.writeDeviceUsage(this, ((BaseShelterDecorator) petShelter).getWrapper());
        strategy.performActivity(house.getDeviceController(), ((BaseShelterDecorator) petShelter).getWrapper(), this);
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
