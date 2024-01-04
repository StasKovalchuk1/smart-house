package org.example.houseResidents;

import lombok.Data;
import org.example.devices.DeviceController;
import org.example.generators.activities.Activity;
import org.example.generators.activities.ActivityStrategy;
import org.example.houses.House;
import org.example.reports.reportGenerators.ActivityAndUsageReportGenerator;

@Data
public abstract class HouseResident {

    protected ActivityStrategy strategy;
    protected final DeviceController deviceController;
    protected ActivityAndUsageReportGenerator activityAndUsageReportGenerator;
    protected final String name;
    protected final House house;
    protected final ResidentType type;

    public HouseResident() {
        this.deviceController = null;
        this.name = null;
        this.house = null;
        this.type = null;
    }

    public HouseResident(DeviceController deviceController, String name, House house, ResidentType type) {
        this.deviceController = deviceController;
        this.name = name;
        this.house = house;
        this.type = type;
    }

    protected abstract void doActivity(Activity activity) throws Exception;
//    protected abstract Device getDeviceByActivity(Activity activity);
    protected abstract ActivityStrategy getStrategyByActivity(Activity activity);
}
