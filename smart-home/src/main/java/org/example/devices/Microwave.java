package org.example.devices;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Microwave extends Device{

    private int power;
    private int timer;

    public Microwave(Integer id, String documentation) {
        super(id, "Microwave", documentation);
    }

    @Override
    public String somethingToFix() {
        return null;
    }

    @Override
    public void performDeviceAction() {
        System.out.println("Microwave has heated food");

    }
}
