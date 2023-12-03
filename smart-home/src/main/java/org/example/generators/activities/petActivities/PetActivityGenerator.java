package org.example.generators.activities.petActivities;

import lombok.Data;
import org.example.generators.activities.Activity;
import org.example.generators.activities.ActivityGenerator;
import org.example.houseResidents.HouseResident;
import org.example.houseResidents.pets.GoldenFish;
import org.example.houseResidents.pets.Pet;

import java.util.List;
import java.util.Random;

@Data
public class PetActivityGenerator implements ActivityGenerator {

    private List<LandAnimalActivity> landAnimalActivities;
    private List<WaterAnimalActivity> waterAnimalActivities;
    private List<Pet> pets;
    Random randomNumberGenerator = new Random();

    @Override
    public void generateActivity() {
        Pet pet = (Pet)pickEntity();
        Activity activity;

        if (pet instanceof GoldenFish){
            activity = pickWaterAnimalActivity();
        } else {
            activity = pickActivity();
        }
        pet.doActivity(activity);
    }

    @Override
    public Activity pickActivity() {
        int randomActivityIndex = randomNumberGenerator.nextInt(landAnimalActivities.size()+1);
        return landAnimalActivities.get(randomActivityIndex);
    }

    public Activity pickWaterAnimalActivity(){
        int randomActivityIndex = randomNumberGenerator.nextInt(waterAnimalActivities.size()+1);
        return waterAnimalActivities.get(randomActivityIndex);
    }

    @Override
    public HouseResident pickEntity() {
        int randomPetIndex = randomNumberGenerator.nextInt(pets.size()+1);
        return pets.get(randomPetIndex);
    }
}
