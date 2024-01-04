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

    public Shelter(Integer id, String documentation) {
        super(id, "Shelter", documentation);
        setAverageElectricityConsumption(3);
        setAverageWaterConsumption(2);
        setAverageGasConsumption(0);
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

        double percentChange = (Math.random() - 0.5) * 0.2;
        setCurrentElectricityConsumption(getAverageElectricityConsumption() * (1 + percentChange));
        setCurrentWaterConsumption(getAverageWaterConsumption() * (1 + percentChange));

        getController().increaseTotalElectricityConsumption(getCurrentElectricityConsumption());
        getController().increaseTotalWaterConsumption(getCurrentWaterConsumption());
    }

    @Override
    public void stopDeviceAction() {
        getController().decreaseTotalElectricityConsumption(getCurrentElectricityConsumption());
        getController().decreaseTotalWaterConsumption(getCurrentWaterConsumption());

        setCurrentElectricityConsumption(0);
        setCurrentWaterConsumption(0);
    }
}
