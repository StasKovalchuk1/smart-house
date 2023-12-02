package org.example.devices;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WashingMachine extends Device{

    private int powderAmount;

    @Override
    public String somethingToFix() {
        if (powderAmount < 5) return "Small reserves of laundry powder";
        return null;
    }

    @Override
    public void performDeviceAction() {
        powderAmount--;
        System.out.println("Washing machine has washed clothes");
    }
}
