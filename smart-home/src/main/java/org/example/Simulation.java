package org.example;

import org.example.generators.activities.personActivities.PersonActivityGenerator;
import org.example.generators.activities.petActivities.PetActivityGenerator;
import org.example.generators.events.EventGeneratorForAutomaticHandling;
import org.example.generators.events.EventGeneratorForHandlingByPerson;
import org.example.houses.House;
import org.example.reports.reportGenerators.ActivityAndUsageReportGenerator;
import org.example.reports.reportGenerators.ConsumptionReportGenerator;
import org.example.reports.reportGenerators.EventReportGenerator;
import org.example.reports.reportGenerators.HouseConfigurationReportGenerator;

import java.util.Timer;
import java.util.TimerTask;

public class Simulation {

    private final House house;

    //GENERATORS
    private final EventGeneratorForAutomaticHandling eventGenAuto;
    private final EventGeneratorForHandlingByPerson eventGenPerson;
    private final PersonActivityGenerator personActivityGen;
    private final PetActivityGenerator petActivityGen;

    //REPORTS
    private final EventReportGenerator eventReportGen;
    private final ActivityAndUsageReportGenerator activityAndUsageReportGen;
    private final ConsumptionReportGenerator consumptionReportGen;
    private final HouseConfigurationReportGenerator houseConfigReportGen;

    //Simulation Timer
    private final Timer timer;

    public Simulation(House house) {
        this.house = house;
        this.eventReportGen = new EventReportGenerator();
        this.activityAndUsageReportGen = new ActivityAndUsageReportGenerator(house);
        this.consumptionReportGen = new ConsumptionReportGenerator();
        this.houseConfigReportGen = new HouseConfigurationReportGenerator(house);
        this.eventGenAuto = new EventGeneratorForAutomaticHandling(house.getDeviceController(), eventReportGen);
        this.eventGenPerson = new EventGeneratorForHandlingByPerson(house.getPeople(), house.getDeviceController(), eventReportGen);
        this.personActivityGen = new PersonActivityGenerator();
        this.petActivityGen = new PetActivityGenerator();
        timer = new Timer();
    }

    public void runSimulation() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                eventGenAuto.generateEvent();
                eventGenPerson.generateEvent();
                try {
                    personActivityGen.generateActivity();
                    petActivityGen.generateActivity();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                eventReportGen.generateReport();
                activityAndUsageReportGen.generateReport();
                consumptionReportGen.generateReport();
                houseConfigReportGen.generateReport();
            }
        }, 0, 10000); // Repeat every 10 seconds
    }

    public void stopSimulation(){
        timer.cancel();
    }
}
