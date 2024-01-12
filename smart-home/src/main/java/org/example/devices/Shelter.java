package org.example.devices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.decorators.ShelterInterface;

@Data
public class Shelter extends Device implements ShelterInterface {

    private int waterAmount = 20;
    private int foodAmount = 10;
    private boolean heaterIsWorking;
    private ShelterType type;

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
        if (waterAmount < 5 || foodAmount < 3) return "Check food and water in shelter" + "[" + getId() + "]";
        return null;
    }

    @Override
    public void performDeviceAction() {
        shelterOn();

        double percentChange = (Math.random() - 0.5) * 0.2;
        setCurrentElectricityConsumption(getAverageElectricityConsumption() * (1 + percentChange));
        setCurrentWaterConsumption(getAverageWaterConsumption() * (1 + percentChange));
        setTotalElectricityConsumption(getTotalElectricityConsumption()+getCurrentElectricityConsumption());
        setTotalWaterConsumption(getTotalWaterConsumption()+getCurrentWaterConsumption());

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

    @Override
    public String toString(){
        return getName() + " [id = " + getId() + "]";
    }
}
