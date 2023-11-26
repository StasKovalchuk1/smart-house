package org.example.houseComponents;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.houseComponents.rooms.Room;

import java.util.List;

@Data
@NoArgsConstructor
public class Floor {

    private Integer id;

    private List<Room> rooms;
}
