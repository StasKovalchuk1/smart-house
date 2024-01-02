package org.example.houseComponents.rooms;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.devices.Device;

import java.util.List;

@Data
public class BedRoom extends Room{

    public BedRoom(BedRoom target){
        super(target);
        setType(RoomType.BEDROOM);
    }

    //TODO добавить doors, windows, lights
    public BedRoom(List<Device> devices) {
        super(devices, RoomType.BEDROOM);
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
