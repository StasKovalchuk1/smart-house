package org.example.houseComponents.rooms;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.devices.Device;

import java.util.List;

@Data
public class LivingRoom extends Room{

    public LivingRoom(LivingRoom target){
        super(target);
        setType(RoomType.LIVING_ROOM);
    }

    //TODO добавить doors, windows, lights
    public LivingRoom(List<Device> devices) {
        super(devices);
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
