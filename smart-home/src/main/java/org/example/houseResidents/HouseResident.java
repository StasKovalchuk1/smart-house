package org.example.houseResidents;

import lombok.Data;
import org.example.generators.activities.personActivities.strategies.PersonActivityStrategy;

@Data
public abstract class HouseResident {

    protected PersonActivityStrategy strategy;
}
