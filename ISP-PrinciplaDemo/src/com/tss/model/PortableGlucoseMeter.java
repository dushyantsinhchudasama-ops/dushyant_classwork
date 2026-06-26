package com.tss.model;


import com.tss.interfaces.Loggable;
import com.tss.interfaces.StatusDisplayable;
import com.tss.services.ActivityLogger;
import com.tss.test.EquipmentStatus;

public class PortableGlucoseMeter extends Equipment
        implements StatusDisplayable,
        Loggable
{
    private ActivityLogger logger;

    public PortableGlucoseMeter(String equipmentId,
                                String equipmentName,
                                EquipmentStatus status)
    {
        super(equipmentId, equipmentName, status);
        this.logger = new ActivityLogger();
    }

    public void measureGlucose()
    {
        System.out.println("Glucose level measured.");
        recordActivity("Glucose measurement performed.");
    }

    @Override
    public void displayStatus()
    {
        System.out.println(this);
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
