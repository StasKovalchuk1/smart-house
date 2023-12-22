package org.example.devices;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Grill extends Device{
    private int coalAmount;

    public Grill(Integer id, String name, String documentation) {
        super(id, name, documentation);
    }

    @Override
    public String somethingToFix() {
        if (coalAmount < 2) return "Small reserves of coal";
        return null;
    }

    @Override
    public void performDeviceAction() {
        coalAmount--;
        System.out.println("Grill has grilled food");
    }
}
