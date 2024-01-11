package org.example.generators.activities.personActivities;

import lombok.Data;
import org.example.generators.activities.Activity;
import org.example.generators.activities.ActivityGenerator;
import org.example.houseResidents.HouseResident;
import org.example.houseResidents.people.Person;
import org.example.houseResidents.people.PersonType;
import org.example.reports.reportGenerators.ActivityAndUsageReportGenerator;

import java.util.List;
import java.util.Random;

@Data
public class PersonActivityGenerator implements ActivityGenerator {

    private List<HouseResident> people;
    private final Random randomNumberGenerator = new Random();
//    private ActivityAndUsageReportGenerator activityAndUsageReportGenerator;

    public PersonActivityGenerator(List<HouseResident> people) {
        this.people = people;
//        this.activityAndUsageReportGenerator = reportGenerator;
    }

    @Override
    public void generateActivity() throws Exception {
        Activity activity = pickActivity();
        Person person = (Person)pickEntity();
//        activityAndUsageReportGenerator.writeActivity(person, activity);
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
        int index = randomNumberGenerator.nextInt(people.size());
        return people.get(index);
    }
}
