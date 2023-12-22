package org.example.devices;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class WashingMachine extends Device{

    private int powderAmount;

    public WashingMachine(Integer id, String name, String documentation) {
        super(id, name, documentation);
    }

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
