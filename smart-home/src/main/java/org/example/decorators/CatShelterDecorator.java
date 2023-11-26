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
public class CatShelterDecorator extends BaseShelterDecorator {

    private boolean brushIsWorking = false;

    public CatShelterDecorator(Shelter shelter) {
        super(shelter);
    }

    @Override
    public void shelterOn(){
        brushOn();
    }

    @Override
    public void shelterOff(){
        brushOff();
    }

    public void brushOn(){
        brushIsWorking = true;
        log.info("The brush was turned on");
    }
    public void brushOff(){
        brushIsWorking = false;
        log.info("The brush was turned off");
    }
}
