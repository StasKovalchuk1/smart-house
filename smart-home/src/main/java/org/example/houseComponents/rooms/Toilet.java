package org.example.houseComponents.rooms;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class Toilet extends Room{


    public Toilet(Toilet target){
        super(target);
    }

    @Override
    public Room clone() {
        return new Toilet(this);
    }

    @Override
    public boolean equals(Object object2){
        return object2 instanceof Toilet && super.equals(object2);
    }
}
