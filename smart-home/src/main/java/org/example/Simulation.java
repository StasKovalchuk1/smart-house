package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.factory.DeviceManager;
import org.example.generators.activities.personActivities.PersonActivityGenerator;
import org.example.generators.activities.petActivities.PetActivityGenerator;
import org.example.generators.events.EventGeneratorForAutomaticHandling;
import org.example.generators.events.EventGeneratorForHandlingByPerson;
import org.example.houses.House;
import org.example.reports.reportGenerators.ActivityAndUsageReportGenerator;
import org.example.reports.reportGenerators.ConsumptionReportGenerator;
import org.example.reports.reportGenerators.EventReportGenerator;
import org.example.reports.reportGenerators.HouseConfigurationReportGenerator;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
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
    private boolean simulationRunning = true;


    public Simulation(House house) {
        this.house = house;
        this.eventReportGen = new EventReportGenerator();
        this.activityAndUsageReportGen = new ActivityAndUsageReportGenerator(house);
        this.consumptionReportGen = new ConsumptionReportGenerator(house.getDeviceController());
        this.houseConfigReportGen = new HouseConfigurationReportGenerator(house);
        this.eventGenAuto = new EventGeneratorForAutomaticHandling(house.getDeviceController(), eventReportGen);
        this.eventGenPerson = new EventGeneratorForHandlingByPerson(house.getPeople(), house.getDeviceController(), eventReportGen);
        this.personActivityGen = new PersonActivityGenerator(house.getPeople());
        this.petActivityGen = new PetActivityGenerator(house.getPets());
        timer = new Timer();

        // может надо исправить
        house.getPeople().forEach(resident -> resident.setActivityAndUsageReportGenerator(activityAndUsageReportGen));
        house.getPets().forEach(resident -> resident.setActivityAndUsageReportGenerator(activityAndUsageReportGen));
    }

    public void runSimulation() {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        //Program will be working for 20 seconds
        executorService.schedule(() -> {
            stopSimulation();
            executorService.shutdown();
        }, 20, TimeUnit.SECONDS);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                log.info("------------Proceed to event for controller------------");
                eventGenAuto.generateEvent();
                System.out.println("-----------------------------");
                log.info("------------Proceed to event for people------------");
                eventGenPerson.generateEvent();
                System.out.println("-----------------------------");
                try {
                    log.info("------------Proceed to person activity------------");
                    personActivityGen.generateActivity();
                    System.out.println("-----------------------------");
                    log.info("------------Proceed to pet activity------------");
                    petActivityGen.generateActivity();
                    System.out.println("-----------------------------");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                log.info("------------Proceed to control consumption------------");
                house.getDeviceController().controlEnergyConsumption();
                System.out.println("-----------------------------");
                log.info("------------Proceed to receiving notification------------");
                house.getDeviceController().getDeviceManagers().forEach(DeviceManager::collectData);
                System.out.println("---------------------------------");
            }
        }, 0, 1000);// Repeat every 10 seconds
    }

    public void stopSimulation(){
        timer.cancel();
        eventReportGen.generateReport();
        activityAndUsageReportGen.generateReport();
        consumptionReportGen.generateReport();
        houseConfigReportGen.generateReport();
    }
}
