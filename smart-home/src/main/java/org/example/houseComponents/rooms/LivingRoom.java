package org.example.houseComponents.rooms;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LivingRoom extends Room{

    public LivingRoom(LivingRoom target){
        super(target);
    }

    @Override
    public LivingRoom clone() {
        return new LivingRoom(this);
    }

    @Override
    public boolean equals(Object object2){
        return object2 instanceof LivingRoom && super.equals(object2);
    }
}
