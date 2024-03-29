package org.example.generators.activities.petActivities;

import lombok.Data;
import org.example.generators.activities.Activity;
import org.example.generators.activities.ActivityGenerator;
import org.example.generators.activities.personActivities.PersonActivity;
import org.example.houseResidents.HouseResident;
import org.example.houseResidents.pets.GoldenFish;
import org.example.houseResidents.pets.Pet;
import org.example.reports.reportGenerators.ActivityAndUsageReportGenerator;

import java.util.List;
import java.util.Random;

@Data
public class PetActivityGenerator implements ActivityGenerator {
    private List<HouseResident> pets;
    private final Random randomNumberGenerator = new Random();
    private ActivityAndUsageReportGenerator activityAndUsageReportGenerator;

    public PetActivityGenerator(List<HouseResident> pets) {
        this.pets = pets;
//        this.activityAndUsageReportGenerator = activityAndUsageReportGenerator;
    }

    @Override
    public void generateActivity() throws Exception {
        Pet pet = (Pet) pickEntity();
        Activity activity = pickActivity();
        pet.doActivity(activity);
//        activityAndUsageReportGenerator.writeActivity(pet, activity);
    }

    @Override
    public Activity pickActivity() {
        PetActivity[] activities = PetActivity.values();
        int randomActivityIndex = randomNumberGenerator.nextInt(activities.length);
        return activities[randomActivityIndex];
    }

    @Override
    public HouseResident pickEntity() {
        int randomPetIndex = randomNumberGenerator.nextInt(pets.size());
        return pets.get(randomPetIndex);
    }
}
