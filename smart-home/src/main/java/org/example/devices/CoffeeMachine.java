package org.example.devices;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CoffeeMachine extends Device{

    private int capsulesAmount;

    @Override
    public String somethingToFix() {
        if (capsulesAmount < 2) return "Small reserves of capsules";
        return null;
    }

    @Override
    public void performDeviceAction() {
        capsulesAmount--;
        System.out.println("CoffeeMachine has made coffee");
    }
}
