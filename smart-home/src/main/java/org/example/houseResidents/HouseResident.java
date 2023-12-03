package org.example.houseResidents;

import lombok.Data;
import org.example.devices.Device;
import org.example.generators.activities.Activity;
import org.example.generators.activities.ActivityStrategy;

@Data
public abstract class HouseResident {

    protected ActivityStrategy strategy;

    protected abstract void doActivity(Activity activity) throws Exception;
    protected abstract Device getDeviceByActivity(Activity activity);
    protected abstract ActivityStrategy getStrategyByActivity(Activity activity);
}
