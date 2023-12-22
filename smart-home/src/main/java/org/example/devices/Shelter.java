package org.example.devices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.decorators.ShelterInterface;

@Data
public class Shelter extends Device implements ShelterInterface {

    private int waterAmount;
    private int foodAmount;
    private boolean heaterIsWorking;

    public Shelter(Integer id, String name, String documentation) {
        super(id, name, documentation);
    }

    @Override
    public void shelterOn(){
        heaterIsWorking = true;
    }

    @Override
    public void shelterOff(){
        heaterIsWorking = false;
    }

    // TODO
    @Override
    public String somethingToFix() {
        return null;
    }

    @Override
    public void performDeviceAction() {
        shelterOn();
    }
}
