package org.example.houseComponents.vehicle;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Car implements Vehicle{

    private Integer id;

    @Override
    public String toString() {
        return "Car";
    }

    @Override
    public void ride() {
        System.out.println("Car is riding");
    }
}
