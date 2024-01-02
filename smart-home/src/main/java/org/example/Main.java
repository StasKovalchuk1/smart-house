package org.example;

import org.example.builders.HouseBuilder;
import org.example.builders.HouseWithGarageAndPoolBuilder;
import org.example.builders.SimpleHouseBuilder;
import org.example.config.ConfigBuilder;
import org.example.devices.Device;
import org.example.devices.DeviceController;
import org.example.devices.Fridge;
import org.example.devices.Grill;
import org.example.factory.DeviceManager;
import org.example.factory.FridgeManager;
import org.example.generators.events.EventGeneratorForAutomaticHandling;
import org.example.generators.events.EventGeneratorForHandlingByPerson;
import org.example.houseComponents.Floor;
import org.example.houseComponents.rooms.BedRoom;
import org.example.houseComponents.rooms.Gym;
import org.example.houseComponents.rooms.Kitchen;
import org.example.houseComponents.rooms.Room;
import org.example.houseComponents.vehicle.Car;
import org.example.director.Director;
import org.example.houseResidents.people.Child;
import org.example.houseResidents.people.Father;
import org.example.houseResidents.people.Mother;
import org.example.houseResidents.people.Person;
import org.example.houseResidents.pets.Cat;
import org.example.houseResidents.pets.Dog;
import org.example.houseResidents.pets.GoldenFish;
import org.example.houseResidents.pets.Pet;
import org.example.houses.House;
import org.example.houses.HouseWithGarage;
import org.example.houses.HouseWithGarageAndPool;
import org.example.reports.reportGenerators.HouseConfigurationReportGenerator;

import java.awt.datatransfer.FlavorListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        SimpleHouseBuilder builder = new SimpleHouseBuilder();
        List<Floor> floors = new ArrayList<>();

        List<Device> devices = new ArrayList<>();
        devices.add(new Grill(1,null));
        devices.add(new Fridge(2, null));

        Room kitchen = new Kitchen(devices);
        Room gym = new Gym(devices);
        Room bedRoom = new BedRoom(devices);
        List<Room> rooms = new ArrayList<>();
        rooms.add(kitchen);
        rooms.add(gym);
        rooms.add(bedRoom);
        Floor floor1 = new Floor(1, rooms);
        Floor floor2 = new Floor(2, rooms);
        Floor floor3 = new Floor(3, rooms);
        floors.add(floor1);
        floors.add(floor2);
        floors.add(floor3);

        director.constructSimpleHouse(builder, floors);
        House simpleHouse = builder.getResult();

        Person mother = new Mother(new DeviceController(), simpleHouse);
        mother.setName("Liza");
        Person father = new Father(new DeviceController(), simpleHouse);
        father.setName("Oleg");
        Person son = new Child(new DeviceController(), simpleHouse);
        son.setName("Vova");
        simpleHouse.addResident(mother);
        simpleHouse.addResident(father);
        simpleHouse.addResident(son);

        Pet dog = new Dog();
        dog.setName("Bobik");
        Pet cat = new Cat();
        cat.setName("Barsik");
        Pet fish = new GoldenFish();
        fish.setName("Nemo");
        simpleHouse.addPet(dog);
        simpleHouse.addPet(cat);
        simpleHouse.addPet(fish);

        HouseConfigurationReportGenerator houseConfGen = new HouseConfigurationReportGenerator(simpleHouse);
        houseConfGen.generateReport();


//        try {
//            House house = ConfigBuilder.buildHouseFromJson("config/config1.json");
//            System.out.println(house.toString());
//            System.out.println(house.getFloors().get(1));
//
//            System.out.println(house.getFloors().get(1).getRooms().get(0).getDevices());
//
//            System.out.println(house.getFloors().get(1).getRooms().get(1).getDevices());
//
//            List<Device> devices = house.getFloors().stream()
//                    .flatMap(floor -> floor.getRooms().stream())
//                    .flatMap(room -> room.getDevices().stream())
//                    .toList();
//
//            DeviceController controller = new DeviceController(devices);
//
//            List<Person> people = ConfigBuilder.getPeopleFromJson("config/config1.json", controller, house);
//            System.out.println(people);
//            System.out.println("-------------------");
//
//            EventGeneratorForAutomaticHandling automaticHandling = new EventGeneratorForAutomaticHandling(controller);
//            EventGeneratorForHandlingByPerson personHandling = new EventGeneratorForHandlingByPerson(people, controller);
//            automaticHandling.generateEvent();
//            System.out.println("-------------------");
//            personHandling.generateEvent();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}