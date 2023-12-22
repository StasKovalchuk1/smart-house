package org.example.houseComponents;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.houseComponents.rooms.Room;

import java.util.ArrayList;
import java.util.List;

@Data
//@NoArgsConstructor
public class Floor {

    private final int level;

    private List<Room> rooms;

    public Floor(int level, List<Room> rooms) {
        this.level = level;
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        if (rooms.isEmpty()) rooms = new ArrayList<>();
        rooms.add(room);
    }
}
