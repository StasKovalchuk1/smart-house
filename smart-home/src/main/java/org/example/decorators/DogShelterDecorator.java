package org.example.decorators;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.devices.Shelter;


@Slf4j
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DogShelterDecorator extends BaseShelterDecorator {

    private boolean lightsAreWorking = false;

    public DogShelterDecorator(Shelter shelter) {
        super(shelter);
    }

    public void shelterOn(){
        super.shelterOn();
        lightsOn();
    }

    public void shelterOff(){
        super.shelterOff();
        lightsOff();
    }

    public void lightsOn(){
        lightsAreWorking = true;
        log.info("Lights were turned on");
    }

    public void lightsOff(){
        lightsAreWorking = false;
        log.info("Lights were turned off");
    }
}
