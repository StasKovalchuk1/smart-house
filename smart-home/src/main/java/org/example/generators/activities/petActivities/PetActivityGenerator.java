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

    private List<PetActivity> activities;
    private List<Pet> pets;
    Random randomNumberGenerator = new Random();

    @Override
    public void generateActivity() throws Exception {
        Pet pet = (Pet)pickEntity();
        Activity activity = pickActivity();
        pet.doActivity(activity);
    }

    @Override
    public Activity pickActivity() {
        int randomActivityIndex = randomNumberGenerator.nextInt(activities.size()+1);
        return activities.get(randomActivityIndex);
    }

    @Override
    public HouseResident pickEntity() {
        int randomPetIndex = randomNumberGenerator.nextInt(pets.size()+1);
        return pets.get(randomPetIndex);
    }
}
