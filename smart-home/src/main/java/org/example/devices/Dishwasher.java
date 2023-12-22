package org.example.devices;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Dishwasher extends Device{

    private int detergentAmount;

    public Dishwasher(Integer id, String name, String documentation) {
        super(id, name, documentation);
    }

    @Override
    public String somethingToFix() {
        if (detergentAmount < 2) return "Small reserves of detergent";
        return null;
    }

    @Override
    public void performDeviceAction() {
        detergentAmount--;
        System.out.println("Dishwasher has washed dishes");
    }
}
