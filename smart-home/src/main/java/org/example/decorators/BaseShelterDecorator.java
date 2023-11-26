package org.example.decorators;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.devices.Shelter;


@Slf4j
@Data
@NoArgsConstructor
public abstract class BaseShelterDecorator implements Shelter{

    private Integer id;
    private Shelter wrapper;
    private int waterAmount;
    private int foodAmount;
    private boolean isHeaterWorking = false;

    public BaseShelterDecorator(Shelter shelter) {
        this.wrapper = shelter;
    }

    @Override
    public void shelterOn(){
        wrapper.shelterOn();
        log.info("The shelter was turned on");
    }

    @Override
    public void shelterOff(){
        wrapper.shelterOff();
        log.info("The shelter was turned off");
    }
}
