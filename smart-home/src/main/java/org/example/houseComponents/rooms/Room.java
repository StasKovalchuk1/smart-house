package org.example.houseComponents.rooms;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.devices.Device;

import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
public abstract class Room {

    private List<Device> devices;

    public Room(Room target){
        if (target!=null){
            this.devices = target.devices;
        }
    }

    public abstract Room clone();

    @Override
    public boolean equals(Object object2){
        if (!(object2 instanceof Room room2)) return false;
        return Objects.equals(room2.devices, this.devices);
    }
}
