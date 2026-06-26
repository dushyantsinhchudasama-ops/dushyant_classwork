package com.tss.model;


import com.tss.interfaces.*;
import com.tss.services.ActivityLogger;
import com.tss.test.EquipmentStatus;

public class Ventilator extends Equipment
        implements Monitorable,
        EmergencyAlertCapable,
        StatusDisplayable,
        Maintainable,
        Loggable
{
    private ActivityLogger logger;

    public Ventilator(String equipmentId,
                      String equipmentName,
                      EquipmentStatus status)
    {
        super(equipmentId, equipmentName, status);
        this.logger = new ActivityLogger();
    }

    @Override
    public void startMonitoring()
    {
        System.out.println("Ventilator monitoring started.");
        recordActivity("Monitoring started.");
    }

    @Override
    public void stopMonitoring()
    {
        System.out.println("Ventilator monitoring stopped.");
        recordActivity("Monitoring stopped.");
    }

    @Override
    public void triggerEmergencyAlert()
    {
        System.out.println("Emergency alert triggered.");
        recordActivity("Emergency alert triggered.");
    }

    @Override
    public void displayStatus()
    {
        System.out.println(this);
    }

    @Override
    public void performMaintenance()
    {
        System.out.println("Maintenance completed.");
        recordActivity("Maintenance completed.");
    }

    @Override
    public void recordActivity(String activity)
    {
        logger.addLog(activity);
    }

    public void showLogs()
    {
        logger.showLogs();
    }
}