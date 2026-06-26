package com.tss.model;

import com.tss.interfaces.Calibratable;
import com.tss.interfaces.DiagnosticCapable;
import com.tss.interfaces.Loggable;
import com.tss.interfaces.StatusDisplayable;
import com.tss.services.ActivityLogger;
import com.tss.test.EquipmentStatus;

public class MRIMachine extends Equipment
        implements DiagnosticCapable,
        Calibratable,
        StatusDisplayable,
        Loggable
{
    private ActivityLogger logger;

    public MRIMachine(String equipmentId,
                      String equipmentName,
                      EquipmentStatus status)
    {
        super(equipmentId, equipmentName, status);
        this.logger = new ActivityLogger();
    }

    @Override
    public void generateReport()
    {
        System.out.println("MRI diagnostic report generated.");
        recordActivity("Report generated.");
    }

    @Override
    public void calibrate()
    {
        System.out.println("MRI machine calibrated.");
        recordActivity("Calibration performed.");
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
