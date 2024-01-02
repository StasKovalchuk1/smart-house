package org.example.houseComponents.rooms;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.devices.Device;

import java.util.List;

@Data
public class Kitchen extends Room{

    public Kitchen(Kitchen target){
        super(target);
        setType(RoomType.KITCHEN);
    }

    //TODO добавить doors, windows, lights
    public Kitchen(List<Device> devices) {
        super(devices, RoomType.KITCHEN);
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
