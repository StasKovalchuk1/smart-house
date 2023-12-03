package org.example.generators.activities.personActivities;

import lombok.Data;
import org.example.generators.activities.Activity;
import org.example.generators.activities.ActivityGenerator;
import org.example.houseResidents.HouseResident;
import org.example.houseResidents.people.Person;

import java.util.List;
import java.util.Random;

@Data
public class PersonActivityGenerator implements ActivityGenerator {

    private final List<PersonActivity> activities;
    private final List<Person> people;
    Random randomNumberGenerator = new Random();


    @Override
    public void generateActivity() throws Exception {
        Activity activity = pickActivity();
        Person person = (Person)pickEntity();
        person.doActivity(activity);
    }

    @Override
    public Activity pickActivity() {
        int randomActivityIndex = randomNumberGenerator.nextInt(activities.size()+1);
        return activities.get(randomActivityIndex);
    }

    @Override
    public HouseResident pickEntity() {
        int randomPersonIndex = randomNumberGenerator.nextInt(people.size()+1);
        return people.get(randomPersonIndex);
    }
}
