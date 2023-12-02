package org.example.devices;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Grill extends Device{

    private int coalAmount;

    @Override
    public String somethingToFix() {
        if (coalAmount < 2) return "Small reserves of coal";
        return null;
    }
}
