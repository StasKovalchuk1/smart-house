package org.example.devices;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Computer extends Device{
    public Computer(Integer id, String name, String documentation) {
        super(id, name, documentation);
    }

    @Override
    public String somethingToFix() {
        return null;
    }

    @Override
    public void performDeviceAction() {
        System.out.println("Computer was used");
    }
}
