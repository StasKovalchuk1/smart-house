package org.example.devices;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.decorators.ShelterInterface;

@Data
@AllArgsConstructor
public class Shelter implements ShelterInterface {

    private int waterAmount;
    private int foodAmount;
    private boolean heaterIsWorking;

    @Override
    public void shelterOn(){
        heaterIsWorking = true;
    }

    @Override
    public void shelterOff(){
        heaterIsWorking = false;
    }
}
