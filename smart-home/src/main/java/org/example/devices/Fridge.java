package org.example.devices;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class Fridge extends Device{

    private List<Food> foodInside = new ArrayList<>();

    public Fridge(Integer id, String name, String documentation) {
        super(id, name, documentation);
    }

    @Override
    public String somethingToFix() {
        if (foodInside.size() < 10) return "Not enough food";
        return null;
    }

    @Override
    public void performDeviceAction() {
        System.out.println("Fridge was used");
    }

    public void removeFoodFromFridge(Food food) {
        foodInside.remove(food);
    }
}
