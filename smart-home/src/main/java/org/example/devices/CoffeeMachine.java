package org.example.devices;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CoffeeMachine extends Device{

    private int capsulesAmount;
}
