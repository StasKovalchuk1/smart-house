package org.example.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.builders.*;
import org.example.devices.Device;
import org.example.devices.DeviceController;
import org.example.factory.*;
import org.example.houseComponents.Floor;
import org.example.houseComponents.Garage;
import org.example.houseComponents.Pool;
import org.example.houseComponents.rooms.*;
import org.example.houseComponents.vehicle.Bicycle;
import org.example.houseComponents.vehicle.Car;
import org.example.houseComponents.vehicle.Ski;
import org.example.houseComponents.vehicle.Vehicle;
import org.example.houseResidents.HouseResident;
import org.example.houseResidents.people.*;
import org.example.houseResidents.pets.*;
import org.example.houses.*;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class ConfigBuilder {

    private static JSONObject object;
    private static DeviceController deviceController;

    public static House buildHouseFromJson(String jsonFileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(new File(jsonFileName));

        String type = node.get("type").asText();
        List<Floor> floors = parseFloors(node.get("floors"));
        House house;

        //Builders
        SimpleHouseBuilder simpleHouseBuilder = new SimpleHouseBuilder();
        HouseWithPoolBuilder houseWithPoolBuilder = new HouseWithPoolBuilder();
        HouseWithGarageBuilder houseWithGarageBuilder = new HouseWithGarageBuilder();
        HouseWithGarageAndPoolBuilder houseWithGarageAndPoolBuilder = new HouseWithGarageAndPoolBuilder();

        Director director = new Director();

        switch (type) {
            case "Simple" -> {
                director.constructSimpleHouse(simpleHouseBuilder, floors);
                house = simpleHouseBuilder.getResult();
            }
            case "With Garage" -> {
                JsonNode garageNode = node.get("garage");
                director.constructHouseWithGarage(houseWithGarageBuilder, floors, parseVehicles(garageNode));
                house = houseWithGarageBuilder.getResult();
            }
            case "With Pool" -> {
                director.constructHouseWithPool(houseWithPoolBuilder, floors);
                house = houseWithPoolBuilder.getResult();
            }
            case "With Garage and Pool" -> {
                JsonNode garageNode = node.get("garage");
                director.constructHouseWithGarageAndPool(houseWithGarageAndPoolBuilder, floors, parseVehicles(garageNode));
                house = houseWithGarageAndPoolBuilder.getResult();
            }
            default -> throw new IllegalArgumentException("Unknown home type: " + type);
        }
        house.setPeople(parsePeople(jsonFileName, deviceController, house));
        house.setPets(parsePets(jsonFileName, deviceController, house));
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
            String type = roomNode.get("type").asText();
            Integer roomId = roomNode.get("id").asInt();
            JsonNode devicesNode = roomNode.get("devices");
            List<Device> devices = (devicesNode != null) ? parseDevices(devicesNode) : Collections.emptyList();
            deviceController = new DeviceController(devices);

            switch (type) {
                case "KITCHEN" -> {
                    Kitchen kitchen = new Kitchen(devices);
                    kitchen.setId(roomId);
                    rooms.add(kitchen);
                }
                case "TOILET" -> {
                    Toilet toilet = new Toilet(devices);
                    toilet.setId(roomId);
                    rooms.add(toilet);
                }
                case "BEDROOM" -> {
                    BedRoom bedRoom = new BedRoom(devices);
                    bedRoom.setId(roomId);
                    rooms.add(bedRoom);
                }
                case "BATHROOM" -> {
                    BathRoom bathRoom = new BathRoom(devices);
                    bathRoom.setId(roomId);
                    rooms.add(bathRoom);
                }
                case "GYM" -> {
                    Gym gym = new Gym(devices);
                    gym.setId(roomId);
                    rooms.add(gym);
                }
                case "LIVING_ROOM" -> {
                    LivingRoom livingRoom = new LivingRoom(devices);
                    livingRoom.setId(roomId);
                    rooms.add(livingRoom);
                }
                default -> throw new IllegalArgumentException("Unknown room type: " + type);
            }
        }

        return rooms;
    }

    private static List<Device> parseDevices(JsonNode devicesNode) {
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

    public static List<HouseResident> parsePeople(String jsonFileName, DeviceController controller, House house) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(new File(jsonFileName));

        List<HouseResident> people = new ArrayList<>();
        Father father = null;
        Mother mother = null;
        Child child = null;

        for (JsonNode personNode : node.get("people")) {
            String type = personNode.get("type").asText();
            String name = personNode.get("name").asText();
            boolean atHome = personNode.get("atHome").asBoolean();

            switch (type) {
                case "FATHER" -> {
                    father = new Father(controller, house, name);
                    father.setAtHome(atHome);
                    people.add(father);
                }
                case "MOTHER" -> {
                    mother = new Mother(controller, house, name);
                    mother.setAtHome(atHome);
                    people.add(mother);
                }
                case "CHILD" -> {
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

    public static List<HouseResident> parsePets(String jsonFileName, DeviceController deviceController, House house) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(new File(jsonFileName));

        List<HouseResident> pets = new ArrayList<>();
        Cat cat = null;
        Dog dog = null;
        GoldenFish fish = null;

        for (JsonNode petNode : node.get("pets")) {
            String type = petNode.get("type").asText();
            String name = petNode.get("name").asText();
            boolean isInShelter = petNode.get("isInShelter").asBoolean();

            switch (type) {
                case "DOG" -> {
                    dog = new Dog(deviceController, name, house);
                    dog.setInShelter(isInShelter);
                    pets.add(dog);
                }
                case "CAT" -> {
                    cat = new Cat(deviceController, name, house);
                    cat.setInShelter(isInShelter);
                    pets.add(cat);
                }
                case "GOLDENFISH" -> {
                    fish = new GoldenFish(deviceController, name, house);
                    fish.setInShelter(isInShelter);
                    pets.add(fish);
                }
                default -> throw new IllegalArgumentException("Unknown pet: " + name);
            }
        }
        return pets;
    }

    public static List<Vehicle> parseVehicles(JsonNode garageNode){
        List<Vehicle> vehicles = new ArrayList<>();

        for (JsonNode vehicleNode : garageNode.get("vehicles")) {
            String type = vehicleNode.get("type").asText();
            switch (type) {
                case "SKI" -> vehicles.add(new Ski());
                case "CAR" -> vehicles.add(new Car());
                case "BICYCLE" -> vehicles.add(new Bicycle());
                default -> throw new IllegalArgumentException("Unknown vehicle: " + type);
            }
        }
        return vehicles;
    }
}
