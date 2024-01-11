package org.example.devices;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CoffeeMachine extends Device{

    private int capsulesAmount;

    public CoffeeMachine(Integer id, String documentation) {
        super(id, "CoffeeMachine", documentation);
        setAverageElectricityConsumption(3);
        setAverageWaterConsumption(1);
        setAverageGasConsumption(0);
    }

    @Override
    public String somethingToFix() {
        if (capsulesAmount < 2) return "Small reserves of capsules";
        return null;
    }

    @Override
    public void performDeviceAction() {
        capsulesAmount--;

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
