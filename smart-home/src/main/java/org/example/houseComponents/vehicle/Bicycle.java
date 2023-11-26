package org.example.houseComponents.vehicle;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Bicycle implements Vehicle{

    private Integer id;

    @Override
    public String toString() {
        return "icycle";
    }
    @Override
    public void ride() {
        System.out.println("Bicycle is riding");
    }
}
