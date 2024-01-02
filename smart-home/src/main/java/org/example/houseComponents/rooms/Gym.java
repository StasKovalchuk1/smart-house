package org.example.houseComponents.rooms;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.devices.Device;

import java.util.List;

@Data
public class Gym extends Room{

    public Gym(Gym target){
        super(target);
        setType(RoomType.GYM);
    }

    //TODO добавить doors, windows, lights
    public Gym(List<Device> devices) {
        super(devices, RoomType.GYM);
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
