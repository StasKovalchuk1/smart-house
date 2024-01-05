package org.example.houseResidents;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.devices.DeviceController;
import org.example.generators.activities.Activity;
import org.example.generators.activities.ActivityStrategy;
import org.example.houses.House;
import org.example.reports.reportGenerators.ActivityAndUsageReportGenerator;

@Data
public abstract class HouseResident {

    protected ActivityStrategy strategy;
//    protected final DeviceController deviceController;
    protected ActivityAndUsageReportGenerator activityAndUsageReportGenerator;
    protected final String name;
    protected House house;
    protected final ResidentType type;

    public HouseResident() {
        this.name = null;
        this.house = null;
        this.type = null;
    }

    public HouseResident(String name, House house, ResidentType type) {
        this.name = name;
        this.house = house;
        this.type = type;
    }

    protected abstract void doActivity(Activity activity) throws Exception;
//    protected abstract Device getDeviceByActivity(Activity activity);
    protected abstract ActivityStrategy getStrategyByActivity(Activity activity);
}
