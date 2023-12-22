package org.example.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import netscape.javascript.JSObject;
import org.example.builders.HouseBuilder;
import org.example.devices.Device;
import org.example.devices.Grill;
import org.example.devices.WashingMachine;
import org.example.director.Director;
import org.example.factory.DeviceManager;
import org.example.factory.GrillManager;
import org.example.factory.WashingMachineManager;
import org.example.houseComponents.Floor;
import org.example.houseComponents.Garage;
import org.example.houseComponents.Pool;
import org.example.houseComponents.rooms.*;
import org.example.houses.*;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class ConfigBuilder {
    private static JSONObject object;

    public static House buildHouseFromJson(String jsonFileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(new File(jsonFileName));

        String type = node.get("type").asText();
//        List<Floor> floors = mapper.readValue(node.get("floors").toString(), new TypeReference<List<Floor>>(){});

        List<Floor> floors = parseFloors(node.get("floors"));

        Garage garage;
        Pool pool;
        House house;

        switch (type) {
            case "Simple":
                house = new SimpleHouse(floors);
                break;
            case "With Garage":
                garage = mapper.readValue(node.get("garage").toString(), Garage.class);
                house = new HouseWithGarage(floors, garage);
                break;
            case "With Pool":
                pool = mapper.readValue(node.get("pool").toString(), Pool.class);
                house = new HouseWithPool(floors, pool);
                break;
            case "With Garage and Pool":
                garage = mapper.readValue(node.get("garage").toString(), Garage.class);
                pool = mapper.readValue(node.get("pool").toString(), Pool.class);
                house = new HouseWithGarageAndPool(floors, garage, pool);
                break;
            default:
                throw new IllegalArgumentException("Unknown home type: " + type);
        }

        house.setFloors(floors);

        return house;
    }

    private static List<Floor> parseFloors(JsonNode floorsNode) throws IOException {
        List<Floor> floors = new ArrayList<>();

        for (JsonNode floorNode : floorsNode) {
            int level = floorNode.get("level").asInt();
            List<Room> rooms = parseRooms(floorNode.get("rooms"));
            floors.add(new Floor(level, rooms));
        }

        return floors;
    }

    private static List<Room> parseRooms(JsonNode roomsNode) throws IOException {
        List<Room> rooms = new ArrayList<>();

        for (JsonNode roomNode : roomsNode) {
            RoomType roomType = RoomType.valueOf(roomNode.get("type").asText());
            // Parse devices, doors, windows, lights if needed
            // ...

//            List<Device> devices = parseDevices(roomsNode.get("devices"));
            List<Device> devices = roomNode.has("devices") ? parseDevices(roomNode.get("devices")) : new ArrayList<>();
            switch (roomType) {
                case KITCHEN:
                    rooms.add(new Kitchen(devices));
                    break;
                case TOILET:
                    rooms.add(new Toilet(devices));
                    break;
                case BEDROOM:
                    rooms.add(new BedRoom(devices));
                    break;
                case BATHROOM:
                    rooms.add(new BathRoom(devices));
                    break;
                case GYM:
                    rooms.add(new Gym(devices));
                    break;
                case LIVING_ROOM:
                    rooms.add(new LivingRoom(devices));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown home type: " + roomType);
            }
        }

        return rooms;
    }

    private static List<Device> parseDevices(JsonNode devicesNode) throws IOException {
        List<Device> devices = new ArrayList<>();
        DeviceManager manager;

        for (JsonNode deviceNode : devicesNode) {
            Integer id = Integer.valueOf(String.valueOf(deviceNode.get("id")));
            String name = String.valueOf(deviceNode.get("name"));
            String documentation = String.valueOf(deviceNode.get("documentation"));

            switch (name){
                case "Grill":
                    manager = new GrillManager(id, name, documentation);
                    devices.add(manager.collectData());
                    break;
                case "WashingMachine":
                    manager = new WashingMachineManager(id, name, documentation);
                    devices.add(manager.collectData());
                    break;
                default:
                    throw new IllegalArgumentException("Unknown home type: " + deviceNode);
            }
        }

        return devices;
    }

}
