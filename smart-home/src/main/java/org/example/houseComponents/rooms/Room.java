package org.example.houseComponents.rooms;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.devices.Device;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
public abstract class Room {

    private RoomType type;
    private Integer id;
    private List<Device> devices = new ArrayList<>();


    public Room(Room target){
        if (target!=null){
            this.id = target.id;
            this.devices = target.devices;
            this.type = target.type;
        }
    }

    public Room(List<Device> devices, RoomType type){
        setDevices(devices);
        this.type = type;
    }

    public abstract Room clone();

    @Override
    public boolean equals(Object object2){
        if (!(object2 instanceof Room room2)) return false;
        return Objects.equals(room2.devices, this.devices);
    }

    @Override
    public String toString() {
        return "Room(type=" + type +
                ", devices=" + devices;
    }
}
