package org.example.reports.reportGenerators;

import lombok.Data;
import org.example.houseComponents.Floor;
import org.example.houseComponents.rooms.Room;
import org.example.houseResidents.people.Person;
import org.example.houseResidents.pets.Pet;
import org.example.houses.House;

import java.io.PrintWriter;

@Data
public class HouseConfigurationReportGenerator extends BaseReportGenerator {

    private House house;

    public HouseConfigurationReportGenerator(House house) {
        this.house = house;
        this.reportFile = "./src/main/resources/houseConfigReport.txt";
        try {
            this.writer = new PrintWriter(new PrintWriter(reportFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateReport() {
        writer.println("House configuration report.");
        writer.println("");
        printHouseInfo();
        printFloorsInfo();
        printRoomsInfo();
        printDevicesInfo();

        printPeopleInfo();
        printPetsInfo();
        writer.close();
    }

    private void printHouseInfo(){
        writer.println("HOUSE INFO:");
        writer.println("Type Of House: " + house.getType());
        writer.println("Amount of resident: " + house.getPeople().size());
        writer.println("Amount of pets: " + house.getPets().size());
        writer.println("Amount of floors: " + house.getFloors().size());
        writer.println("");
    }

    private void printPeopleInfo(){
        writer.println("PEOPLE INFO: ");
        for (int i = 0; i < house.getPeople().size(); ++i) {
            Person person = (Person)house.getPeople().get(i);
            writer.println(i+1 + ") " + person.getType()+ ": " + person.getName());
        }
        writer.println("");
    }

    private void printPetsInfo(){
        writer.println("PETS INFO: ");
        for (int i = 0; i < house.getPets().size(); ++i) {
            Pet pet = (Pet)house.getPets().get(i);
            writer.println(i+1 + ") " + pet.getType()+ ": " + pet.getName());
        }
        writer.println("");
    }

    private void printFloorsInfo(){
        writer.println("FLOORS INFO:");
        for (Floor floor : house.getFloors()) {
            writer.println("Floor " + floor.getLevel() + ") contains " + floor.getRooms().size() + " rooms");
        }
        writer.println("");
    }

    private void printRoomsInfo(){
        writer.println("ROOMS INFO:");
        for (Floor floor : house.getFloors()) {
            writer.println("ROOMS ON THE FLOOR " + floor.getLevel() + ":");
            for (Room room : floor.getRooms()) {
                writer.println("Room " + room.getType() + " has " + room.getDevices().size() + " devices");
            }
            writer.println("---");
        }
        writer.println("");
    }

    private void printDevicesInfo(){
        writer.println("DEVICES INFO:");
        for (Floor floor : house.getFloors()) {
            writer.println("ON THE FLOOR " + floor.getLevel());
            for (Room room : floor.getRooms()) {
                writer.println("IN THE ROOM: " + room.getType());
                for (int i = 0; i < room.getDevices().size(); ++i) {
                    writer.println(i+1 + ") " + room.getDevices().get(i).getName());
                }
            }
            writer.println("---");
        }
        writer.println("");

    }




}
