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

    public Simulation(House house,
                      EventGeneratorForAutomaticHandling eventGenAuto,
                      EventGeneratorForHandlingByPerson eventGenPerson,
                      PersonActivityGenerator personActivityGen,
                      PetActivityGenerator petActivityGen,
                      EventReportGenerator eventReportGenerator,
                      ActivityAndUsageReportGenerator activityAndUsageReportGenerator,
                      ConsumptionReportGenerator consumptionReportGenerator,
                      HouseConfigurationReportGenerator houseConfigReportGenerator) {
        this.house = house;
        this.eventGenAuto = eventGenAuto;
        this.eventGenPerson = eventGenPerson;
        this.personActivityGen = personActivityGen;
        this.petActivityGen = petActivityGen;
        this.eventReportGen = eventReportGenerator;
        this.activityAndUsageReportGen = activityAndUsageReportGenerator;
        this.consumptionReportGen = consumptionReportGenerator;
        this.houseConfigReportGen = houseConfigReportGenerator;
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
