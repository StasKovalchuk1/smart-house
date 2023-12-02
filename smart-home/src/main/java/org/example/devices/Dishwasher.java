package org.example.devices;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Dishwasher extends Device{

    private int detergentAmount;

    @Override
    public String somethingToFix() {
        if (detergentAmount < 2) return "Small reserves of detergent";
        return null;
    }
}
