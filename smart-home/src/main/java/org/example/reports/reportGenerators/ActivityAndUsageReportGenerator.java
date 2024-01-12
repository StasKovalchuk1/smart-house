package org.example.reports.reportGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.example.devices.Device;
import org.example.generators.activities.Activity;
import org.example.generators.events.EventToHandle;
import org.example.houseComponents.Floor;
import org.example.houseComponents.rooms.Room;
import org.example.houseResidents.HouseResident;
import org.example.houseResidents.people.Person;
import org.example.houses.House;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@EqualsAndHashCode(callSuper = true)
//@Data
@Slf4j
public class ActivityAndUsageReportGenerator extends BaseReportGenerator {

    private final Map<HouseResident, Activity> houseResidentsActivitiesMap = new HashMap<>();
    private final Map<Integer, Map<Integer, Integer>> deviceUsageMap = new HashMap<>();
    private final House house;


    public ActivityAndUsageReportGenerator(House house) {
        this.house = house;
        this.reportFile = "smart-home/src/main/resources/activityAndUsageReport.txt";
        try {
            this.writer = new PrintWriter(new PrintWriter(reportFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
        fillDeviceUsageMap(house.getPeople());
        fillDeviceUsageMap(house.getPets());
    }

    @Override
    public void generateReport() {
        writer.println("ACTIVITY AND USAGE REPORT");
        writer.println();
        writer.println();
        printDeviceUsage();
        writer.close();
    }

    private void printDeviceUsage(){
        writer.println("DEVICE USAGES:");
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : deviceUsageMap.entrySet()) {
            HouseResident resident = getResidentById(entry.getKey());
            Map<Integer, Integer> deviceUsage = entry.getValue();

            assert resident != null;
            writer.println("House resident " + resident.getType() + " '" + resident.getName()
                    + "' has used devices: ");

            int i = 1;
            for (Map.Entry<Integer, Integer> deviceEntry : deviceUsage.entrySet()) {
                Device device = getDeviceById(deviceEntry.getKey());
                Integer usage = deviceEntry.getValue();
                assert device != null;
                writer.println(i + ") " +device.getName() + " " + usage + " times");
                ++i;
            }
            writer.println();
        }
    }

    public void writeActivity(HouseResident houseResident, Activity activity){
        houseResidentsActivitiesMap.put(houseResident, activity);
    }

    public void writeDeviceUsage(HouseResident houseResident, Device device){
        if (deviceUsageMap.containsKey(houseResident.getId())) {
            Map<Integer, Integer> residentDeviceUsage = deviceUsageMap.get(houseResident.getId());
            if (residentDeviceUsage.containsKey(device.getId())) {
                int deviceUsage = residentDeviceUsage.get(device.getId());
                ++deviceUsage;
                residentDeviceUsage.put(device.getId(), deviceUsage);
                deviceUsageMap.put(houseResident.getId(), residentDeviceUsage);
            }
        }
    }

    private void fillDeviceUsageMap(List<HouseResident> houseResidents){
        for (HouseResident houseResident : houseResidents) {
            deviceUsageMap.put(houseResident.getId(), new HashMap<>());
            Map<Integer, Integer> residentDeviceUsage = deviceUsageMap.get(houseResident.getId());
            for (Floor floor : house.getFloors()) {
                for (Room room : floor.getRooms()) {
                    for (Device device : room.getDevices()){
                        residentDeviceUsage.put(device.getId(), 0);
                    }
                }
            }
        }
    }

    private HouseResident getResidentById(int id){
        List<HouseResident> residents = new ArrayList<>();
        residents.addAll(house.getPeople());
        residents.addAll(house.getPets());
        for (HouseResident resident : residents) {
            if (resident.getId() == id) {
                return resident;
            }
        }
        return null;
    }

    private Device getDeviceById(int id){
        List<Device> devices = house.getDeviceController().getDevices();
        for (Device device : devices) {
            if (device.getId() == id){
                return device;
            }
        }
        return null;
    }
}
