package org.example.houseComponents.rooms;

import lombok.Data;
import org.example.devices.Device;

import java.util.List;

@Data
public class BathRoom extends Room {

    public BathRoom(BathRoom target){
        super(target);
        setType(RoomType.BATHROOM);
    }

    //TODO добавить doors, windows, lights
    public BathRoom(List<Device> devices) {
        super(devices, RoomType.BATHROOM);
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
