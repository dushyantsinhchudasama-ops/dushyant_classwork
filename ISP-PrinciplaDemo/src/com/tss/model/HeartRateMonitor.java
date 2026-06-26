package com.tss.model;


import com.tss.interfaces.DataTransmittable;
import com.tss.interfaces.Loggable;
import com.tss.interfaces.Monitorable;
import com.tss.interfaces.StatusDisplayable;
import com.tss.services.ActivityLogger;
import com.tss.test.EquipmentStatus;

public class HeartRateMonitor extends Equipment
        implements Monitorable,
        StatusDisplayable,
        DataTransmittable,
        Loggable
{
    private ActivityLogger logger;

    public HeartRateMonitor(String equipmentId,
                            String equipmentName,
                            EquipmentStatus status)
    {
        super(equipmentId, equipmentName, status);
        this.logger = new ActivityLogger();
    }

    @Override
    public void startMonitoring()
    {
        System.out.println("Heart rate monitoring started.");
        recordActivity("Started monitoring.");
    }

    @Override
    public void stopMonitoring()
    {
        System.out.println("Heart rate monitoring stopped.");
        recordActivity("Stopped monitoring.");
    }

    @Override
    public void displayStatus()
    {
        System.out.println(this);
    }

    @Override
    public void transmitData()
    {
        System.out.println("Heart rate data transmitted.");
        recordActivity("Data transmitted.");
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