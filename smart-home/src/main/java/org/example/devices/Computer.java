package org.example.devices;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Computer extends Device{
    @Override
    public String somethingToFix() {
        return null;
    }
}
