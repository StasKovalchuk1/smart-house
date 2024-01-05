package org.example.devices;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Oven extends Device{

    private int timer;
    private int temperature;

    public Oven(Integer id, String documentation) {
        super(id, "Oven", documentation);
        setAverageElectricityConsumption(3);
        setAverageWaterConsumption(0);
        setAverageGasConsumption(5);
    }

    @Override
    public String somethingToFix() {
        return null;
    }

    @Override
    public void performDeviceAction() {
        double percentChange = (Math.random() - 0.5) * 0.2;
        setCurrentElectricityConsumption(getAverageElectricityConsumption() * (1 + percentChange));
        setCurrentGasConsumption(getAverageGasConsumption() * (1 + percentChange));

        getController().increaseTotalElectricityConsumption(getCurrentElectricityConsumption());
        getController().increaseTotalGasConsumption(getCurrentGasConsumption());
    }

    @Override
    public void stopDeviceAction() {
        getController().decreaseTotalElectricityConsumption(getCurrentElectricityConsumption());
        getController().decreaseTotalGasConsumption(getCurrentGasConsumption());

        setCurrentElectricityConsumption(0);
        setCurrentGasConsumption(0);
    }
}
