package org.example.devices;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Computer extends Device{
    public Computer(Integer id, String documentation) {
        super(id, "Computer", documentation);
        setAverageElectricityConsumption(3);
        setAverageWaterConsumption(0);
        setAverageGasConsumption(0);
    }

    @Override
    public String somethingToFix() {
        return null;
    }

    @Override
    public void performDeviceAction() {
        double percentChange = (Math.random() - 0.5) * 0.2;
        setCurrentElectricityConsumption(getAverageElectricityConsumption() * (1 + percentChange));
        setTotalElectricityConsumption(getTotalElectricityConsumption()+getCurrentElectricityConsumption());

        getController().increaseTotalElectricityConsumption(getCurrentElectricityConsumption());
    }

    @Override
    public void stopDeviceAction() {
        getController().decreaseTotalElectricityConsumption(getCurrentElectricityConsumption());
        setCurrentElectricityConsumption(0);
    }

    @Override
    public String toString(){
        return getName() + " [id = " + getId() + "]";
    }
}
