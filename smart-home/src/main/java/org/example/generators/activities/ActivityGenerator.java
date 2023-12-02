package org.example.generators.activities;

import org.example.houseResidents.HouseResident;

public interface ActivityGenerator {
    void generateActivity() throws Exception;
    Activity pickActivity();
    HouseResident pickEntity();
}
