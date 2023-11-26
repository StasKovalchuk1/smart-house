package org.example.houseComponents.rooms;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Kitchen extends Room{

    public Kitchen(Kitchen target){
        super(target);
    }

    @Override
    public Kitchen clone() {
        return new Kitchen(this);
    }

    @Override
    public boolean equals(Object object2){
        return object2 instanceof Kitchen && super.equals(object2);
    }
}
