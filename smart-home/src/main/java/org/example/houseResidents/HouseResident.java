package org.example.houseResidents;

import lombok.Data;
import org.example.generators.activities.Activity;
import org.example.generators.activities.ActivityStrategy;
import org.example.houses.House;
import org.example.reports.reportGenerators.ActivityAndUsageReportGenerator;

import java.util.Objects;

@Data
public abstract class HouseResident {

    protected final Integer id;
    protected ActivityStrategy strategy;
    protected ActivityAndUsageReportGenerator activityAndUsageReportGenerator;
    protected final String name;
    protected House house;
    protected final ResidentType type;

    public HouseResident() {
        this.id = null;
        this.name = null;
        this.house = null;
        this.type = null;
    }

    public HouseResident(Integer id, String name, House house, ResidentType type) {
        this.id = id;
        this.name = name;
        this.house = house;
        this.type = type;
    }

    protected abstract void doActivity(Activity activity) throws Exception;
//    protected abstract Device getDeviceByActivity(Activity activity);
    protected abstract ActivityStrategy getStrategyByActivity(Activity activity);

}
