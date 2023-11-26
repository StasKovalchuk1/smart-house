package org.example.houseComponents.rooms;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Gym extends Room{

    public Gym(Gym target){
        super(target);
    }

    @Override
    public Gym clone() {
        return new Gym(this);
    }

    @Override
    public boolean equals(Object object2){
        return object2 instanceof Gym && super.equals(object2);
    }
}
