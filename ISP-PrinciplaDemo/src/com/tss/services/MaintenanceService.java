package com.tss.services;


import com.tss.interfaces.Maintainable;
import com.tss.model.Equipment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MaintenanceService
{
    private List<MaintenanceRecord> records;

    public MaintenanceService()
    {
        records = new ArrayList<>();
    }

    public void performMaintenance(Equipment equipment,Maintainable maintainable)
    {
        maintainable.performMaintenance();

        records.add(new MaintenanceRecord(equipment.getEquipmentId(),LocalDate.now()));
    }

    public void showMaintenanceRecords()
    {
        for (MaintenanceRecord record : records)
        {
            System.out.println(record);
        }
    }
}