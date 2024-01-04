package org.example.devices;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class WashingMachine extends Device{

    private int powderAmount;

    public WashingMachine(Integer id, String documentation) {
        super(id, "WashingMachine", documentation);
        setAverageElectricityConsumption(5);
        setAverageWaterConsumption(3);
        setAverageGasConsumption(0);
    }

    @Override
    public String somethingToFix() {
        if (powderAmount < 5) return "Small reserves of laundry powder";
        return null;
    }

    @Override
    public void performDeviceAction() {
        powderAmount--;

        double percentChange = (Math.random() - 0.5) * 0.2;
        setCurrentElectricityConsumption(getAverageElectricityConsumption() * (1 + percentChange));
        setCurrentWaterConsumption(getAverageWaterConsumption() * (1 + percentChange));

        getController().increaseTotalElectricityConsumption(getCurrentElectricityConsumption());
        getController().increaseTotalWaterConsumption(getCurrentWaterConsumption());

        System.out.println("Washing machine has washed clothes");
    }

    @Override
    public void stopDeviceAction() {
        getController().decreaseTotalElectricityConsumption(getCurrentElectricityConsumption());
        getController().decreaseTotalWaterConsumption(getCurrentWaterConsumption());

        setCurrentElectricityConsumption(0);
        setCurrentWaterConsumption(0);
    }
}
