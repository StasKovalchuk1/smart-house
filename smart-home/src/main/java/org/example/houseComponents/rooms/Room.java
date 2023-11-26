package org.example.houseComponents.rooms;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.devices.Device;
import org.example.houseComponents.rooms.roomComponents.Door;
import org.example.houseComponents.rooms.roomComponents.Light;
import org.example.houseComponents.rooms.roomComponents.Window;

import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
public abstract class Room {

    private Integer id;

    private List<Device> devices;
    private List<Door> doors;
    private List<Window> windows;
    private List<Light> lights;

    public Room(Room target){
        if (target!=null){
            this.devices = target.devices;
            this.doors = target.doors;
            this.windows = target.windows;
            this.lights = target.lights;
        }
    }

    public abstract Room clone();

    @Override
    public boolean equals(Object object2){
        if (!(object2 instanceof Room room2)) return false;
        return Objects.equals(room2.devices, this.devices);
    }
}
