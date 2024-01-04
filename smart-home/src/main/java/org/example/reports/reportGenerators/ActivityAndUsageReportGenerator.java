package org.example.reports.reportGenerators;

import lombok.Data;
import org.example.devices.Device;
import org.example.generators.activities.Activity;
import org.example.generators.events.EventToHandle;
import org.example.houseComponents.Floor;
import org.example.houseComponents.rooms.Room;
import org.example.houseResidents.HouseResident;
import org.example.houseResidents.people.Person;
import org.example.houses.House;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ActivityAndUsageReportGenerator extends BaseReportGenerator {

    private Map<HouseResident, Activity> houseResidentsActivitiesMap = new HashMap<>();
    private Map<HouseResident, Map<Device, Integer>> deviceUsageMap = new HashMap<>();
    private House house;


    public ActivityAndUsageReportGenerator(House house) {
        this.house = house;
        this.reportFile = "./src/main/java/org/example/reports/reportsFiles/activityAndUsageReport.txt";
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
        printHouseResidentsActivities();
        writer.println();
        printDeviceUsage();
        writer.close();
    }

    private void printHouseResidentsActivities() {
        writer.println("HOUSE RESIDENT ACTIVITIES:");
        for (Map.Entry<HouseResident, Activity> entry : houseResidentsActivitiesMap.entrySet()) {
            HouseResident resident = entry.getKey();
            Activity activity = entry.getValue();
            writer.println("House resident " + resident.getType() + " '" + resident.getName()
                    + "' has done activity '" + activity + "'");
        }
        writer.println();
    }

    private void printDeviceUsage(){
        writer.println("DEVICE USAGES:");
        for (Map.Entry<HouseResident, Map<Device, Integer>> entry : deviceUsageMap.entrySet()) {
            HouseResident resident = entry.getKey();
            Map<Device, Integer> deviceUsage = entry.getValue();

            writer.println("House resident " + resident.getType() + " '" + resident.getName()
                    + "' has used devices: ");

            int i = 1;
            for (Map.Entry<Device, Integer> deviceEntry : deviceUsage.entrySet()) {
                Device device = deviceEntry.getKey();
                Integer usage = deviceEntry.getValue();
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
        if (deviceUsageMap.containsKey(houseResident)) {
            Map<Device, Integer> residentDeviceUsage = deviceUsageMap.get(houseResident);
            if (residentDeviceUsage.containsKey(device)) {
                int deviceUsage = residentDeviceUsage.get(device);
                ++deviceUsage;
                residentDeviceUsage.put(device, deviceUsage);
            }
        }
    }

    private void fillDeviceUsageMap(List<HouseResident> houseResidents){
        for (HouseResident houseResident : houseResidents) {
            deviceUsageMap.put(houseResident, new HashMap<>());
            Map<Device, Integer> residentDeviceUsage = deviceUsageMap.get(houseResident);
            for (Floor floor : house.getFloors()) {
                for (Room room : floor.getRooms()) {
                    for (Device device : room.getDevices()){
                        residentDeviceUsage.put(device, 0);
                    }
                }
            }
        }
    }
}
