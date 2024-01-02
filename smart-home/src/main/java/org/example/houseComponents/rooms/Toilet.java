package org.example.houseComponents.rooms;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.devices.Device;

import java.util.List;
import java.util.Objects;

@Data
public class Toilet extends Room{

    public Toilet(Toilet target){
        super(target);
        setType(RoomType.TOILET);
    }

    //TODO добавить doors, windows, lights
    public Toilet(List<Device> devices) {
        super(devices, RoomType.TOILET);
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
