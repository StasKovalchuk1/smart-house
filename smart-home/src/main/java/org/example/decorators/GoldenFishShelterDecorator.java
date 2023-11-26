package org.example.decorators;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.devices.Shelter;

@Slf4j
@Data
@NoArgsConstructor
public class GoldenFishShelterDecorator extends BaseShelterDecorator {

    private double oxygenLvl;
    private boolean bubbleMakerIsWorking = false;

    public GoldenFishShelterDecorator(Shelter shelter) {
        super(shelter);
    }

    @Override
    public void shelterOn(){
        bubbleMakerOn();
    }

    @Override
    public void shelterOff(){
        bubbleMakerOff();
    }

    public void bubbleMakerOn(){
        bubbleMakerIsWorking=true;
        log.info("The bubble maker was turned on");
    }

    public void bubbleMakerOff(){
        bubbleMakerIsWorking=false;
        log.info("The bubble maker was turned off");
    }
}
