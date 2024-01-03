package org.example.houses;

import lombok.Data;
import org.example.houseComponents.Floor;
import org.example.houseResidents.HouseResident;
import org.example.houseResidents.people.Person;
import org.example.houseResidents.pets.Pet;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class House {
    private HouseType type;

    protected List<Floor> floors;
    protected List<HouseResident> people;
    protected List<HouseResident> pets;

    public void addFloor(Floor floor) {
        if (floors == null) floors = new ArrayList<>();
        floors.add(floor);
    }

    public void addPerson(Person resident) {
        if (people == null) people = new ArrayList<>();
        people.add(resident);
    }

    public void addPet(Pet pet){
        if (pets == null) pets = new ArrayList<>();
        pets.add(pet);
    }
}
