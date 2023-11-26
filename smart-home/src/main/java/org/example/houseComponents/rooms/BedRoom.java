package org.example.houseComponents.rooms;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BedRoom extends Room{

    public BedRoom(BedRoom target){
        super(target);
    }

    @Override
    public BedRoom clone() {
        return new BedRoom(this);
    }

    @Override
    public boolean equals(Object object2){
        return object2 instanceof BedRoom && super.equals(object2);
    }
}
