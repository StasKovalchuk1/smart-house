package org.example.devices;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.states.deviceStates.DeviceRunningState;

import java.util.ArrayList;
import java.util.List;

@Data
public class Fridge extends Device{

    private List<Food> foodInside = new ArrayList<>();

    public Fridge(Integer id, String documentation) {
        super(id, "Fridge", documentation);
        setAverageElectricityConsumption(5);
        setAverageWaterConsumption(0);
        setAverageGasConsumption(0);
        setState(new DeviceRunningState(this));
    }

    @Override
    public String somethingToFix() {
        if (foodInside.size() < 10) return "Not enough food";
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

    public void removeFoodFromFridge(Food food) {
        foodInside.remove(food);
    }

    @Override
    public String toString(){
        return getName() + " [id = " + getId() + "]";
    }
}
