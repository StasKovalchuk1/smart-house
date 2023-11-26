package org.example.houseComponents.rooms;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BathRoom extends Room{

    public BathRoom(BathRoom target){
        super(target);
    }

    @Override
    public Room clone() {
        return new BathRoom(this);
    }

    @Override
    public boolean equals(Object object2){
        return object2 instanceof BathRoom && super.equals(object2);
    }
}
