package org.example.devices;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Grill extends Device{
    private int coalAmount;

    public Grill(Integer id, String documentation) {
        super(id, "Grill", documentation);
        setAverageElectricityConsumption(5);
        setAverageWaterConsumption(0);
        setAverageGasConsumption(0);
    }

    @Override
    public String somethingToFix() {
        if (coalAmount < 2) return "Small reserves of coal";
        return null;
    }

    @Override
    public void performDeviceAction() {
        coalAmount--;

        double percentChange = (Math.random() - 0.5) * 0.2;
        setCurrentElectricityConsumption(getAverageElectricityConsumption() * (1 + percentChange));
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
