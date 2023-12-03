package org.example.houseResidents;

import lombok.Data;
import org.example.generators.activities.Activity;
import org.example.generators.activities.personActivities.strategies.PersonActivityStrategy;

@Data
public abstract class HouseResident {

    protected PersonActivityStrategy strategy;

    public abstract void doActivity(Activity activity) throws Exception;
}
