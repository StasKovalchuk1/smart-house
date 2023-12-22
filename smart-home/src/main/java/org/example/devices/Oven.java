package org.example.devices;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Oven extends Device{

    private int timer;
    private int temperature;

    public Oven(Integer id, String name, String documentation) {
        super(id, name, documentation);
    }

    @Override
    public String somethingToFix() {
        return null;
    }

    @Override
    public void performDeviceAction() {
        System.out.println("Oven has baked food");
    }
}
