package org.example.houseComponents.vehicle;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Ski implements Vehicle{

    private Integer id;

    @Override
    public String toString() {
        return "Ski";
    }
    @Override
    public void ride() {
        System.out.println("Ski is skiing");
    }
}
