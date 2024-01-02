package org.example.houses;

import lombok.Data;
import org.example.houseComponents.Floor;
import org.example.houseResidents.people.Person;
import org.example.houseResidents.pets.Pet;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class House {
    private HouseType type;

    protected List<Floor> floors;
    protected List<Person> residents;
    protected List<Pet> pets;

    public void addFloor(Floor floor) {
        if (floors == null) floors = new ArrayList<>();
        floors.add(floor);
    }

    public void addResident(Person resident) {
        if (residents == null) residents = new ArrayList<>();
        residents.add(resident);
    }

    public void addPet(Pet pet){
        if (pets == null) pets = new ArrayList<>();
        pets.add(pet);
    }
}
