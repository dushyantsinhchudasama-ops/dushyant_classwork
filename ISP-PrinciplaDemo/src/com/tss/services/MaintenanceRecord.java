package com.tss.services;


import java.time.LocalDate;

public class MaintenanceRecord
{
    private String equipmentId;
    private LocalDate maintenanceDate;

    public MaintenanceRecord(String equipmentId,LocalDate maintenanceDate)
    {
        this.equipmentId = equipmentId;
        this.maintenanceDate = maintenanceDate;
    }

    public String getEquipmentId()
    {
        return equipmentId;
    }

    public LocalDate getMaintenanceDate()
    {
        return maintenanceDate;
    }

    @Override
    public String toString()
    {
        return "Equipment ID = " + equipmentId +
                ", Maintenance Date = " + maintenanceDate;
    }
}