package org.example.devices;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Oven extends Device{

    private int timer;
    private int temperature;
}
