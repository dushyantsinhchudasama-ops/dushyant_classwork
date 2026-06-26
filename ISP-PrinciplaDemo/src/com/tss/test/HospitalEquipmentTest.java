package com.tss.test;

import com.tss.model.*;
import com.tss.services.EquipmentManagementService;
import com.tss.services.MaintenanceService;

public class HospitalEquipmentTest
{
    public static void main(String[] args)
    {
        EquipmentManagementService equipmentService = new EquipmentManagementService();

        MaintenanceService maintenanceService = new MaintenanceService();

        HeartRateMonitor monitor = new HeartRateMonitor("HRM101", "Heart Rate Monitor", EquipmentStatus.ACTIVE);

        MRIMachine mri =new MRIMachine("MRI201","MRI Scanner",EquipmentStatus.ACTIVE);

        Ventilator ventilator =new Ventilator("VEN301","ICU Ventilator",EquipmentStatus.ACTIVE);

        PortableGlucoseMeter glucoseMeter = new PortableGlucoseMeter("GLU401","Glucose Meter",EquipmentStatus.ACTIVE);

        LaboratoryAnalyzer analyzer = new LaboratoryAnalyzer("LAB501", "Lab Analyzer", EquipmentStatus.ACTIVE);

        equipmentService.addEquipment(monitor);
        equipmentService.addEquipment(mri);
        equipmentService.addEquipment(ventilator);
        equipmentService.addEquipment(glucoseMeter);
        equipmentService.addEquipment(analyzer);

        monitor.startMonitoring();
        monitor.transmitData();

        System.out.println();

        mri.calibrate();
        mri.generateReport();

        System.out.println();

        ventilator.startMonitoring();
        ventilator.triggerEmergencyAlert();

        System.out.println();

        glucoseMeter.measureGlucose();

        System.out.println();

        analyzer.analyzeSample();
        analyzer.generateReport();
        analyzer.transmitData();

        System.out.println();

        maintenanceService.performMaintenance( ventilator,ventilator);

        System.out.println();

        equipmentService.displayAllEquipments();

        System.out.println();

        maintenanceService.showMaintenanceRecords();
    }
}