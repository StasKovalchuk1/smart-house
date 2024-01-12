package org.example.reports.reportGenerators;

import lombok.Data;
import org.example.devices.Device;
import org.example.devices.DeviceController;

import java.io.PrintWriter;

@Data
public class ConsumptionReportGenerator extends BaseReportGenerator {

    private final DeviceController deviceController;

    public ConsumptionReportGenerator(DeviceController deviceController) {
        this.deviceController = deviceController;
        this.reportFile = "./src/main/resources/consumptionReport.txt";
        try {
            this.writer = new PrintWriter(new PrintWriter(reportFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateReport() {
        writer.println("CONSUMPTION REPORT");
        writer.println();
        printGeneralConsumption();
        printEachDeviceConsumption();
        writer.close();
    }

    private void printGeneralConsumption(){
        writer.println("GENERAL CONSUMPTION:");
        writer.println("Total water consumption: " + deviceController.getTotalWaterConsumption());
        writer.println("Total gas consumption: " + deviceController.getTotalGasConsumption());
        writer.println("Total electricity consumption: " + deviceController.getTotalElectricityConsumption());
        writer.println("---");
    }

    private void printEachDeviceConsumption(){
        writer.println("DEVICES CONSUMPTION:");
        for (Device device : deviceController.getDevices()) {
            writer.println("Device '" + device.getName() + "' consumption:");
            writer.println("Water: " + device.getTotalWaterConsumption());
            writer.println("Gas: " + device.getTotalGasConsumption());
            writer.println("Electricity: " + device.getTotalElectricityConsumption());
            writer.println();
        }
    }
}
