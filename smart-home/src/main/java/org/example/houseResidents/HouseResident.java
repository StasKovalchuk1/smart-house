package org.example.houseResidents;

import lombok.Data;
import org.example.generators.activities.strategies.ActivityStrategy;

@Data
public abstract class HouseResident {

    protected ActivityStrategy strategy;
}
