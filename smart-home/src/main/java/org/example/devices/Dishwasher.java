package org.example.devices;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Dishwasher extends Device{

    private int detergentAmount;

    public Dishwasher(Integer id, String documentation) {
        super(id, "Dishwasher", documentation);
        setAverageElectricityConsumption(5);
        setAverageWaterConsumption(3);
        setAverageGasConsumption(0);
    }

    @Override
    public String somethingToFix() {
        if (detergentAmount < 2) return "Small reserves of detergent";
        return null;
    }

    @Override
    public void performDeviceAction() {
        detergentAmount--;

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

    @Override
    public String toString(){
        return getName() + " [id = " + getId() + "]";
    }
}
