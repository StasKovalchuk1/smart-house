package org.example.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import netscape.javascript.JSObject;
import org.example.builders.HouseBuilder;
import org.example.devices.Device;
import org.example.devices.DeviceController;
import org.example.devices.Grill;
import org.example.devices.WashingMachine;
import org.example.director.Director;
import org.example.factory.*;
import org.example.houseComponents.Floor;
import org.example.houseComponents.Garage;
import org.example.houseComponents.Pool;
import org.example.houseComponents.rooms.*;
import org.example.houseResidents.people.*;
import org.example.houses.*;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
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
            case "Simple" -> house = new SimpleHouse(floors);
            case "With Garage" -> {
                garage = mapper.readValue(node.get("garage").toString(), Garage.class);
                house = new HouseWithGarage(floors, garage);
            }
            case "With Pool" -> {
                pool = mapper.readValue(node.get("pool").toString(), Pool.class);
                house = new HouseWithPool(floors, pool);
            }
            case "With Garage and Pool" -> {
                garage = mapper.readValue(node.get("garage").toString(), Garage.class);
                pool = mapper.readValue(node.get("pool").toString(), Pool.class);
                house = new HouseWithGarageAndPool(floors, garage, pool);
            }
            default -> throw new IllegalArgumentException("Unknown home type: " + type);
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
            JsonNode devicesNode = roomNode.get("devices");
            List<Device> devices = (devicesNode != null) ? parseDevices(devicesNode) : Collections.emptyList();

            switch (roomType) {
                case KITCHEN -> rooms.add(new Kitchen(devices));
                case TOILET -> rooms.add(new Toilet(devices));
                case BEDROOM -> rooms.add(new BedRoom(devices));
                case BATHROOM -> rooms.add(new BathRoom(devices));
                case GYM -> rooms.add(new Gym(devices));
                case LIVING_ROOM -> rooms.add(new LivingRoom(devices));
                default -> throw new IllegalArgumentException("Unknown room type: " + roomType);
            }
        }

        return rooms;
    }

    private static List<Device> parseDevices(JsonNode devicesNode) throws IOException {
        List<Device> devices = new ArrayList<>();
        DeviceManager manager;

        for (JsonNode deviceNode : devicesNode) {
            Integer id = deviceNode.get("id").asInt();
            String name = deviceNode.get("name").asText();
            String documentation = deviceNode.get("documentation").asText();

            switch (name) {
                case "Grill" -> {
                    manager = new GrillManager(id, name, documentation);
                    devices.add(manager.collectData());
                }
                case "WashingMachine" -> {
                    manager = new WashingMachineManager(id, name, documentation);
                    devices.add(manager.collectData());
                }
                case "CoffeeMachine" -> {
                    manager = new CoffeeMachineManager(id, name, documentation);
                    devices.add(manager.collectData());
                }
                case "Computer" -> {
                    manager = new ComputerManager(id, name, documentation);
                    devices.add(manager.collectData());
                }
                case "Dishwasher" -> {
                    manager = new DishwasherManager(id, name, documentation);
                    devices.add(manager.collectData());
                }
                case "Fridge" -> {
                    manager = new FridgeManager(id, name, documentation);
                    devices.add(manager.collectData());
                }
                case "Microwave" -> {
                    manager = new MicrowaveManager(id, name, documentation);
                    devices.add(manager.collectData());
                }
                case "Oven" -> {
                    manager = new OvenManager(id, name, documentation);
                    devices.add(manager.collectData());
                }
                case "Shelter" -> {
                    manager = new ShelterManager(id, name, documentation);
                    devices.add(manager.collectData());
                }
                default -> throw new IllegalArgumentException("Unknown device: " + name);
            }
        }

        return devices;
    }

    public static List<Person> getPeopleFromJson(String jsonFileName, DeviceController controller, House house) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(new File(jsonFileName));

        List<Person> people = new ArrayList<>();
        Father father = null;
        Mother mother = null;
        Child child = null;

        for (JsonNode personNode : node.get("people")) {
            PersonType type = PersonType.valueOf(personNode.get("type").asText());
            String name = personNode.get("name").asText();
            boolean atHome = personNode.get("atHome").asBoolean();

            switch (type) {
                case FATHER -> {
                    father = new Father(controller, house, name);
                    father.setAtHome(atHome);
                    people.add(father);
                }
                case MOTHER -> {
                    mother = new Mother(controller, house, name);
                    mother.setAtHome(atHome);
                    people.add(mother);
                }
                case CHILD -> {
                    if (father != null && mother != null) {
                        child = new Child(controller, house, name, mother, father);
                        child.setAtHome(atHome);
                        people.add(child);
                    } else {
                        log.warn("Couldn't read child because parents are not initialized");
                    }
                }
                default -> throw new IllegalArgumentException("Unknown person: " + name);
            }
        }

        return people;
    }

}
