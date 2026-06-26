package com.tss.model;


import com.tss.interfaces.Calibratable;
import com.tss.interfaces.DataTransmittable;
import com.tss.interfaces.DiagnosticCapable;
import com.tss.interfaces.Loggable;
import com.tss.services.ActivityLogger;
import com.tss.test.EquipmentStatus;

public class LaboratoryAnalyzer extends Equipment
        implements DiagnosticCapable,
        Calibratable,
        DataTransmittable,
        Loggable
{
    private ActivityLogger logger;

    public LaboratoryAnalyzer(String equipmentId,
                              String equipmentName,
                              EquipmentStatus status)
    {
        super(equipmentId, equipmentName, status);
        this.logger = new ActivityLogger();
    }

    public void analyzeSample()
    {
        System.out.println("Medical sample analyzed.");
        recordActivity("Sample analyzed.");
    }

    @Override
    public void generateReport()
    {
        System.out.println("Laboratory report generated.");
        recordActivity("Report generated.");
    }

    @Override
    public void calibrate()
    {
        System.out.println("Analyzer calibrated.");
        recordActivity("Calibration completed.");
    }

    @Override
    public void transmitData()
    {
        System.out.println("Report transmitted to server.");
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