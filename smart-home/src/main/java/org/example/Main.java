package org.example;

import org.example.builders.SimpleHouseBuilder;
import org.example.config.ConfigBuilder;
import org.example.devices.Device;
import org.example.devices.DeviceController;
import org.example.devices.Fridge;
import org.example.devices.Grill;
import org.example.generators.activities.personActivities.PersonActivityGenerator;
import org.example.generators.events.EventGeneratorForAutomaticHandling;
import org.example.generators.events.EventGeneratorForHandlingByPerson;
import org.example.houseComponents.Floor;
import org.example.houseComponents.rooms.BedRoom;
import org.example.houseComponents.rooms.Gym;
import org.example.houseComponents.rooms.Kitchen;
import org.example.houseComponents.rooms.Room;
import org.example.director.Director;
import org.example.houseResidents.HouseResident;
import org.example.houseResidents.people.Child;
import org.example.houseResidents.people.Father;
import org.example.houseResidents.people.Mother;
import org.example.houseResidents.people.Person;
import org.example.houseResidents.pets.Cat;
import org.example.houseResidents.pets.Dog;
import org.example.houseResidents.pets.GoldenFish;
import org.example.houseResidents.pets.Pet;
import org.example.houses.House;
import org.example.reports.reportGenerators.ActivityAndUsageReportGenerator;
import org.example.reports.reportGenerators.EventReportGenerator;
import org.example.reports.reportGenerators.HouseConfigurationReportGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Director director = new Director();
//        SimpleHouseBuilder builder = new SimpleHouseBuilder();
//        List<Floor> floors = new ArrayList<>();
//
//        List<Device> devices = new ArrayList<>();
//        devices.add(new Grill(1,null));
//        devices.add(new Fridge(2, null));
//
//        Room kitchen = new Kitchen(devices);
//        Room gym = new Gym(devices);
//        Room bedRoom = new BedRoom(devices);
//        List<Room> rooms = new ArrayList<>();
//        rooms.add(kitchen);
//        rooms.add(gym);
//        rooms.add(bedRoom);
//        Floor floor1 = new Floor(1, rooms);
//        Floor floor2 = new Floor(2, rooms);
//        Floor floor3 = new Floor(3, rooms);
//        floors.add(floor1);
//        floors.add(floor2);
//        floors.add(floor3);
//
//        director.constructSimpleHouse(builder, floors);
//        House simpleHouse = builder.getResult();
//
//
//        DeviceController deviceController = new DeviceController();
//        deviceController.setDevices(devices);
//        Mother mother = new Mother(deviceController, simpleHouse, "Irena");
//        Father father = new Father(deviceController, simpleHouse, "Oleg");
//        Child son = new Child(deviceController, simpleHouse, "Daniil", mother, father);
//        List<HouseResident> residents = new ArrayList<>();
//
//        PersonActivityGenerator personActivityGenerator = new PersonActivityGenerator();
//        personActivityGenerator.setPeople(residents);
//
//        residents.add(mother);
//        residents.add(father);
//        residents.add(son);
//        simpleHouse.setPeople(residents);
//        Pet dog = new Dog(deviceController, "Bobik");
//        Pet cat = new Cat(deviceController, "Barsik");
//        Pet fish = new GoldenFish(deviceController, "Nemo");
//        simpleHouse.addPet(dog);
//        simpleHouse.addPet(cat);
//        simpleHouse.addPet(fish);
//
//        ActivityAndUsageReportGenerator activityAndUsageReportGenerator = new ActivityAndUsageReportGenerator(simpleHouse);
//        mother.setActivityAndUsageReportGenerator(activityAndUsageReportGenerator);
//        father.setActivityAndUsageReportGenerator(activityAndUsageReportGenerator);
//        son.setActivityAndUsageReportGenerator(activityAndUsageReportGenerator);

//        personActivityGenerator.setActivityAndUsageReportGenerator(activityAndUsageReportGenerator);
//        try {
//            personActivityGenerator.generateActivity();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        activityAndUsageReportGenerator.generateReport();






//        HouseConfigurationReportGenerator houseConfGen = new HouseConfigurationReportGenerator(simpleHouse);
//        houseConfGen.generateReport();

//        EventReportGenerator eventReportGenerator = new EventReportGenerator();
//        EventGeneratorForHandlingByPerson eventGeneratorForHandlingByPerson
//                = new EventGeneratorForHandlingByPerson(residents, deviceController, eventReportGenerator);
//        EventGeneratorForAutomaticHandling eventGeneratorForAutomaticHandling = new EventGeneratorForAutomaticHandling(deviceController, eventReportGenerator);
//        eventGeneratorForHandlingByPerson.generateEvent();
//        eventGeneratorForAutomaticHandling.generateEvent();
//
//        eventReportGenerator.generateReport();




        try {
            House house = ConfigBuilder.buildHouseFromJson("config/config1.json");
            System.out.println(house.toString());
            System.out.println(house.getFloors().get(1));

            System.out.println(house.getFloors().get(1).getRooms().get(0).getDevices());

            System.out.println(house.getFloors().get(1).getRooms().get(1).getDevices());

            List<Device> devices = house.getFloors().stream()
                    .flatMap(floor -> floor.getRooms().stream())
                    .flatMap(room -> room.getDevices().stream())
                    .toList();

            DeviceController controller = new DeviceController(devices);

            List<Person> people = ConfigBuilder.getPeopleFromJson("config/config1.json", controller, house);
            System.out.println(people);
            System.out.println("-------------------");

            EventReportGenerator eventReportGenerator = new EventReportGenerator();

            EventGeneratorForAutomaticHandling automaticHandling = new EventGeneratorForAutomaticHandling(controller, eventReportGenerator);
            EventGeneratorForHandlingByPerson personHandling = new EventGeneratorForHandlingByPerson(people, controller, eventReportGenerator);
            automaticHandling.generateEvent();
            System.out.println("-------------------");
            personHandling.generateEvent();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}