package org.example.devices;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class WashingMachine extends Device{

    private int powderAmount = 6;

    public WashingMachine(Integer id, String documentation) {
        super(id, "WashingMachine", documentation);
        setAverageElectricityConsumption(5);
        setAverageWaterConsumption(3);
        setAverageGasConsumption(0);
    }

    @Override
    public String somethingToFix() {
        if (powderAmount < 2) return "Small reserves of laundry powder";
        return null;
    }

    @Override
    public void performDeviceAction() {
        powderAmount--;

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
