package org.example.devices;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Microwave extends Device{

    private int power;
    private int timer;

    @Override
    public String somethingToFix() {
        return null;
    }
}
