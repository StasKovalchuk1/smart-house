package org.example.devices;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Fridge extends Device{

    private List<Food> foodInside;

    @Override
    public String somethingToFix() {
        if (foodInside.size() < 10) return "Not enough food";
        return null;
    }
}
