package org.example.generators.activities.personActivities;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.example.generators.activities.Activity;
import org.example.generators.activities.ActivityGenerator;
import org.example.houseResidents.HouseResident;
import org.example.houseResidents.people.Person;
import org.example.houseResidents.people.PersonType;
import org.example.reports.reportGenerators.ActivityAndUsageReportGenerator;

import java.util.List;
import java.util.Random;

@Data
@Slf4j
public class PersonActivityGenerator implements ActivityGenerator {

    private List<HouseResident> people;
    private final Random randomNumberGenerator = new Random();

    public PersonActivityGenerator(List<HouseResident> people) {
        this.people = people;
    }

    @Override
    public void generateActivity() throws Exception {
        Activity activity = pickActivity();
        Person person = (Person)pickEntity();
        person.doActivity(activity);
    }

    @Override
    public Activity pickActivity() {
        PersonActivity[] activities = PersonActivity.values();
        int index = randomNumberGenerator.nextInt(activities.length);
        return activities[index];
    }

    @Override
    public HouseResident pickEntity() {
        int index = new Random().nextInt(people.size());
        Person person = (Person) people.get(index);
        log.info(person.toString() + " was chosen to do something");
        if (!person.isAtHome()) {
            log.info(person.toString() + " is not at home");
            for (HouseResident nextPerson : people) {
                if (((Person) nextPerson).isAtHome()) {
                    log.info(nextPerson.toString() + " was chosen to do something");
                    return nextPerson;
                }
            }
        }
        return person;
    }
}
